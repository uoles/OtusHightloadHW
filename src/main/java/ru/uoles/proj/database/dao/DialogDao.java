package ru.uoles.proj.database.dao;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 13.07.2022
 * Time: 0:10
 */
public interface DialogDao<Dialog> {

    List<Dialog> getAllDialogs(final String personGuid, final int count);

    Dialog findDialogByPersonGuids(final String personGuid, final String recipientGuid);

    Dialog getDialogByGuid(final String guid);

    void addDialog(final Dialog dialog);
}
