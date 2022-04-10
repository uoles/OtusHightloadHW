package ru.uoles.proj.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 08.04.2022
 * Time: 16:00
 */
@DisplayName("Идентификация/авторизация пользователя")
public class SecureHelperTest {

    private static final String passwordTrue = "passwordTest";
    private static final String passwordFalse = "password";

    @Test
    void authenticateTest_TruePassword() throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = SecureHelper.generateSalt();
        byte[] encryptedPassword = SecureHelper.getEncryptedPassword(passwordTrue, salt);
        boolean result = SecureHelper.authenticate(passwordTrue, encryptedPassword, salt);

        assertNotNull(salt);
        assertNotNull(encryptedPassword);
        assertTrue(result);
    }

    @Test
    void authenticateTest_FalsePassword() throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = SecureHelper.generateSalt();
        byte[] encryptedPassword = SecureHelper.getEncryptedPassword(passwordTrue, salt);
        boolean result = SecureHelper.authenticate(passwordFalse, encryptedPassword, salt);

        assertNotNull(salt);
        assertNotNull(encryptedPassword);
        assertFalse(result);
    }

    @Test
    void getEncryptedPasswordTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = SecureHelper.generateSalt();
        byte[] encryptedPassword = SecureHelper.getEncryptedPassword(passwordTrue, salt);

        assertNotNull(salt);
        assertNotNull(encryptedPassword);
    }

    @Test
    void generateSaltTest() throws NoSuchAlgorithmException {
        byte[] salt = SecureHelper.generateSalt();
        assertNotNull(salt);
    }
}