FROM maven:3-openjdk-18-slim AS builder
WORKDIR build
COPY src/ src/
COPY ./pom.xml ./
RUN mvn -f pom.xml clean package -DskipTests=true

FROM openjdk:18-jdk-alpine
WORKDIR run
COPY --from=builder build/target/app.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
