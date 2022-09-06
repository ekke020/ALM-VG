#FROM maven:3-openjdk-18-slim AS builder
#WORKDIR /build
#COPY src/ .
#COPY pom.xml .
#RUN mvn -f /build/pom.xml clean package

FROM eclipse-temurin:18-jre
WORKDIR /app
COPY /target/app.jar .
CMD ["java","-jar","app.jar"]
