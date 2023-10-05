FROM openjdk:17.0.2-slim-buster

WORKDIR /app

COPY /build/libs/app.jar /app
COPY /pinpoint-agent /app/pinpoint-agent

EXPOSE 8080

EXPOSE 9991
EXPOSE 9992
EXPOSE 9993
EXPOSE 9994
EXPOSE 9995
EXPOSE 9996

EXPOSE 9991/udp
EXPOSE 9992/udp
EXPOSE 9993/udp
EXPOSE 9994/udp
EXPOSE 9995/udp
EXPOSE 9996/udp

ENTRYPOINT [ "java", "-javaagent:/app/pinpoint-agent/pinpoint-bootstrap-2.5.2.jar", \
"-Dpinpoint.applicationName=test-docker", \
"-Dpinpoint.agentId=test-docker",\
"-Dpinpoint.agentName=restaurant-test-docker",\
"-Dspring.profiles.active=local",\
"-jar", "app.jar"]


