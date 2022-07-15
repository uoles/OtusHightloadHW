package ru.uoles.proj.database.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.database.mapper.MessageMapper;
import ru.uoles.proj.model.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 14.07.2022
 * Time: 11:26
 */
@Repository
@PropertySource(name="sqlMessages", value= "classpath:db/sql/messages.xml")
public class MessageDaoImpl implements MessageDao<Message> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${add.message}")
    private String ADD_MESSAGE;

    @Value("${get.all.messages}")
    private String GET_ALL_MESSAGES;

    public MessageDaoImpl(@Qualifier("masterNamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addMessage(final Message message) {
        namedParameterJdbcTemplate.update(
                ADD_MESSAGE,
                messageToParams(message)
        );
    }

    @Override
    public List<Message> getMessages(final String dialogGuid, final int count) {
        return namedParameterJdbcTemplate.query(
                GET_ALL_MESSAGES,
                dialogGuidToParams(dialogGuid, count),
                new MessageMapper()
        );
    }

    private Map<String, Object> messageToParams(final Message message) {
        Map<String, Object> params = new HashMap<>();
        params.put("guid", message.getGuid());
        params.put("dialog_guid", message.getDialogGuid());
        params.put("sender_guid", message.getSenderGuid());
        params.put("recipient_guid", message.getRecipientGuid());
        params.put("message", message.getMessage());
        return params;
    }

    private Map<String, Object> dialogGuidToParams(final String dialogGuid, final int count) {
        Map<String, Object> params = new HashMap<>();
        params.put("dialog_guid", dialogGuid);
        params.put("cnt", count);
        return params;
    }
}
