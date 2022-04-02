package ru.uoles.proj.database.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.uoles.proj.model.PersonAccess;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 02.04.2022
 * Time: 11:58
 */
public class PersonAccessMapper  implements RowMapper<PersonAccess> {

    private static final String PERSON_GUID = "person_guid";
    private static final String LOGIN = "login";
    private static final String SECRET = "secret";
    private static final String SALT = "salt";

    @Override
    public PersonAccess mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String personGuid = rs.getString(PERSON_GUID);
        final String login = rs.getString(LOGIN);

        final Blob secret = rs.getBlob(SECRET);
        byte[] secretByteArray = null;
        try {
            int secretLength = (int) secret.length();
            secretByteArray = secret.getBytes(1, secretLength);
        } finally {
            secret.free();
        }

        final Blob salt = rs.getBlob(SALT);
        byte[] saltByteArray = null;
        try {
            int saltLength = (int) salt.length();
            saltByteArray = salt.getBytes(1, saltLength);
        } finally {
            salt.free();
        }

        return new PersonAccess(personGuid, login, secretByteArray, saltByteArray);
    }
}