use mooncake_db;

CREATE TABLE PERSON (
    id int(11) NOT NULL AUTO_INCREMENT,
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

CREATE TABLE PERSON_ACCESS (
    id int(11) NOT NULL AUTO_INCREMENT,
    person_id int(11) NOT NULL,
    login varchar(30) NOT NULL,
    secret blob NOT NULL,
    salt blob NOT NULL,
    status int(1) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Таблица доступов';