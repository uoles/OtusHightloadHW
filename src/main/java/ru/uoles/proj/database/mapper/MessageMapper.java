package ru.uoles.proj.database.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.uoles.proj.model.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 28.06.2022
 * Time: 17:05
 */
public class MessageMapper implements RowMapper<Message> {

    private static final String GUID = "guid";
    private static final String DATE_TIME = "date_time";
    private static final String DIALOG_GUID = "dialog_guid";
    private static final String SENDER_GUID = "sender_guid";
    private static final String RECIPIENT_GUID = "recipient_guid";
    private static final String MESSAGE = "message";

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String guid = rs.getString(GUID);

        final Timestamp timestamp = rs.getTimestamp(DATE_TIME);
        final Date dateTime = new Date(timestamp.getTime());

        final String dialogGuid = rs.getString(DIALOG_GUID);
        final String senderGuid = rs.getString(SENDER_GUID);
        final String recipientGuid = rs.getString(RECIPIENT_GUID);
        final String message = rs.getString(MESSAGE);

        return new Message(guid, dateTime, dialogGuid, senderGuid, recipientGuid, message);
    }
}