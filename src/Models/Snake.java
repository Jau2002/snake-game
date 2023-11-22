package Models;

import java.awt.Color;

public class Snake{
	private int x[];
	private int y[];	
	String skinName;
	Color snakeHeadColor;
	Color snakeBodyColor;
	private int bodyParts;
	private int gameUnits;
	
	public Snake(int bodyParts, String skinName, Color snakeHead, Color snakeBody) {
		this.gameUnits = (600*600)/25;
		this.x = new int[gameUnits];
		this.y = new int[gameUnits];
		this.bodyParts = bodyParts;		
		this.skinName = skinName;
		this.snakeHeadColor = snakeHead;
		this.snakeBodyColor = snakeBody;
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public String getSkinName() {
		return skinName;
	}

	public void setSkinName(String skinName) {
		this.skinName = skinName;
	}

	public int getBodyParts() {
		return bodyParts;
	}

	public void setBodyParts(int bodyParts) {
		this.bodyParts = bodyParts;
	}

	public Color getSnakeHeadColor() {
		return snakeHeadColor;
	}

	public void setSnakeHeadColor(Color snakeHeadColor) {
		this.snakeHeadColor = snakeHeadColor;
	}

	public Color getSnakeBodyColor() {
		return snakeBodyColor;
	}

	public void setSnakeBodyColor(Color snakeBodyColor) {
		this.snakeBodyColor = snakeBodyColor;
	}

	public int getGameUnits() {
		return gameUnits;
	}

	public void setGameUnits(int gameUnits) {
		this.gameUnits = gameUnits;
	}
}
