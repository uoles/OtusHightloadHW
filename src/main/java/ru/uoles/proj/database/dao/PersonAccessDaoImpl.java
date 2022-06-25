package ru.uoles.proj.database.dao;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.database.mapper.PersonAccessMapper;
import ru.uoles.proj.model.PersonAccess;

import java.sql.Blob;
import java.sql.SQLException;
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
@PropertySource(name="sqlPersonAccess", value="classpath:db/sql/person-access.xml")
public class PersonAccessDaoImpl implements PersonAccessDao<PersonAccess> {

    private final Logger logger = LoggerFactory.getLogger(PersonAccessDaoImpl.class);
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${find.by.login}")
    private String FIND_BY_LOGIN;

    @Value("${add.new.credentials}")
    private String ADD_NEW_CREDENTIALS;

    public PersonAccessDaoImpl(@Qualifier("masterNamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

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
    public void addPersonAccess(final PersonAccess personAccess) {
        try {
            namedParameterJdbcTemplate.update(
                    ADD_NEW_CREDENTIALS,
                    personAccessToParams(personAccess)
            );
        } catch (SQLException e) {
            logger.error("Error: exception adding credentials! Login '{}'", personAccess.getLogin(), e);
        }
    }

    private Map<String, Object> loginToParams(final String login) {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        return params;
    }

    private Map<String, Object> personAccessToParams(final PersonAccess personAccess) throws SQLException {
        Map<String, Object> params = new HashMap<>();

        Blob secret = new javax.sql.rowset.serial.SerialBlob(personAccess.getSecretByteArray());
        Blob salt = new javax.sql.rowset.serial.SerialBlob(personAccess.getSaltByteArray());

        params.put("person_guid", personAccess.getPersonGuid());
        params.put("login", personAccess.getLogin());
        params.put("secret", secret);
        params.put("salt", salt);
        return params;
    }
}
