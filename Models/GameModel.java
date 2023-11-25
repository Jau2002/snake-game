package Models;


public class GameModel {
	private String gameId;
	private String snakeSkin;
	private String userNickName;
	private int totalScore;
	private int totalMovements;
	private int totalFruits;
	private int maxLevel;
	
	public GameModel() {
		this.gameId = "";
		this.userNickName = "";
		this.snakeSkin = "";
		this.totalScore = 0;
		this.totalMovements = 0;
		this.totalFruits = 0;
		this.maxLevel = 0;
	}

	// Getters & Setters
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
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

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public void setTotalFruits(int totalFruits) {
		this.totalFruits = totalFruits;
	}
}
