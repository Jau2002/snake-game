package Utils;

import java.awt.Color;

public class Fruit {
	private int fruitX;
	private int fruitY;
	private int prob;
	private int givenPoints;
	private int givenLength;
	private String fruitType;
	private Color color;
	
	public Fruit(int x, int y, int prob) {
		this.fruitX = x;
		this.fruitY = y;
		this.prob = prob;
		
		checkPoints(this.prob);
	}
	
	private void checkPoints(int prob) {
		if (prob <= 10) {
	        fruitType = "Cherry";
	        givenPoints = 12;
	        givenLength = 5;
	        color = new Color(222, 0, 0);
	    } else if (prob <= 30 && prob > 10) {
	        fruitType = "Banana";
	        givenPoints = 7;
	        givenLength = 6;
	        color = new Color(255, 225, 53);
	    } else {
	        fruitType = "Strawberry";
	        givenPoints = 3;
	        givenLength = 1;
	        color = new Color(252, 90, 141);
	    }
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
	
	public int getProb() {
		return prob;
	}

	public int getGivenPoints() {
		return givenPoints;
	}

	public void setGivenPoints(int givenPoints) {
		this.givenPoints = givenPoints;
	}

	public int getGivenLength() {
		return givenLength;
	}

	public void setGivenLength(int givenLength) {
		this.givenLength = givenLength;
	}

	public String getFruitType() {
		return fruitType;
	}

	public void setFruitType(String fruitType) {
		this.fruitType = fruitType;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setProb(int prob) {
		this.prob = prob;
	}
	
	
}
