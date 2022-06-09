FROM mysql:8
MAINTAINER Maksim Kulikov <max.uoles@rambler.ru>

RUN apt-get update -y &&
RUN apt-get upgrade -y &&
RUN apt-get install nano mc -y &&

RUN mkdir /var/log/mysql &&
RUN chown -R mysql:mysql /var/log/mysql

EXPOSE 3306