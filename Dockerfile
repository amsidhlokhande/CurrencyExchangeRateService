FROM openjdk:8-jdk-alpine
VOLUME ["/tmp"]
COPY target/CurrencyExchangeRateService-*.jar CurrencyExchangeRateService.jar
COPY src/ src
COPY pom.xml pom.xml
COPY Dockerfile Dockerfile
ENTRYPOINT ["java","-jar","CurrencyExchangeRateService.jar"]