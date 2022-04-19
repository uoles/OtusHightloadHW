-- liquibase formatted sql

-- changeset uoles:TABLE-SPRING_SESSION#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE TABLE SPRING_SESSION (
    PRIMARY_ID CHAR(36) NOT NULL,
    SESSION_ID CHAR(36) NOT NULL,
    CREATION_TIME BIGINT NOT NULL,
    LAST_ACCESS_TIME BIGINT NOT NULL,
    MAX_INACTIVE_INTERVAL INT NOT NULL,
    EXPIRY_TIME BIGINT NOT NULL,
    PRINCIPAL_NAME VARCHAR(100),

    CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC;

-- changeset uoles:TABLE-SPRING_SESSION#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);

-- changeset uoles:TABLE-SPRING_SESSION#0003 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);

-- changeset uoles:TABLE-SPRING_SESSION#0004 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);
