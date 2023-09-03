FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
RUN apk add curl
RUN apk add jq
WORKDIR /usr/share/LivingsLiquidAdvanc
ADD target/selenium-docker.jar 				selenium-docker.jar
ADD target/selenium-docker-tests.jar 		selenium-docker-tests.jar
ADD target/libs								libs
ADD /src/test/resources/config.properties	config.properties
ADD screenshots								screenshots
ADD testng.xml								testng.xml
ADD healthcheck.sh							healthcheck.sh
RUN dos2unix healthcheck.sh

ENTRYPOINT sh healthcheck.sh
