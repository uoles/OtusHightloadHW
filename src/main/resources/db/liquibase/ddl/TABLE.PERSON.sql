-- liquibase formatted sql

-- changeset uoles:TABLE-PERSON#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE TABLE PERSON (
    id int NOT NULL AUTO_INCREMENT,
    guid varchar(32) NOT NULL,
    registration_date datetime NOT NULL,
    dissolution_date datetime,
    permissions_id int(11) NOT NULL,
    first_name varchar(30) NOT NULL,
    second_name varchar(30) NOT NULL,
    nick_name varchar(30) NOT NULL,
    info varchar(250),
    age int(100) NOT NULL,
    gender varchar(15) NOT NULL,
    town varchar(15),

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Список пользователей';

-- changeset uoles:TABLE-PERSON#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.PERSON ENGINE=InnoDB;

-- changeset uoles:TABLE-PERSON#0003 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.PERSON add column upper_first_name varchar(30);

-- changeset uoles:TABLE-PERSON#0004 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.PERSON add column upper_second_name varchar(30);

-- changeset uoles:TABLE-PERSON#0005 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.PERSON drop column upper_first_name;

-- changeset uoles:TABLE-PERSON#0006 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.PERSON drop column upper_second_name;

-- changeset uoles:TABLE-PERSON#0007 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE UNIQUE INDEX IDX_PERSON_GUID ON PERSON (guid, id);

-- changeset uoles:TABLE-PERSON#0008 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE INDEX IDX_PERSON_SEARCH ON PERSON (first_name, second_name);