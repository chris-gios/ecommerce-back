FROM openjdk:8-jdk-alpine

VOLUME /tmp
RUN adduser --disabled-password --gecos '' app
WORKDIR /home/app

COPY ./target/ecommerce-0.0.1-SNAPSHOT.jar /home/app/ecommerce-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/app/ecommerce-0.0.1-SNAPSHOT.jar"]