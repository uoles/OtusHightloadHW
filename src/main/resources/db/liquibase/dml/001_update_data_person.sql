-- liquibase formatted sql

-- changeset uoles:TABLE-PERSON-DATA-UPDATE#0001 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
update mooncake_db.PERSON p set p.upper_first_name = UPPER(first_name);

-- changeset uoles:TABLE-PERSON-DATA-UPDATE#0002 logicalFilePath:path-independent runOnChange:false splitStatements:true endDelimiter:/
update mooncake_db.PERSON p set p.upper_second_name = UPPER(second_name);