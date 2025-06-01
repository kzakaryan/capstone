FROM alpine:latest AS base

LABEL authors="kzakaryan"

RUN apk add git openjdk21

WORKDIR /app

COPY . /app

RUN ./mvnw clean package
RUN cp target/eureka-server-0.0.1-SNAPSHOT.jar ./app-jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app-jar"]