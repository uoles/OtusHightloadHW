package ru.uoles.proj.database.dao;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.database.mapper.DialogMapper;
import ru.uoles.proj.model.Dialog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 13.07.2022
 * Time: 0:10
 */
@Repository
@PropertySource(name="sqlDialogs", value= "classpath:db/sql/dialog.xml")
public class DialogDaoImpl implements DialogDao<Dialog> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${get.all.dialogs}")
    private String GET_ALL_DIALOGS;

    @Value("${get.dialog.by.guid}")
    private String GET_DIALOG_BY_GUID;

    @Value("${get.dialog.by.person.guids}")
    private String GET_DIALOG_BY_PERSON_GUIDS;

    @Value("${add.dialog}")
    private String ADD_DIALOG;

    public DialogDaoImpl(@Qualifier("masterNamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Dialog> getAllDialogs(final String personGuid, final int count) {
        return namedParameterJdbcTemplate.query(
                GET_ALL_DIALOGS,
                personGuidToParams(personGuid, count),
                new DialogMapper()
        );
    }

    @Override
    public Dialog findDialogByPersonGuids(final String personGuid, final String recipientGuid) {
        List<Dialog> result = namedParameterJdbcTemplate.query(
                GET_DIALOG_BY_PERSON_GUIDS,
                guidsToParams(personGuid, recipientGuid),
                new DialogMapper()
        );

        return (CollectionUtils.isNotEmpty(result))
                ? result.get(0)
                : null;
    }

    @Override
    public Dialog getDialogByGuid(final String guid) {
        List<Dialog> result = namedParameterJdbcTemplate.query(
                GET_DIALOG_BY_GUID,
                guidToParams(guid),
                new DialogMapper()
        );

        return (CollectionUtils.isNotEmpty(result))
                ? result.get(0)
                : null;
    }

    @Override
    public void addDialog(final Dialog dialog) {
        namedParameterJdbcTemplate.update(
                ADD_DIALOG,
                dialogToParams(dialog)
        );
    }

    private Map<String, Object> dialogToParams(final Dialog dialog) {
        Map<String, Object> params = new HashMap<>();
        params.put("guid", dialog.getGuid());
        params.put("person_guid", dialog.getPersonGuid());
        params.put("recipient_guid", dialog.getRecipientGuid());
        params.put("recipient_full_name", dialog.getRecipientFullName());
        return params;
    }

    private Map<String, Object> guidsToParams(final String personGuid, final String recipientGuid) {
        Map<String, Object> params = new HashMap<>();
        params.put("person_guid", personGuid);
        params.put("recipient_guid", recipientGuid);
        return params;
    }

    private Map<String, Object> guidToParams(final String guid) {
        Map<String, Object> params = new HashMap<>();
        params.put("guid", guid);
        return params;
    }

    private Map<String, Object> personGuidToParams(final String personGuid, final int count) {
        Map<String, Object> params = new HashMap<>();
        params.put("person_guid", personGuid);
        params.put("cnt", count);
        return params;
    }
}
