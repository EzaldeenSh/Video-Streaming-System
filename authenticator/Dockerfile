# syntax=docker/dockerfile:1
FROM openjdk:11
EXPOSE 8081
ADD target/authenticator-0.0.1-SNAPSHOT.jar authenticator-0.0.1-SNAPSHOT.jar
ENTRYPOINT   ["java", "-jar", "/authenticator-0.0.1-SNAPSHOT.jar"]