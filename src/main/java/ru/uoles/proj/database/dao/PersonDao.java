package ru.uoles.proj.database.dao;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
public interface PersonDao<Person> {

    Person findByGuid(final String guid);

    void addPerson(final Person person);

    void updatePerson(final Person person);

    List<Person> findNotFriendPersons(final String guid);

    List<Person> findFriendPersons(final String guid);
}
