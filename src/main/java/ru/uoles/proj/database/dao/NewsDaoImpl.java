package ru.uoles.proj.database.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.database.mapper.NewsMapper;
import ru.uoles.proj.model.News;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${find.all.news.by.person.guid}")
    private String FIND_ALL_NEWS_BY_PERSON_GUID;

    public NewsDaoImpl(@Qualifier("masterNamedParameterJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<News> getNews(final String personGuid, final int count) {
        return namedParameterJdbcTemplate.query(
                FIND_ALL_NEWS_BY_PERSON_GUID,
                personGuidToParams(personGuid, count),
                new NewsMapper()
        );
    }

    private Map<String, Object> personGuidToParams(final String personGuid, final int count) {
        Map<String, Object> params = new HashMap<>();
        params.put("person_guid", personGuid);
        params.put("cnt", count);
        return params;
    }
}
