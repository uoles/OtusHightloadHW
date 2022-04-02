package ru.uoles.proj.service;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 01.04.2022
 * Time: 21:20
 */
public interface AuthorizationManageService<Authorization> {

    String authorization(final Authorization authorization);

    Long add(final Authorization authorization);
}
