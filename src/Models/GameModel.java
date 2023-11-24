package Models;

public class GameModel {
	private int gameId;
	private String snakeSkin;
	private String userNickName;
	private int totalScore;
	private int totalMovements;
	private int totalFruits;
	
	public GameModel(int gameId) {
		this.gameId = gameId;
		this.userNickName = "";
		this.snakeSkin = "";
		this.totalScore = 0;
		this.totalMovements = 0;
		this.totalFruits = 0;
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

	public int getTotalFruits() {
		return totalFruits;
	}

	public void setTotalFruitOne(int totalFruits) {
		this.totalFruits = totalFruits;
	}
	public String getSnakeSkin() {
		return snakeSkin;
	}

	public void setSnakeSkin(String snakeSkin) {
		this.snakeSkin = snakeSkin;
	}
}
