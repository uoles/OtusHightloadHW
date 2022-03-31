package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uoles.proj.database.PersonDao;
import ru.uoles.proj.model.Person;

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
    public Person findById(final Long id) {
        return personDao.findById(id);
    }
}
