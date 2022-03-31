package ru.uoles.proj.service;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 29.03.2022
 * Time: 22:00
 */
public interface PersonManageService<Person> {

    Person findById(final Long id);
}
