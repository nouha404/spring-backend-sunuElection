FROM maven:3.8.2-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn clean package -DskipTests
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
