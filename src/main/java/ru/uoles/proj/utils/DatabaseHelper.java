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

    public static Message getNewMessageTemplate(final Dialog dialog) {
        Message message = new Message();
        message.setGuid(DatabaseHelper.getNewGUID());
        message.setDialogGuid(dialog.getDialogGuid());
        message.setSenderGuid(dialog.getPersonGuid());
        message.setRecipientGuid(dialog.getRecipientGuid());
        return message;
    }
}
