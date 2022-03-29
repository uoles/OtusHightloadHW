package ru.uoles.proj.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao<Person> {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
