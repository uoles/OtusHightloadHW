package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uoles.proj.database.dao.DialogDao;
import ru.uoles.proj.database.dao.MessageDao;
import ru.uoles.proj.database.dao.PersonDao;
import ru.uoles.proj.model.Dialog;
import ru.uoles.proj.model.Message;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.utils.DatabaseHelper;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 13.07.2022
 * Time: 0:05
 */
@Service
@RequiredArgsConstructor
public class DialogServiceImpl implements DialogService<Dialog> {

    private final DialogDao<Dialog> dialogDialogDao;
    private final PersonDao<Person> personDao;
    private final MessageDao<Message> messageDao;

    @Override
    public List<Dialog> getAllDialogs(final String personGuid, final int count) {
        return dialogDialogDao.getAllDialogs(personGuid, count);
    }

    @Override
    public Dialog getDialog(final String guid) {
        Dialog dialog = dialogDialogDao.getDialogByGuid(guid);
        List<Message> messages = messageDao.getMessages(dialog.getGuid(), 100);

        dialog.setMessages(messages);
        return dialog;
    }

    @Override
    public Dialog addDialog(final String personGuid, final String recipientGuid) {
        Dialog dialog = dialogDialogDao.findDialogByPersonGuids(personGuid, recipientGuid);
        if (Objects.isNull(dialog)) {
            Person person = personDao.findByGuid(recipientGuid);
            String recipientFullName = String.join(" ", person.getFirstName(), person.getSecondName());

            dialog = new Dialog(DatabaseHelper.getNewGUID(), personGuid, recipientGuid, recipientFullName);
            dialogDialogDao.addDialog(dialog);
        }
        return dialog;
    }

    @Override
    public void addMessage(final Message message) {
        messageDao.addMessage(message);
    }
}
