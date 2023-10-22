FROM openjdk:17.0.2-slim-buster

WORKDIR /app

COPY /build/libs/app.jar /app
COPY /pinpoint-agent /app/pinpoint-agent

EXPOSE 8080

# 실행 시 아래 환경 변수 설정
#ENV SPRING_PROFILES_ACTIVE=production

ENV JAVAAGENT "-javaagent:/app/pinpoint-agent/pinpoint-bootstrap-2.5.2.jar"
ENV JAVA_OPTS "-Dpinpoint.profiler.profiles.active=release \
-Dpinpoint.applicationName=restaurant-finder-api \
-Dpinpoint.agentId=restaurant-finder-api \
-Dpinpoint.agentName=restaurant-finder-api-agent"
#-Dspring.profiles.active=$SPRING_PROFILES_ACTIVE"

ENTRYPOINT ["sh", "-c", "java ${JAVAAGENT} ${JAVA_OPTS} -jar app.jar --server.port=8080"]

