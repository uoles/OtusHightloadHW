package ru.uoles.proj.database.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.uoles.proj.model.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 28.06.2022
 * Time: 17:05
 */
public class NewsMapper implements RowMapper<News> {

    private static final String GUID = "guid";
    private static final String NEWS_DATE_TIME = "news_date_time";
    private static final String PERSON_GUID = "person_guid";
    private static final String NEWS_BODY = "news_body";
    private static final String FIRST_NAME = "first_name";
    private static final String SECOND_NAME = "second_name";

    @Override
    public News mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String guid = rs.getString(GUID);

        final Timestamp timestamp = rs.getTimestamp(NEWS_DATE_TIME);
        final Date newsDateTime = new Date(timestamp.getTime());

        final String personGuid = rs.getString(PERSON_GUID);
        final String newsBody = rs.getString(NEWS_BODY);
        final String personFullName = String.join(
                " ",
                rs.getString(FIRST_NAME),
                rs.getString(SECOND_NAME)
        );

        return new News(guid, newsDateTime, personGuid, personFullName, newsBody);
    }
}
