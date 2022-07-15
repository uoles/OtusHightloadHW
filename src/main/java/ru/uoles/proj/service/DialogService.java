package ru.uoles.proj.service;

import ru.uoles.proj.model.Message;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 13.07.2022
 * Time: 0:05
 */
public interface DialogService<Dialog> {

    List<Dialog> getAllDialogs(final String personGuid, final int count);

    Dialog getDialog(final String guid);

    Dialog addDialog(final String personGuid, final String recipientGuid);

    void addMessage(final Message message);
}
