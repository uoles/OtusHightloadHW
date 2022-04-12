package ru.uoles.proj.database.dao;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 08.04.2022
 * Time: 16:16
 */
public interface PersonFriendsDao<Person> {

    void addFriend(final String personGuid, final String friendGuid);
}
