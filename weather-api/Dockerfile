FROM bellsoft/liberica-openjdk-alpine:latest
EXPOSE 4000
ENV FORECAST_KEY=YEGsCPSIbbeZrG6esvVheZUwrwl0TxIf
ADD target/weather-api-jar.jar weather-api-jar.jar
ENTRYPOINT ["java", "-jar", "/weather-api-jar.jar"]