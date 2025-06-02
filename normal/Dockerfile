FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /build

COPY . .

RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /build/target/*.jar /app/gateway.jar

EXPOSE 8080

CMD ["java", "-jar", "gateway.jar"]