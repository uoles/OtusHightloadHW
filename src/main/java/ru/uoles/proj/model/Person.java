package ru.uoles.proj.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
@Data
@ToString
public class Person {

    private String guid;
    private Date registrationDate;
    private Date dissolutionDate;
    private int permissionsId;
    private String firstName;
    private String secondName;
    private String nickName;
    private String info;
    private int age;
    private String gender;
    private String town;
    private String operation;

    public Person() {
    }

    public Person(String guid, Date registrationDate, Date dissolutionDate, int permissionsId, String firstName, String secondName, String nickName, String info, int age, String gender, String town, String operation) {
        this.guid = guid;
        this.registrationDate = registrationDate;
        this.dissolutionDate = dissolutionDate;
        this.permissionsId = permissionsId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.nickName = nickName;
        this.info = info;
        this.age = age;
        this.gender = gender;
        this.town = town;
        this.operation = operation;
    }
}
