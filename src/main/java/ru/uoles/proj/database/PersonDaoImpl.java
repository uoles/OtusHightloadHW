package ru.uoles.proj.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.model.Person;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
@Repository
public class PersonDaoImpl implements PersonDao<Person> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
