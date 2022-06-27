package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.uoles.proj.database.dao.NewsDao;
import ru.uoles.proj.model.News;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 27.06.2022
 * Time: 11:44
 */
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService<News> {

    private NewsDao<News> newsDao;

    @Override
    public List<News> getNews(final String personGuid, final int count) {
        return null;
    }
}
