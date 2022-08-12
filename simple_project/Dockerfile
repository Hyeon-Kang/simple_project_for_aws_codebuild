FROM openjdk:8-jdk
COPY target/simple_project-0.0.1-SNAPSHOT.jar my_spring_project.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "my_spring_project.jar"]