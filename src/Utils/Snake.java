package Utils;
import java.awt.Color;

/**
 * La clase Snake representa una serpiente en el juego.
 */
public class Snake {
    private int x[];
    private int y[];
    String skinName;
    Color snakeHeadColor;
    Color snakeBodyColor;
    private int bodyParts;
    private int gameUnits;

    /**
     * Constructor de Snake.
     *
     * @param bodyParts El número de partes del cuerpo de la serpiente.
     * @param skinName El nombre de la piel de la serpiente.
     * @param snakeHead El color de la cabeza de la serpiente.
     * @param snakeBody El color del cuerpo de la serpiente.
     */
    public Snake(int bodyParts, String skinName, Color snakeHead, Color snakeBody) {
        gameUnits = (600 * 600) / 25;
        x = new int[gameUnits];
        y = new int[gameUnits];
        this.bodyParts = bodyParts;
        this.skinName = skinName;
        this.snakeHeadColor = snakeHead;
        this.snakeBodyColor = snakeBody;
    }

    /**
     * Obtiene la posición X de la serpiente.
     *
     * @return La posición X de la serpiente.
     */
    public int[] getX() {
        return x;
    }

    /**
     * Establece la posición X de la serpiente.
     *
     * @param x La nueva posición X de la serpiente.
     */
    public void setX(int[] x) {
        this.x = x;
    }

    /**
     * Obtiene la posición Y de la serpiente.
     *
     * @return La posición Y de la serpiente.
     */
    public int[] getY() {
        return y;
    }

    /**
     * Establece la posición Y de la serpiente.
     *
     * @param y La nueva posición Y de la serpiente.
     */
    public void setY(int[] y) {
        this.y = y;
    }

    /**
     * Obtiene el nombre de la piel de la serpiente.
     *
     * @return El nombre de la piel de la serpiente.
     */
    public String getSkinName() {
        return skinName;
    }

    /**
     * Establece el nombre de la piel de la serpiente.
     *
     * @param skinName El nuevo nombre de la piel de la serpiente.
     */
    public void setSkinName(String skinName) {
        this.skinName = skinName;
    }

    /**
     * Obtiene el número de partes del cuerpo de la serpiente.
     *
     * @return El número de partes del cuerpo de la serpiente.
     */
    public int getBodyParts() {
        return bodyParts;
    }

    /**
     * Establece el número de partes del cuerpo de la serpiente.
     *
     * @param bodyParts El nuevo número de partes del cuerpo de la serpiente.
     */
    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    /**
     * Obtiene el color de la cabeza de la serpiente.
     *
     * @return El color de la cabeza de la serpiente.
     */
    public Color getSnakeHeadColor() {
        return snakeHeadColor;
    }

    /**
     * Establece el color de la cabeza de la serpiente.
     *
     * @param snakeHeadColor El nuevo color de la cabeza de la serpiente.
     */
    public void setSnakeHeadColor(Color snakeHeadColor) {
        this.snakeHeadColor = snakeHeadColor;
    }

    /**
     * Obtiene el color del cuerpo de la serpiente.
     *
     * @return El color del cuerpo de la serpiente.
     */
    public Color getSnakeBodyColor() {
        return snakeBodyColor;
    }

    /**
     * Establece el color del cuerpo de la serpiente.
     *
     * @param snakeBodyColor El nuevo color del cuerpo de la serpiente.
     */
    public void setSnakeBodyColor(Color snakeBodyColor) {
        this.snakeBodyColor = snakeBodyColor;
    }

    /**
     * Obtiene el número de unidades de juego.
     *
     * @return El número de unidades de juego.
     */
    public int getGameUnits() {
        return gameUnits;
    }

    /**
     * Establece el número de unidades de juego.
     *
     * @param gameUnits El nuevo número de unidades de juego.
     */
    public void setGameUnits(int gameUnits) {
        this.gameUnits = gameUnits;
    }
}
