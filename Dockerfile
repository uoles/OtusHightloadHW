FROM docker.io/library/openjdk:11
MAINTAINER Maksim Kulikov <max.uoles@rambler.ru>

ADD ./target/original-mooncake-social.jar original-mooncake-social.jar

EXPOSE 8081
CMD ["java","-jar","original-mooncake-social.jar"]