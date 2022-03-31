CREATE DATABASE mooncake_db;

CREATE USER 'admin'@'%' IDENTIFIED BY 'PADSkdj239kmFG223';
GRANT ALL PRIVILEGES ON mooncake_db.* TO 'admin'@'%';

CREATE USER 'user'@'%' IDENTIFIED BY 'user';
GRANT INSERT ON mooncake_db.* TO 'user'@'%';
GRANT SELECT ON mooncake_db.* TO 'user'@'%';