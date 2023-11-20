package Models;

public class Snake{
	private int x[];
	private int y[];	
	private String skin;
	private int bodyParts;
	
	public Snake(int gameUnits, String skin, int bodyParts) {
		this.x = new int[gameUnits];
		this.y = new int[gameUnits];
		this.skin = skin;
		this.bodyParts = bodyParts;		
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

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public int getBodyParts() {
		return bodyParts;
	}

	public void setBodyParts(int bodyParts) {
		this.bodyParts = bodyParts;
	}
	
	
}
