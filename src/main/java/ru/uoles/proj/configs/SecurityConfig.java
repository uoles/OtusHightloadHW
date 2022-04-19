package ru.uoles.proj.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.uoles.proj.database.dao.PersonAccessDao;
import ru.uoles.proj.model.PersonAccess;

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
        http.csrf()
            .disable()
            .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/","/index").not().fullyAuthenticated()
                .antMatchers("/login*").not().fullyAuthenticated()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/registration/new").not().fullyAuthenticated()
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/resources/**").permitAll()
                // доступ к файлам из ресурсов программы
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .usernameParameter("login")
                .defaultSuccessUrl("/person/list")
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
    }
}