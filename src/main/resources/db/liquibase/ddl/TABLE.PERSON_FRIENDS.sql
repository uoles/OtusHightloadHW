-- liquibase formatted sql

-- changeset uoles:TABLE-PERSON_FRIENDS#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE TABLE PERSON_FRIENDS (
    id int NOT NULL AUTO_INCREMENT,
    person_guid varchar(32) NOT NULL,
    friend_guid varchar(32) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Друзья';

-- changeset uoles:TABLE-PERSON_FRIENDS#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.PERSON_FRIENDS ENGINE=InnoDB;