package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uoles.proj.database.PersonDao;
import ru.uoles.proj.model.Person;

import java.util.UUID;

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
    public String addPerson(final String firstName, final String secondName, final String nickName, final String info,
                          final int age, final String gender, final String town
    ) {
        final String guid = UUID.randomUUID().toString().replaceAll("-", "");

        Person person = new Person();
        person.setGuid(guid);
        person.setFirstName(firstName);
        person.setSecondName(secondName);
        person.setNickName(nickName);
        person.setInfo(info);
        person.setAge(age);
        person.setGender(gender);
        person.setTown(town);

        personDao.addPerson(person);
        return guid;
    }
}
