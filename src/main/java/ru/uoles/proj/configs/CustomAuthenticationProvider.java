package ru.uoles.proj.configs;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import ru.uoles.proj.database.dao.PersonAccessDao;
import ru.uoles.proj.model.PersonAccess;
import ru.uoles.proj.model.PersonAccessDetails;
import ru.uoles.proj.utils.SecureHelper;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 15.04.2022
 * Time: 22:03
 */
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    private PersonAccessDao<PersonAccess> personAccessDao;

    public PersonAccessDao<PersonAccess> getPersonAccessDao() {
        return this.personAccessDao;
    }

    public void setPersonAccessDao(PersonAccessDao<PersonAccess> personAccessDao) {
        this.personAccessDao = personAccessDao;
    }

    /**
     * <p> The authenticate method to authenticate the request. We will get the username from the Authentication object and will
     * use the custom @userDetailsService service to load the given user.</p>
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
        if (StringUtils.isEmpty(username)) {
            throw new BadCredentialsException("invalid login details");
        }
        // get user details using Spring security user details service
        PersonAccessDetails user = null;
        PersonAccess personAccess = null;
        boolean authenticate = false;
        try {
            personAccess = getPersonAccessDao().findByLogin(username);

            authenticate = SecureHelper.authenticate(
                    authentication.getCredentials().toString(),
                    personAccess.getSecretByteArray(),
                    personAccess.getSaltByteArray()
            );
        } catch (UsernameNotFoundException | NoSuchAlgorithmException | InvalidKeySpecException exception) {
            throw new BadCredentialsException("invalid login details");
        }

        if (authenticate) {
            user = new PersonAccessDetails(personAccess);
        } else {
            throw new BadCredentialsException("invalid password");
        }

        return createSuccessfulAuthentication(authentication, user);
    }

    private Authentication createSuccessfulAuthentication(final Authentication authentication, final PersonAccessDetails user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), authentication.getCredentials(), user.getAuthorities());
        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
        details.setPersonGuid(user.getPersonAccess().getPersonGuid());

        token.setDetails(details);
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
