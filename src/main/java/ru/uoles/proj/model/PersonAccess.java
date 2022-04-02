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

    private Long personId;
    private byte[] secretByteArray;
    private byte[] saltByteArray;

    public PersonAccess() {
    }

    public PersonAccess(Long personId, byte[] secretByteArray, byte[] saltByteArray) {
        this.personId = personId;
        this.secretByteArray = secretByteArray;
        this.saltByteArray = saltByteArray;
    }
}
