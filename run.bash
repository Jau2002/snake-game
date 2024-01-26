rm -fr out/
cd src/
javac -d ../out ./Controllers/SnakeGame.java
cd ..
cd out/
java -cp . Controllers.SnakeGame