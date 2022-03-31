package ru.uoles.proj.model;

import lombok.Data;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 31.03.2022
 * Time: 11:10
 */
@Data
public class Security {

    private Long id;
    private Long personId;
    private String login;
    private String secret;
    private String status;

    public Security() {
    }

    public Security(Long id, Long personId, String login, String secret, String status) {
        this.id = id;
        this.personId = personId;
        this.login = login;
        this.secret = secret;
        this.status = status;
    }
}
