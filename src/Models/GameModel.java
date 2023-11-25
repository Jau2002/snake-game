package Models;

public class GameModel {
	private int gameId;
	private String snakeSkin;
	private String userNickName;
	private int totalScore;
	private int totalMovements;
	private int totalFruits;
	private int maxLevel;
	
	public GameModel(int gameId, int score, int movements, int fruits, int level, String snakeSkin, String nickName) {
		this.gameId = gameId;
		this.userNickName = nickName;
		this.snakeSkin = snakeSkin;
		this.totalScore = score;
		this.totalMovements = movements;
		this.totalFruits = fruits;
		this.maxLevel = level;
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
