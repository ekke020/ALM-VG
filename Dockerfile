FROM maven:3-openjdk-18-slim AS builder
WORKDIR /build
COPY src/ .
COPY pom.xml .
RUN mvn clean package -DskipTests=true

FROM eclipse-temurin:18-jre
WORKDIR /app
COPY --from=builder /target/app.jar ./
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
