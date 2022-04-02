package ru.uoles.proj.database;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.database.mapper.PersonAccessMapper;
import ru.uoles.proj.model.PersonAccess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 02.04.2022
 * Time: 11:39
 */
@Repository
@RequiredArgsConstructor
public class PersonAccessDaoImpl implements PersonAccessDao<PersonAccess> {

    private static final String FIND_BY_LOGIN =
            "select person_guid, secret, salt " +
                    " from PersonAccess " +
                    " where login = :login and status = 1";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public PersonAccess findByLogin(final String login) {
        List<PersonAccess> result = namedParameterJdbcTemplate.query(
                FIND_BY_LOGIN,
                loginToParams(login),
                new PersonAccessMapper()
        );

        return (CollectionUtils.isNotEmpty(result))
                ? result.get(0)
                : null;
    }

    @Override
    public PersonAccess add(final PersonAccess personAccess) {
        return null;
    }

    private Map<String, Object> loginToParams(final String login) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        return params;
    }
}
