package ru.uoles.proj.database.dao;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 27.06.2022
 * Time: 11:45
 */
public interface NewsDao<News> {

    List<News> getNews(final String personGuid, final int count);
}
