./gradlew bootJar --parallel

echo "========================================================================================================"

docker build . -t restaurant-finder-api
