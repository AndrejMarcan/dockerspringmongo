FROM openjdk:8-jre-alpine

COPY build/libs/DockerSpringMongo.jar DockerSpringMongo.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "DockerSpringMongo.jar"]