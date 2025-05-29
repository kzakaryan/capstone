FROM alpine:latest AS base

LABEL authors="kzakaryan"

RUN apk add git openjdk21

WORKDIR /app

COPY . /app

RUN ./mvnw clean package
RUN cp target/server-naming-0.0.1-SNAPSHOT.jar ./app-jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-jar"]