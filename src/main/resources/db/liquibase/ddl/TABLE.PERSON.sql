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