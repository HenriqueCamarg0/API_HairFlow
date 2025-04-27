# Build stage
FROM alpine:latest as build

RUN apk add --no-cache openjdk17 maven
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x ./mvnw
RUN ./mvnw install -DskipTests

EXPOSE 8080

# Run stage
FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp

# Instala tzdata no run stage
RUN apk add --no-cache tzdata

# Define timezone como America/Sao_Paulo
ENV TZ=America/Sao_Paulo

COPY --from=build /workspace/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
