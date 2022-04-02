package ru.uoles.proj.utils;

import java.util.UUID;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 02.04.2022
 * Time: 19:54
 */
public final class DatabaseHelper {

    private DatabaseHelper() {
    }

    public static String getNewGUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
