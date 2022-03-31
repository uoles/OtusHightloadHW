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

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Date registrationDate = rs.getDate("registration_date");
        final Date dissolutionDate = rs.getDate("dissolution_date");
        final int permissionsId = rs.getInt("permissions_id");
        final String firstName = rs.getString("first_name");
        final String secondName = rs.getString("second_name");
        final String login = rs.getString("login");
        final String secret = rs.getString("secret");
        final String info = rs.getString("info");
        final int age = rs.getInt("age");
        final String gender = rs.getString("gender");
        final String town = rs.getString("town");

        return new Person(id, registrationDate, dissolutionDate, permissionsId, firstName, secondName,
                login, secret, info, age, gender, town
        );
    }
}
