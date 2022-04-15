package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.uoles.proj.database.dao.PersonAccessDao;
import ru.uoles.proj.model.PersonAccess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 15.04.2022
 * Time: 20:22
 */
//@Service
@RequiredArgsConstructor
public class PersonAccessService implements UserDetailsService {

    private final PersonAccessDao<PersonAccess> personAccessDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        PersonAccess personAccess = personAccessDao.findByLogin(login);
        if (personAccess == null) {
            throw new UsernameNotFoundException("User not found");
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(
                personAccess.getLogin(),
                "",
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(Collections.singletonList("USER"))
        );
    }

    private static List<GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}