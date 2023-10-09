FROM openjdk:17.0.2-slim-buster

WORKDIR /app

COPY /build/libs/app.jar /app
COPY /pinpoint-agent /app/pinpoint-agent

EXPOSE 8080

ENV JAVAAGENT "-javaagent:/app/pinpoint-agent/pinpoint-bootstrap-2.5.2.jar"
ENV JAVA_OPTS "-Dpinpoint.profiler.profiles.active=release \
-Dpinpoint.applicationName=restaurant-finder-api \
-Dpinpoint.agentId=restaurant-finder-api \
-Dpinpoint.agentName=restaurant-finder-api-agent \
-Dspring.profiles.active=production"

ENTRYPOINT ["sh", "-c", "java ${JAVAAGENT} ${JAVA_OPTS} -jar app.jar --server.port=8080"]
