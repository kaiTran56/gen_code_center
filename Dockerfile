FROM openjdk:23-ea-11-jdk-slim
EXPOSE 9000
COPY ./target/gen_code_center-0.0.1-SNAPSHOT.jar gen_code_center-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/gen_code_center-0.0.1-SNAPSHOT.jar"]