FROM openjdk:8-jdk-alpine
MAINTAINER efarias
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/springboot-postgres-docker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} springboot-postgres-docker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-postgres-docker.jar"]