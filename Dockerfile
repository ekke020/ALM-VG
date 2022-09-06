FROM maven:3-openjdk-18-slim AS builder
WORKDIR /build
COPY src/ .
COPY pom.xml .
RUN mvn -f /build/pom.xml clean package

FROM eclipse-temurin:18-jre
WORKDIR /app
RUN echo $(ls -a)
RUN echo $(pwd)
COPY /target/app.jar .
CMD ["java","-jar","app.jar"]
