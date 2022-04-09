package ru.uoles.proj.types;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 09.04.2022
 * Time: 6:19
 */
public enum PersonOperationType {

    SAVE("Save"),
    UPDATE("Update");

    private final String canonicalName;

    PersonOperationType(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public String getCanonicalName() {
        return canonicalName;
    }
}
