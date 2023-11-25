FROM openjdk:22-ea-24-jdk-bullseye

WORKDIR /app

COPY ./src .

RUN javac -d ./out ./SnakeGame.java

CMD ["java", "-cp", "./out", "SnakeGame"]
