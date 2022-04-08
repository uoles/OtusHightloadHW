--liquibase formatted sql
--changeset uoles:create-table-PERSON_FRIENDS

CREATE TABLE PERSON_FRIENDS (
    id int NOT NULL AUTO_INCREMENT,
    person_guid varchar(32) NOT NULL,
    friend_guid varchar(32) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Друзья';