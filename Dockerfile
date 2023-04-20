# syntax=docker/dockerfile:1

FROM openjdk:18

COPY . /app

WORKDIR /app

#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve

#COPY src ./src

#CMD ["mvn spring-boot:run"]
CMD [ "./mvnw", "spring-boot:run" ]