FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build
COPY . .
RUN mvn clean package -pl log-ingestion -am -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /build/log-ingestion/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]