package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import ru.uoles.proj.database.dao.PersonDao;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.model.PersonSearch;
import ru.uoles.proj.types.PersonOperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ru.uoles.proj.utils.SecureHelper.getAuthPersonGUID;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
@Service
@RequiredArgsConstructor
public class PersonManageServiceImpl implements PersonManageService<Person> {

    private final PersonDao<Person> personDao;

    @Override
    public Person findByGuid(final String guid) {
        return personDao.findByGuid(guid);
    }

    @Override
    public Person updatePerson(final Person person) {
        Person existPerson = personDao.findByGuid(person.getGuid());
        if (Objects.isNull(existPerson)) {
            personDao.addPerson(person);
        } else {
            personDao.updatePerson(person);
        }
        person.setOperation(PersonOperationType.UPDATE.getCanonicalName());
        return person;
    }

    @Override
    public List<Person> findNotFriendPersons(final String guid, final int count) {
        return personDao.findNotFriendPersons(guid, count);
    }

    @Override
    public List<Person> findFriendPersons(final String guid, final int count) {
        return personDao.findFriendPersons(guid, count);
    }

    @Override
    public List<Person> findPersons(final PersonSearch personSearch, final int count) {
        List<Person> result = new ArrayList<>();
        if ( StringUtils.isEmpty(personSearch.getFirstName()) && StringUtils.isEmpty(personSearch.getSecondName()) ) {
            result = personDao.findNotFriendPersons(getAuthPersonGUID(), count);
        } else {
            result = personDao.findPersons(personSearch, getAuthPersonGUID(), count);
        }
        return result;
    }

    @Override
    public List<Person> findFriends(final PersonSearch personSearch, final int count) {
        List<Person> result = new ArrayList<>();
        if ( StringUtils.isEmpty(personSearch.getFirstName()) && StringUtils.isEmpty(personSearch.getSecondName()) ) {
            result = personDao.findFriendPersons(personSearch, getAuthPersonGUID(), count);
        }
        return result;
    }
}
