FROM openjdk:11
EXPOSE 8085
COPY target/StreamService-0.0.1-SNAPSHOT.war StreamService-0.0.1-SNAPSHOT.war
ENTRYPOINT   ["java", "-jar", "/StreamService-0.0.1-SNAPSHOT.war"]