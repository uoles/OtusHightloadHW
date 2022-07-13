package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uoles.proj.database.dao.DialogDao;
import ru.uoles.proj.database.dao.PersonDao;
import ru.uoles.proj.model.Dialog;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.utils.DatabaseHelper;

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

    @Override
    public List<Dialog> getAllDialogs(final String personGuid, final int count) {
        return dialogDialogDao.getAllDialogs(personGuid, count);
    }

    @Override
    public Dialog getDialog(final String personGuid, final String recipientGuid) {
        return dialogDialogDao.getDialog(personGuid, recipientGuid);
    }

    @Override
    public Dialog addDialog(final String personGuid, final String recipientGuid) {
        Dialog dialog = dialogDialogDao.getDialog(personGuid, recipientGuid);
        if (Objects.isNull(dialog)) {
            Person person = personDao.findByGuid(recipientGuid);
            String recipientFullName = String.join(" ", person.getFirstName(), person.getSecondName());

            dialog = new Dialog(DatabaseHelper.getNewGUID(), personGuid, recipientGuid, recipientFullName);
            dialogDialogDao.addDialog(dialog);
        }
        return dialog;
    }
}
