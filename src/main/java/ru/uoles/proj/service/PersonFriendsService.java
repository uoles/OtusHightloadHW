package ru.uoles.proj.service;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 19.04.2022
 * Time: 20:49
 */
public interface PersonFriendsService<Person> {

    boolean findFriend(String personGuid, String friendGuid);

    void addFriend(String personGuid, String friendGuid);
}
