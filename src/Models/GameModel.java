package Models;

/**
 * La clase GameModel representa el modelo de los datos de cada partida.
 */
public class GameModel {
	private String gameId;
	private String snakeSkin;
	private String userNickName;
	private int totalScore;
	private int totalMovements;
	private int totalFruits;
	private int maxLevel;
	
	/**
     * Constructor de GameModel.
     * Inicializa un nuevo modelo de juego con valores predeterminados.
     */
	public GameModel() {
		this.gameId = "";
		this.userNickName = "";
		this.snakeSkin = "";
		this.totalScore = 0;
		this.totalMovements = 0;
		this.totalFruits = 0;
		this.maxLevel = 0;
	}

	/**
     * Obtiene el ID del juego.
     *
     * @return El ID del juego.
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Establece el ID del juego.
     *
     * @param gameId El nuevo ID del juego.
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * Obtiene el apodo del usuario.
     *
     * @return El apodo del usuario.
     */
    public String getUserNickName() {
        return userNickName;
    }

    /**
     * Establece el apodo del usuario.
     *
     * @param userNickName El nuevo apodo del usuario.
     */
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    /**
     * Obtiene la puntuación total.
     *
     * @return La puntuación total.
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Establece la puntuación total.
     *
     * @param totalScore La nueva puntuación total.
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * Obtiene los movimientos totales.
     *
     * @return Los movimientos totales.
     */
    public int getTotalMovements() {
        return totalMovements;
    }

    /**
     * Establece los movimientos totales.
     *
     * @param totalMovements Los nuevos movimientos totales.
     */
    public void setTotalMovements(int totalMovements) {
        this.totalMovements = totalMovements;
    }

    /**
     * Obtiene las frutas totales.
     *
     * @return Las frutas totales.
     */
    public int getTotalFruits() {
        return totalFruits;
    }

    /**
     * Establece las frutas totales.
     *
     * @param totalFruits Las nuevas frutas totales.
     */
    public void setTotalFruits(int totalFruits) {
        this.totalFruits = totalFruits;
    }

    /**
     * Obtiene la piel de la serpiente.
     *
     * @return La piel de la serpiente.
     */
    public String getSnakeSkin() {
        return snakeSkin;
    }

    /**
     * Establece la piel de la serpiente.
     *
     * @param snakeSkin La nueva piel de la serpiente.
     */
    public void setSnakeSkin(String snakeSkin) {
        this.snakeSkin = snakeSkin;
    }

    /**
     * Obtiene el nivel máximo.
     *
     * @return El nivel máximo.
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     * Establece el nivel máximo.
     *
     * @param maxLevel El nuevo nivel máximo.
     */
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}
