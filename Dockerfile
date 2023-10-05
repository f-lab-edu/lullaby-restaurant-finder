FROM openjdk:17.0.2-slim-buster

WORKDIR /app

COPY /build/libs/app.jar /app

ENTRYPOINT ["java", "-jar", "app.jar"]

