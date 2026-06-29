FROM eclipse-temurin:21
LABEL maintainer="rafael.dev"
WORKDIR /app
COPY target/DesafioRelogio-0.0.1-SNAPSHOT.jar /app/aula-docker.jar
ENTRYPOINT ["java", "-jar", "aula-docker.jar"]