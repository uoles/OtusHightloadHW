package ru.uoles.proj.model;

import lombok.Data;
import lombok.ToString;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 31.03.2022
 * Time: 11:10
 */
@Data
@ToString
public class PersonAccess {

    private String personGuid;
    private String login;
    private byte[] secretByteArray;
    private byte[] saltByteArray;

    public PersonAccess() {
    }

    public PersonAccess(String personGuid, String login, byte[] secretByteArray, byte[] saltByteArray) {
        this.personGuid = personGuid;
        this.login = login;
        this.secretByteArray = secretByteArray;
        this.saltByteArray = saltByteArray;
    }
}
