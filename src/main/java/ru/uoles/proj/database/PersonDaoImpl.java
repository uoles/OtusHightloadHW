package ru.uoles.proj.database;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import ru.uoles.proj.database.mapper.PersonMapper;
import ru.uoles.proj.model.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
@Repository
@RequiredArgsConstructor
public class PersonDaoImpl implements PersonDao<Person> {

    private static final String FIND_BY_ID =
            "select id, registration_date, dissolution_date, permissions_id, first_name, second_name, login, secret, info, age, gender, town" +
            " from Person " +
            " where id = :id";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Person findById(final Long id) {
        List<Person> result = namedParameterJdbcTemplate.query(
                FIND_BY_ID,
                idToParams(id),
                new PersonMapper()
        );

        return (!CollectionUtils.isEmpty(result))
                ? result.get(0)
                : null;
    }

    private Map<String, Object> idToParams(final Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return params;
    }
}
