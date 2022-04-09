package ru.uoles.proj.database.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

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
public class PersonFriendsDaoImpl implements PersonFriendsDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${add.new.friend}")
    private String ADD_NEW_FRIEND;

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
