package ru.uoles.proj.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.uoles.proj.database.PersonAccessDao;
import ru.uoles.proj.model.Authorization;
import ru.uoles.proj.model.PersonAccess;
import ru.uoles.proj.utils.DatabaseHelper;
import ru.uoles.proj.utils.SecureHelper;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;

/**
 * OtusHightloadHW
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 01.04.2022
 * Time: 21:20
 */
@Service
@RequiredArgsConstructor
public class AuthorizationManageServiceImpl implements AuthorizationManageService<Authorization> {

    private final Logger logger = LoggerFactory.getLogger(AuthorizationManageServiceImpl.class);

    private final PersonAccessDao<PersonAccess> personAccessDao;

    @Override
    public String authorization(final Authorization authorization) {
        String personId = null;
        try {
            PersonAccess personAccess = personAccessDao.findByLogin(authorization.getLogin());
            if (Objects.nonNull(personAccess)) {
                boolean authenticate = SecureHelper.authenticate(
                        authorization.getPassword(),
                        personAccess.getSecretByteArray(),
                        personAccess.getSaltByteArray()
                );

                if (authenticate) {
                    personId = personAccess.getPersonGuid();
                } else {
                    logger.error("Error: bad password! Login '{}'", authorization.getLogin());
                }
            } else {
                logger.error("Error: user not found! Login '{}'", authorization.getLogin());
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("Error: exception user password verification! Login '{}'", authorization.getLogin(), e);
        }
        return personId;
    }

    @Override
    public String registration(final Authorization authorization) {
        String newPersonGuid = null;
        try {
            PersonAccess existsPersonAccess = personAccessDao.findByLogin(authorization.getLogin());
            if (Objects.isNull(existsPersonAccess)) {
                newPersonGuid = DatabaseHelper.getNewGUID();

                byte[] saltByteArray = SecureHelper.generateSalt();
                byte[] secretByteArray = SecureHelper.getEncryptedPassword(authorization.getPassword(), saltByteArray);

                PersonAccess newPersonAccess = new PersonAccess(
                        newPersonGuid, authorization.getLogin(), secretByteArray, saltByteArray
                );

                personAccessDao.addPersonAccess(newPersonAccess);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("Error: exception generate new password and salt for new person! Login '{}'", authorization.getLogin(), e);
        }
        return newPersonGuid;
    }
}
