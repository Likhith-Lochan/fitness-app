FROM maven:3.9.5-eclipse-termuin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-termuin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]