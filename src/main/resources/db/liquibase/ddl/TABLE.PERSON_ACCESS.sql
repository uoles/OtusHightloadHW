-- liquibase formatted sql

-- changeset uoles:TABLE-PERSON_ACCESS#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE TABLE PERSON_ACCESS (
    id int NOT NULL AUTO_INCREMENT,
    person_guid varchar(32) NOT NULL,
    login varchar(30) NOT NULL,
    secret blob NOT NULL,
    salt blob NOT NULL,
    status int(1) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Таблица доступов';

-- changeset uoles:TABLE-PERSON_ACCESS#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.PERSON_ACCESS ENGINE=InnoDB;

-- changeset uoles:TABLE-PERSON_ACCESS#0003 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE UNIQUE INDEX IDX_PERSON_ACCESS_GUID ON PERSON_ACCESS (login);