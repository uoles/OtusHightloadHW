package ru.uoles.proj.database.dao;

import ru.uoles.proj.model.PersonSearch;

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

    List<Person> findNotFriendPersons(final String guid, final int count);

    List<Person> findFriendPersons(final String guid, final int count);

    List<Person> findPersons(final PersonSearch personSearch, final String guid, final int count);

    List<Person> findFriendPersons(final PersonSearch personSearch, final String guid, final int count);
}
