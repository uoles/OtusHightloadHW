package ru.uoles.proj.utils;

import ru.uoles.proj.model.Dialog;
import ru.uoles.proj.model.Message;

import java.util.UUID;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 02.04.2022
 * Time: 19:54
 */
public final class DatabaseHelper {

    private DatabaseHelper() {
    }

    public static String getNewGUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Message getNewMessageTemplate(final Dialog dialog, final String personGuid) {
        Message message = new Message();
        message.setGuid(DatabaseHelper.getNewGUID());
        message.setDialogGuid(dialog.getGuid());
        message.setSenderGuid(personGuid);
        message.setRecipientGuid(
                personGuid.equals(dialog.getRecipientGuid())
                    ? dialog.getPersonGuid()
                    : personGuid
        );
        return message;
    }
}
