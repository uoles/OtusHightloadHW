package ru.uoles.proj.database.dao;

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
}
