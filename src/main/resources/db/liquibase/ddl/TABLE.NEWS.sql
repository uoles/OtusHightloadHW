-- liquibase formatted sql

-- changeset uoles:TABLE-NEWS#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE TABLE NEWS (
    id int NOT NULL AUTO_INCREMENT,
    guid varchar(32) NOT NULL,
    news_date_time datetime NOT NULL,
    person_guid varchar(32) NOT NULL,
    news_body varchar(255) NOT NULL,

    PRIMARY KEY (id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='Новости';

-- changeset uoles:TABLE-NEWS#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
ALTER TABLE mooncake_db.NEWS ENGINE=InnoDB;

-- changeset uoles:TABLE-NEWS#0003 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE UNIQUE INDEX IDX_NEWS_GUID_DATE_TIME ON NEWS (person_guid, news_date_time);