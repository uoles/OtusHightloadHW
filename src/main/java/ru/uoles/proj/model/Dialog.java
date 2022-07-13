package ru.uoles.proj.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 09.07.2022
 * Time: 22:44
 */
@Data
@ToString
public class Dialog {

    private String guid;
    private String personGuid;
    private String recipientGuid;
    private String recipientFullName;

    public Dialog() {
    }

    public Dialog(String guid, String personGuid, String recipientGuid, String recipientFullName) {
        this.guid = guid;
        this.personGuid = personGuid;
        this.recipientGuid = recipientGuid;
        this.recipientFullName = recipientFullName;
    }
}
