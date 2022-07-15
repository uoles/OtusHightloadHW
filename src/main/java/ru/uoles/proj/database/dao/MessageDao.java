package ru.uoles.proj.database.dao;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 14.07.2022
 * Time: 11:25
 */
public interface MessageDao<Message> {

    void addMessage(final Message message);

    List<Message> getMessages(final String dialogGuid, final int count);
}
