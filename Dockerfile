# Docker Image file to containerize the simple-java-maven-app

# Reference resources:
# https://www.baeldung.com/java-dockerize-app

# Defining the base image
FROM openjdk:17-jdk-slim

#Set working directory in the container to be /app
WORKDIR /app

# Accept a JAR_FILE_PATH argument. This is a variable containing the path of the jar file we want to run
ARG JAR_FILE_PATH

#Copy the jar from Maven's target folder into the current working directory of the (eventually running) docker container.
COPY ${JAR_FILE_PATH} app.jar

#Define the command to run the app
# TODO: Need to revise the jar name here
ENTRYPOINT ["java", "-jar", "app.jar"]