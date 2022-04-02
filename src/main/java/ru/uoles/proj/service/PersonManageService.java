package ru.uoles.proj.service;

import org.springframework.shell.standard.ShellOption;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
public interface PersonManageService<Person> {

    Person findByGuid(final String guid);

    String addPerson(final String firstName, final String secondName, final String nickName,
                     final String info, final int age, final String gender,
                     final String town
    );
}
