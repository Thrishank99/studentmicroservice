FROM openjdk:17
EXPOSE 8080
ADD target/student-microservice.jar student-microservice.jar
ENTRYPOINT ["java","-jar","/student-microservice.jar"]