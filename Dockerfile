FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/timesheet-devops-1.1.jar timesheet-devops-1.1.jar
ENTRYPOINT ["java","-jar","/timesheet-devops-1.1.jar"]