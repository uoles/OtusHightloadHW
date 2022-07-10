-- liquibase formatted sql

-- changeset uoles:TABLE-DIALOGS#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE TABLE DIALOGS (
    id int NOT NULL AUTO_INCREMENT,
    guid varchar(32) NOT NULL,
    person_guid varchar(32) NOT NULL,
    recipient_guid varchar(32) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Диалоги пользователей';

-- changeset uoles:TABLE-DIALOGS#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.DIALOGS ENGINE=InnoDB;

-- changeset uoles:TABLE-DIALOGS#0003 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE UNIQUE INDEX IDX_DIALOGS ON DIALOGS (person_guid, recipient_guid);

-- changeset uoles:TABLE-DIALOGS#0004 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.DIALOGS ADD CONSTRAINT CSRT_DIALOGS UNIQUE (person_guid, recipient_guid);

-- changeset uoles:TABLE-DIALOGS#0005 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.DIALOGS ADD COLUMN recipient_full_name varchar(70) NOT NULL;
