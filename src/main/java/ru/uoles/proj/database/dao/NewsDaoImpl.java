package ru.uoles.proj.database.dao;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.model.News;

import java.util.List;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 27.06.2022
 * Time: 11:45
 */
@Repository
@PropertySource(name="sqlNews", value="classpath:db/sql/news.xml")
public class NewsDaoImpl implements NewsDao<News> {

    @Override
    public List<News> getNews(String personGuid, int count) {
        return null;
    }
}
