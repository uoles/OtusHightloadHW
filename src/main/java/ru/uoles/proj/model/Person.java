package ru.uoles.proj.model;

import lombok.Data;

@Data
public class Person {

    private String name;
    private String surname;
    private String nick;
    private String bio;
    private int age;
    private String gender;
    private String maritalStatus;

    public Person() {
    }

    public Person(String name, String surname, String nick, String bio, int age, String gender, String maritalStatus) {
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.bio = bio;
        this.age = age;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }
}
