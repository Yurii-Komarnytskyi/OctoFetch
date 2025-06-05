FROM maven:3.9.9-amazoncorretto-21-debian-bookworm
WORKDIR /octoapp
COPY . .
RUN mvn clean package
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "target/OctoFetch-0.0.1-SNAPSHOT.jar"]