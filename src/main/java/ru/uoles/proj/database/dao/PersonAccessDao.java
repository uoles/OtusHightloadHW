package ru.uoles.proj.database.dao;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 02.04.2022
 * Time: 11:38
 */
public interface PersonAccessDao<PersonAccess> {

    PersonAccess findByLogin(final String login);

    void addPersonAccess(final PersonAccess personAccess);
}
