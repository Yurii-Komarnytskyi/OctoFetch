FROM openjdk:21
WORKDIR /octoapp
COPY target/OctoFetch-0.0.1-SNAPSHOT.jar octoFetchApp.jar
EXPOSE 8080:8080
ENTRYPOINT ["java", "-jar", "octoFetchApp.jar"]