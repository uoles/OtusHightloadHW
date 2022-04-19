package ru.uoles.proj.service;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
public interface PersonManageService<Person> {

    Person findByGuid(final String guid);

    Person updatePerson(final Person person);

    List<Person> findNotFriendPersons(final String guid);
}
