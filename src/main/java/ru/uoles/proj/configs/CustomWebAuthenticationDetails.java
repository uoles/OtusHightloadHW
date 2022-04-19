package ru.uoles.proj.configs;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 19.04.2022
 * Time: 20:07
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    private String personGuid;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
    }

    public String getPersonGuid() {
        return personGuid;
    }

    public void setPersonGuid(String personGuid) {
        this.personGuid = personGuid;
    }
}
