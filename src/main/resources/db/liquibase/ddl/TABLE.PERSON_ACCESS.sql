--liquibase formatted sql
--changeset uoles:create-table-PERSON_ACCESS

CREATE TABLE PERSON_ACCESS (
    id int NOT NULL AUTO_INCREMENT,
    person_guid varchar(32) NOT NULL,
    login varchar(30) NOT NULL,
    secret blob NOT NULL,
    salt blob NOT NULL,
    status int(1) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Таблица доступов';