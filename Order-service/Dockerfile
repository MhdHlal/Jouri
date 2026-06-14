FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/order-service-docker.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
