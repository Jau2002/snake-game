package Controllers;

import java.util.UUID;
import Models.GameModel;
import Models.UsersHistory;
import Views.GameWindow;

/**
 * La clase GameController controla el flujo del juego.
 */
public class GameController {
	private GameWindow window;
	private UsersHistory records;

	/**
	 * Constructor de GameController.
	 * Inicializa los registros de los usuarios e inicia el juego.
	 */
	public GameController() {
		records = new UsersHistory();
		startGame();
	}

	/**
	 * Inicia el juego creando una nueva ventana de juego.
	 */
	public void startGame() {
		window = new GameWindow(this);
	}

	/**
	 * Devuelve la ventana del juego.
	 *
	 * @return La ventana del juego.
	 */
	public GameWindow getWindow() {
		return window;
	}

	/**
	 * Devuelve los registros de los usuarios.
	 *
	 * @return Los registros de los usuarios.
	 */
	public UsersHistory getRecords() {
		return records;
	}

	/**
	 * Obtiene el registro del juego y lo guarda en los registros de los usuarios.
	 *
	 * @param score El puntaje del juego.
	 * @param movements Los movimientos realizados en el juego.
	 * @param fruits Las frutas recogidas en el juego.
	 * @param level El nivel alcanzado en el juego.
	 * @param snakeSkinName El nombre de la piel de la serpiente utilizada en el juego.
	 * @param nickname El apodo del usuario.
	 */
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

	/**
	 * Convierte un string a un entero.
	 *
	 * @param str El string a convertir.
	 * @return El entero convertido, o 0 si el string no puede ser convertido a entero.
	 */
	public int convertStringToInt(String str) {
	    try {
	        return Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        System.out.println("El string no puede ser convertido a entero");
	        return 0;
	    }
	}

	/**
	 * Genera un ID de juego único.
	 *
	 * @return Un ID de juego único.
	 */
	public static String generateGameId() {
        return UUID.randomUUID().toString();
    }
}
