package ru.uoles.proj.database.dao;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.uoles.proj.database.mapper.PersonAccessMapper;
import ru.uoles.proj.model.Person;
import ru.uoles.proj.model.PersonAccess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 08.04.2022
 * Time: 16:16
 */
@Repository
@RequiredArgsConstructor
@PropertySource(name="sqlPersonFriends", value="classpath:/db/sql/person-friends.xml")
public class PersonFriendsDaoImpl implements PersonFriendsDao<Person> {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${add.new.friend}")
    private String ADD_NEW_FRIEND;

    @Value("${find.friend}")
    private String FIND_FRIEND;

    @Override
    public boolean findFriend(final String personGuid, final String friendGuid) {
        Integer result = namedParameterJdbcTemplate.queryForObject(
                FIND_FRIEND,
                guidsToParams(personGuid, friendGuid),
                Integer.class
        );

        return Objects.nonNull(result) && !Objects.equals(0, result);
    }

    @Override
    public void addFriend(final String personGuid, final String friendGuid) {
        namedParameterJdbcTemplate.update(
                ADD_NEW_FRIEND,
                guidsToParams(personGuid, friendGuid)
        );
    }

    private Map<String, Object> guidsToParams(final String personGuid, final String friendGuid) {
        Map<String, Object> params = new HashMap<>();
        params.put("person_guid", personGuid);
        params.put("friend_guid", friendGuid);
        return params;
    }
}
