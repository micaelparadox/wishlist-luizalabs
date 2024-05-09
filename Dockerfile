FROM maven:3.6.3-openjdk-11 as builder
WORKDIR /app

COPY src ./src
COPY pom.xml .

RUN mvn clean package


FROM openjdk:11-jdk
RUN apt-get update && apt-get install -y netcat
WORKDIR /app

COPY --from=builder /app/target/wishlist-0.0.1-SNAPSHOT.jar /app/wishlist.jar
EXPOSE 8080
CMD while ! nc -z mongodb 27017; do sleep 1; done; java -jar wishlist.jar
