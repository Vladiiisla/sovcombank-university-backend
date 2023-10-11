FROM maven:3.6.3-openjdk-11 AS build
WORKDIR /
COPY /src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package -DskipTests

FROM openjdk:11
WORKDIR /
COPY /src /src
COPY --from=build /target/*.jar sovcombank-university-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","sovcombank-university-backend.jar"]