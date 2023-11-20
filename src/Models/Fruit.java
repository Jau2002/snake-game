package Models;


public class Fruit {
	private int fruitX;
	private int fruitY;
	
	public Fruit(int x, int y) {
		this.fruitX = x;
		this.fruitY = y;
	}

	public int getFruitX() {
		return fruitX;
	}

	public void setFruitX(int fruitX) {
		this.fruitX = fruitX;
	}

	public int getFruitY() {
		return fruitY;
	}

	public void setFruitY(int fruitY) {
		this.fruitY = fruitY;
	}
}
