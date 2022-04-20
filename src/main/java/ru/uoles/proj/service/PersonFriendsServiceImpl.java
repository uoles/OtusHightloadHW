package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uoles.proj.database.dao.PersonFriendsDao;
import ru.uoles.proj.model.Person;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 19.04.2022
 * Time: 20:50
 */
@Service
@RequiredArgsConstructor
public class PersonFriendsServiceImpl implements PersonFriendsService<Person> {

    private final PersonFriendsDao<Person> personFriendsDao;

    @Override
    public boolean findFriend(final String personGuid, final String friendGuid){
        return personFriendsDao.findFriend(personGuid, friendGuid);
    }

    @Override
    public void addFriend(final String personGuid, final String friendGuid){
        boolean isFriendFinds = personFriendsDao.findFriend(personGuid, friendGuid);
        if (!isFriendFinds) {
            personFriendsDao.addFriend(personGuid, friendGuid);
        }
    }

    @Override
    public void deleteFriend(final String personGuid, final String friendGuid){
        boolean isFriendFind = personFriendsDao.findFriend(personGuid, friendGuid);
        if (isFriendFind) {
            personFriendsDao.deleteFriend(personGuid, friendGuid);
        }
    }
}
