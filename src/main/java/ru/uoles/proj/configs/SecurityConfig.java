package ru.uoles.proj.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import ru.uoles.proj.database.dao.PersonAccessDao;
import ru.uoles.proj.model.PersonAccess;

import javax.servlet.http.HttpServletRequest;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 14.04.2022
 * Time: 20:27
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonAccessDao<PersonAccess> personAccessDao;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider();
        provider.setPersonAccessDao(personAccessDao);
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .maximumSessions(3)
                .and()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and()
                .csrf().disable()
            .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/","/index").not().fullyAuthenticated()
                .antMatchers("/login*").not().fullyAuthenticated()
                .antMatchers("/logout*").not().fullyAuthenticated()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/registration/new").not().fullyAuthenticated()
                .antMatchers(HttpMethod.GET, "/css/**", "/image/**").permitAll()
                //Доступ к файлам из ресурсов программы
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .authenticationDetailsSource(authenticationDetailsSource())
                .usernameParameter("login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/person/main")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
                //Инвалидируем сессию при логауте
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                //Удаляем всю информацию с фронта при логауте(т.е. чистим куки, хидеры и т.д.)
                .addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL)));
    }

    // создаем кастомный WebAuthenticationDetails что бы хранить guid пользователя
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource() {
        return new AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>() {
            @Override
            public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
                return new CustomWebAuthenticationDetails(request);
            }
        };
    }
}