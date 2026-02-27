# To build the version 1.0 of books:
# docker build -t books:1.0 .


FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

COPY --from=build /app/target/Books-0.0.1.jar app.jar

# Production
ENV SPRING_PROFILES_ACTIVE=dev

ENTRYPOINT ["java", "--enable-native-access=ALL-UNNAMED", "-jar", "app.jar", "--spring.main.banner-mode=off"]