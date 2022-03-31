package ru.uoles.proj.database.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.uoles.proj.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 31.03.2022
 * Time: 7:04
 */
public class PersonMapper implements RowMapper<Person> {

    private static final String ID = "id";
    private static final String REGISTRATION_DATE = "registration_date";
    private static final String DISSOLUTION_DATE = "dissolution_date";
    private static final String PERMISSIONS_ID = "permissions_id";
    private static final String FIRST_NAME = "first_name";
    private static final String SECOND_NAME = "second_name";
    private static final String LOGIN = "login";
    private static final String SECRET = "secret";
    private static final String INFO = "info";
    private static final String AGE = "age";
    private static final String GENDER = "gender";
    private static final String TOWN = "town";

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong(ID);
        final Date registrationDate = rs.getDate(REGISTRATION_DATE);
        final Date dissolutionDate = rs.getDate(DISSOLUTION_DATE);
        final int permissionsId = rs.getInt(PERMISSIONS_ID);
        final String firstName = rs.getString(FIRST_NAME);
        final String secondName = rs.getString(SECOND_NAME);
        final String login = rs.getString(LOGIN);
        final String secret = rs.getString(SECRET);
        final String info = rs.getString(INFO);
        final int age = rs.getInt(AGE);
        final String gender = rs.getString(GENDER);
        final String town = rs.getString(TOWN);

        return new Person(id, registrationDate, dissolutionDate, permissionsId, firstName, secondName,
                login, secret, info, age, gender, town
        );
    }
}
