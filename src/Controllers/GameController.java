package Controllers;


import java.util.UUID;

import Models.GameModel;
import Models.UsersHistory;
import Views.GameWindow;

public class GameController {
	private GameWindow window;
	private UsersHistory records;

	public GameController() {
		records = new UsersHistory();
		startGame();
	}

	public void startGame() {
		window = new GameWindow(this);
	}

	public GameWindow getWindow() {
		return window;
	}

	public UsersHistory getRecords() {
		return records;
	}

	public void getGameRecord(String score, String movements, String fruits, String level, String snakeSkinName, String nickname) {
		GameModel gameFinalScore = new GameModel();

		String newId = generateGameId();
		int totalScore = convertStringToInt(score);
		int totalMovements = convertStringToInt(movements);
		int totalFruits = convertStringToInt(fruits);
		int maxLevel = convertStringToInt(level);

		gameFinalScore.setGameId(newId);
		gameFinalScore.setTotalScore(totalScore);
		gameFinalScore.setTotalMovements(totalMovements);
		gameFinalScore.setTotalFruits(totalFruits);
		gameFinalScore.setMaxLevel(maxLevel);
		gameFinalScore.setSnakeSkin(snakeSkinName);
		gameFinalScore.setUserNickName(nickname);

		records.saveNewRecord(gameFinalScore);
	}

	public int convertStringToInt(String str) {
	    try {
	        return Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        System.out.println("El string no puede ser convertido a entero");
	        return 0;
	    }
	}

	public static String generateGameId() {
        return UUID.randomUUID().toString();
    }
}