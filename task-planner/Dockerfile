FROM maven:3.5.4-jdk-8-slim

EXPOSE 9000
VOLUME /root/.m2

WORKDIR /usr/src/task-planner

COPY . /usr/src/task-planner/

CMD ["mvn", "spring-boot:run"]