package ru.uoles.proj.database.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.uoles.proj.model.Dialog;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 28.06.2022
 * Time: 17:05
 */
public class DialogMapper implements RowMapper<Dialog> {

    private static final String GUID = "guid";
    private static final String PERSON_GUID = "person_guid";
    private static final String RECIPIENT_GUID = "recipient_guid";
    private static final String RECIPIENT_FULL_NAME = "recipient_full_name";

    @Override
    public Dialog mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String guid = rs.getString(GUID);
        final String personGuid = rs.getString(PERSON_GUID);
        final String recipientGuid = rs.getString(RECIPIENT_GUID);
        final String recipientFullName = rs.getString(RECIPIENT_FULL_NAME);

        return new Dialog(guid, personGuid, recipientGuid, recipientFullName);
    }
}
