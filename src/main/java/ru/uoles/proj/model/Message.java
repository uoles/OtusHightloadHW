package ru.uoles.proj.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class Message {

    private String guid;
    private Date dateTime;
    private String gialogGuid;
    private String senderGuid;
    private String recipientGuid;
    private String message;

    public Message() {
    }

    public Message(String guid, Date dateTime, String gialogGuid, String senderGuid, String recipientGuid, String message) {
        this.guid = guid;
        this.dateTime = dateTime;
        this.gialogGuid = gialogGuid;
        this.senderGuid = senderGuid;
        this.recipientGuid = recipientGuid;
        this.message = message;
    }
}
