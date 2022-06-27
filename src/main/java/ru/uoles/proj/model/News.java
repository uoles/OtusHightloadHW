package ru.uoles.proj.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 27.06.2022
 * Time: 11:45
 */
@Data
@ToString
@EqualsAndHashCode
public class News {

    private String guid;
    private Date newsDateTime;
    private String personGuid;
    private String newsBody;

    public News() {
    }

    public News(String guid, Date newsDateTime, String personGuid, String newsBody) {
        this.guid = guid;
        this.newsDateTime = newsDateTime;
        this.personGuid = personGuid;
        this.newsBody = newsBody;
    }
}
