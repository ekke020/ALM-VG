FROM maven:3-openjdk-11-slim AS builder
WORKDIR /build
COPY src/ .
COPY pom.xml .
RUN mvn -f /build/pom.xml clean package

FROM eclipse-temurin:18-jre
WORKDIR /app
COPY /target/alm-vg.jar .
CMD ["java","-jar","alm-vg.jar"]
