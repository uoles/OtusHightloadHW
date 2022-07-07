FROM centos:centos7
MAINTAINER Maksim Kulikov <max.uoles@rambler.ru>

# Configure my repo to use my custom Nginx with modsec
RUN yum -y install wget nano tar mc

RUN yum clean all
RUN yum update -y
RUN yum install yum-utils

RUN rpm -Uvh http://fedora-mirror01.rbc.ru/pub/epel/epel-release-latest-7.noarch.rpm

# install nginx
RUN yum install nginx -y
RUN systemctl enable nginx

RUN mkdir /var/cache/nginx

# expose HTTP
EXPOSE 80

# Run
ENTRYPOINT nginx -g "daemon off;"