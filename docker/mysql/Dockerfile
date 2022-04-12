FROM mysql:8
MAINTAINER Maksim Kulikov <max.uoles@rambler.ru>

RUN mkdir /usr/local/bin/mooncake
RUN mkdir /usr/local/bin/mooncake/init-db

#RUN touch /var/run/mysqld/mysqld.sock
#RUN touch /var/run/mysqld/mysqld.pid
#RUN chown -R mysql:mysql /var/run/mysqld/mysqld.sock
#RUN chown -R mysql:mysql /var/run/mysqld/mysqld.pid
#RUN chmod -R 644 /var/run/mysqld/mysqld.sock
#
#RUN chown -R mysql:mysql /var/lib/mysql /var/run/mysqld

ADD init-db/create-schema.sh /usr/local/bin/init-db/create-schema.sh
ADD init-db/schema.sql /usr/local/bin/init-db/schema.sql

EXPOSE 3306
