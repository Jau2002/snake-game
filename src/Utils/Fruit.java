package Utils;

import java.awt.Color;

/**
 * La clase Fruit representa una fruta en el juego.
 */
public class Fruit {
    private int fruitX;
    private int fruitY;
    private int prob;
    private int givenPoints;
    private int givenLength;
    private String fruitType;
    private Color color;

    /**
     * Constructor de Fruit.
     *
     * @param fruitX La posición X de la fruta.
     * @param fruitY La posición Y de la fruta.
     * @param prob La probabilidad de que aparezca esta fruta.
     */
    public Fruit(int fruitX, int fruitY, int prob) {
        this.fruitX = fruitX;
        this.fruitY = fruitY;
        this.prob = prob;

        checkPoints(this.prob);
    }

    /**
     * Comprueba los puntos dados por la fruta en función de la probabilidad.
     *
     * @param prob La probabilidad de que aparezca esta fruta.
     */
    private void checkPoints(int prob) {
        if (prob <= 10) {
            fruitType = "Cherry";
            givenPoints = 12;
            givenLength = 5;
            color = new Color(222, 0, 0);
        } else if (prob <= 30 && prob > 10) {
            fruitType = "Banana";
            givenPoints = 7;
            givenLength = 2;
            color = new Color(255, 225, 53);
        } else {
            fruitType = "Strawberry";
            givenPoints = 3;
            givenLength = 1;
            color = new Color(252, 90, 141);
        }
    }

    /**
     * Obtiene la posición X de la fruta.
     *
     * @return La posición X de la fruta.
     */
    public int getFruitX() {
        return fruitX;
    }

    /**
     * Establece la posición X de la fruta.
     *
     * @param fruitX La nueva posición X de la fruta.
     */
    public void setFruitX(int fruitX) {
        this.fruitX = fruitX;
    }

    /**
     * Obtiene la posición Y de la fruta.
     *
     * @return La posición Y de la fruta.
     */
    public int getFruitY() {
        return fruitY;
    }

    /**
     * Establece la posición Y de la fruta.
     *
     * @param fruitY La nueva posición Y de la fruta.
     */
    public void setFruitY(int fruitY) {
        this.fruitY = fruitY;
    }

    /**
     * Obtiene la probabilidad de que aparezca esta fruta.
     *
     * @return La probabilidad de que aparezca esta fruta.
     */
    public int getProb() {
        return prob;
    }

    /**
     * Establece la probabilidad de que aparezca esta fruta.
     *
     * @param prob La nueva probabilidad de que aparezca esta fruta.
     */
    public void setProb(int prob) {
        this.prob = prob;
    }

    /**
     * Obtiene los puntos dados por la fruta.
     *
     * @return Los puntos dados por la fruta.
     */
    public int getGivenPoints() {
        return givenPoints;
    }

    /**
     * Establece los puntos dados por la fruta.
     *
     * @param givenPoints Los nuevos puntos dados por la fruta.
     */
    public void setGivenPoints(int givenPoints) {
        this.givenPoints = givenPoints;
    }

    /**
     * Obtiene la longitud dada por la fruta.
     *
     * @return La longitud dada por la fruta.
     */
    public int getGivenLength() {
        return givenLength;
    }

    /**
     * Establece la longitud dada por la fruta.
     *
     * @param givenLength La nueva longitud dada por la fruta.
     */
    public void setGivenLength(int givenLength) {
        this.givenLength = givenLength;
    }

    /**
     * Obtiene el tipo de fruta.
     *
     * @return El tipo de fruta.
     */
    public String getFruitType() {
        return fruitType;
    }

    /**
     * Establece el tipo de fruta.
     *
     * @param fruitType El nuevo tipo de fruta.
     */
    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    /**
     * Obtiene el color de la fruta.
     *
     * @return El color de la fruta.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Establece el color de la fruta.
     *
     * @param color El nuevo color de la fruta.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
