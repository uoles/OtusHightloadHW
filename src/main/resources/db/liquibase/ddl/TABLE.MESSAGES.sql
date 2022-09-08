-- liquibase formatted sql

-- changeset uoles:TABLE-MESSAGES#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE TABLE MESSAGES (
    id int NOT NULL AUTO_INCREMENT,
    guid varchar(32) NOT NULL,
    date_time datetime NOT NULL,
    dialog_guid varchar(32) NOT NULL,
    sender_guid varchar(32) NOT NULL,
    recipient_guid varchar(32) NOT NULL,
    message varchar(255) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Сообщения пользователей';

-- changeset uoles:TABLE-MESSAGES#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.MESSAGES ENGINE=InnoDB;

-- changeset uoles:TABLE-MESSAGES#0003 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE UNIQUE INDEX IDX_MESSAGES ON MESSAGES (dialog_guid, date_time, sender_guid, recipient_guid);
