package ru.uoles.proj.database;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
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
            "select guid, registration_date, dissolution_date, permissions_id, first_name, second_name, nick_name, info, age, gender, town " +
                    " from Person " +
                    " where guid = :guid";

    private static final String ADD_PERSON =
            "insert into Person(guid, registration_date, dissolution_date, permissions_id, first_name, second_name, nick_name, info, age, gender, town) " +
                    " values(:guid, NOW(), null, 1, :first_name, :second_name, :nick_name, :info, :age, :gender, :town)";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Person findByGuid(final String guid) {
        List<Person> result = namedParameterJdbcTemplate.query(
                FIND_BY_ID,
                guidToParams(guid),
                new PersonMapper()
        );

        return (CollectionUtils.isNotEmpty(result))
                ? result.get(0)
                : null;
    }

    @Override
    public void addPerson(final Person person) {
        namedParameterJdbcTemplate.update(
                ADD_PERSON,
                personToParams(person)
        );
    }

    private Map<String, Object> guidToParams(final String guid) {
        Map<String, Object> params = new HashMap<>();
        params.put("guid", guid);
        return params;
    }

    private Map<String, Object> personToParams(final Person person) {
        Map<String, Object> params = new HashMap<>();
        params.put("guid", person.getGuid());
        params.put("permissions_id", person.getPermissionsId());
        params.put("first_name", person.getFirstName());
        params.put("second_name", person.getSecondName());
        params.put("nick_name", person.getNickName());
        params.put("info", person.getInfo());
        params.put("age", person.getAge());
        params.put("gender", person.getGender());
        params.put("town", person.getTown());
        return params;
    }
}
