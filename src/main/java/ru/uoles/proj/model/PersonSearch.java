package ru.uoles.proj.model;

import lombok.Data;
import lombok.ToString;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 28.04.2022
 * Time: 21:06
 */
@Data
@ToString
public class PersonSearch {

    private String firstName;
    private String secondName;

    public PersonSearch() {
    }

    public PersonSearch(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
