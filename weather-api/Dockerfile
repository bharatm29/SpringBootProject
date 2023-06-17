FROM openjdk:17
EXPOSE 4000
ADD target/weather-api-jar.jar weather-api-jar.jar
ENTRYPOINT ["java", "-jar", "/weather-api-jar.jar"]