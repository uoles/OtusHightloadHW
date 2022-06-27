package ru.uoles.proj.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 01.04.2022
 * Time: 21:07
 */
@Data
@ToString
public class Authorization {

    private String login;
    private String password;
    private String error;

    public Authorization() {
    }

    public Authorization(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Authorization(String login, String password, String error) {
        this.login = login;
        this.password = password;
        this.error = error;
    }
}
