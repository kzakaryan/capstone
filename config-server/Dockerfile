FROM alpine:latest AS base

LABEL authors="kzakaryan"

RUN apk add git openjdk21

WORKDIR /app

COPY . /app

RUN ./mvnw clean package
RUN cp target/config-server-0.0.1-SNAPSHOT.jar ./app-jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app-jar"]