package ru.uoles.proj.model;

import lombok.Data;

import java.util.Date;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
@Data
public class Person {

    private Long id;
    private Date registrationDate;
    private Date dissolutionDate;
    private int permissionsId;
    private String firstName;
    private String secondName;
    private String login;
    private String secret;
    private String info;
    private int age;
    private String gender;
    private String town;

    public Person() {
    }

    public Person(String firstName, String secondName, String login, String info, int age, String gender, String town) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.info = info;
        this.age = age;
        this.gender = gender;
        this.town = town;
    }

    public Person(Long id, Date registrationDate, Date dissolutionDate, int permissionsId, String firstName, String secondName, String login, String secret, String info, int age, String gender, String town) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.dissolutionDate = dissolutionDate;
        this.permissionsId = permissionsId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.secret = secret;
        this.info = info;
        this.age = age;
        this.gender = gender;
        this.town = town;
    }
}
