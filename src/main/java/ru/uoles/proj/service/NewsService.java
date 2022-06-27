package ru.uoles.proj.service;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 27.06.2022
 * Time: 11:44
 */
public interface NewsService<News> {

    List<News> getNews(final String personGuid, final int count);
}
