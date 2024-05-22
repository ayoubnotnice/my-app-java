FROM openjdk:17

WORKDIR /APP

COPY target/*.jar application.jar

RUN chmod +x application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]