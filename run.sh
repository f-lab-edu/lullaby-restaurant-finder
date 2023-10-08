java -jar -javaagent:./pinpoint-agent/pinpoint-bootstrap-2.5.2.jar \
  -Dpinpoint.applicationName=restaurant-finder-api \
  -Dpinpoint.agentId=restaurant-finder-api \
  -Dpinpoint.agentName=restaurant-finder-api-local-agent \
  -Dpinpoint.config=./pinpoint-agent/pinpoint-root.config \
  -Dspring.profiles.active=local \
  ./build/libs/app.jar
