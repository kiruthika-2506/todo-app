FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/todo-app-1.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]