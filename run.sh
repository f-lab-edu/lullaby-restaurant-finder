java -jar -javaagent:./pinpoint-agent/pinpoint-bootstrap-2.5.2.jar \
-Dpinpoint.profiler.profiles.active=release \
-Dpinpoint.applicationName=restaurant-finder-api \
-Dpinpoint.agentId=restaurant-finder-api \
-Dpinpoint.agentName=restaurant-finder-api-agent \
-Dspring.profiles.active=production \
./build/libs/app.jar \
--server.port=8080
