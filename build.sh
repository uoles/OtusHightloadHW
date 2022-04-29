#!/bin/bash

git pull
mvn clean install

docker build -t uoles/mooncake-social .
docker run --name social-project -p 8081:8081 --network=host -d uoles/mooncake-social

exit $?