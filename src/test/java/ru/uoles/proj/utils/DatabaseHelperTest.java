package ru.uoles.proj.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 08.04.2022
 * Time: 15:40
 */
@DisplayName("Утилиты работы с БД")
public class DatabaseHelperTest {

    @Test
    public void getNewGUIDTest() {
        String guid = DatabaseHelper.getNewGUID();
        System.out.println(guid);

        assertNotNull(guid);
        assertEquals(32, guid.length());
        assertFalse(guid.contains("-"));
    }
}
