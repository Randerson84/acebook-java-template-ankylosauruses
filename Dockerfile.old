# syntax=docker/dockerfile:1

FROM openjdk:17

COPY . /app

WORKDIR /app

EXPOSE 8080

#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve

#COPY src ./src

#CMD ["mvn spring-boot:run"]
CMD [ "./mvnw", "spring-boot:run" ]