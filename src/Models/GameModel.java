package Models;

public class GameModel {
	private int gameId;
	private String snakeSkin;
	private String userNickName;
	private int totalScore;
	private int totalMovements;
	private int totalFruitOne;
	private int totalFruitTwo;
	private int totalFruitThree;
	
	public GameModel(int gameId) {
		this.gameId = gameId;
		this.userNickName = "";
		this.snakeSkin = "";
		this.totalScore = 0;
		this.totalMovements = 0;
		this.totalFruitOne = 0;
		this.totalFruitTwo = 0;
		this.totalFruitThree = 0;
	}

	// Getters & Setters
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	
	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalMovements() {
		return totalMovements;
	}

	public void setTotalMovements(int totalMovements) {
		this.totalMovements = totalMovements;
	}

	public int getTotalFruitOne() {
		return totalFruitOne;
	}

	public void setTotalFruitOne(int totalFruitOne) {
		this.totalFruitOne = totalFruitOne;
	}

	public int getTotalFruitTwo() {
		return totalFruitTwo;
	}

	public void setTotalFruitTwo(int totalFruitTwo) {
		this.totalFruitTwo = totalFruitTwo;
	}

	public int getTotalFruitThree() {
		return totalFruitThree;
	}

	public void setTotalFruitThree(int totalFruitThree) {
		this.totalFruitThree = totalFruitThree;
	}

	public String getSnakeSkin() {
		return snakeSkin;
	}

	public void setSnakeSkin(String snakeSkin) {
		this.snakeSkin = snakeSkin;
	}
}
