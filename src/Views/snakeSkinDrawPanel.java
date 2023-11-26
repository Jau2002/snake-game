package Views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * La clase snakeSkinDrawPanel representa el panel de dibujo de la piel de la serpiente en el juego.
 */
@SuppressWarnings("serial")
public class snakeSkinDrawPanel extends JPanel {
    private Color snakeHeadColor = new Color(0, 255, 0);
    private Color snakeBodyColor = new Color(128, 255, 128);

    /**
     * Constructor de snakeSkinDrawPanel.
     * Inicializa el panel de dibujo de la piel de la serpiente.
     */
    public snakeSkinDrawPanel() {
        setVisible(true);
    }

    /**
     * Establece el color de la serpiente en el panel de dibujo.
     *
     * @param headColor El color de la cabeza de la serpiente.
     * @param bodyColor El color del cuerpo de la serpiente.
     */
    public void setSnakeColor(Color headColor, Color bodyColor) {
        this.snakeHeadColor = headColor;
        this.snakeBodyColor = bodyColor;
        repaint();
    }
    
    /**
     * Dibuja los componentes en el panel de dibujo.
     *
     * @param g Los gráficos utilizados para dibujar.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    /**
     * Dibuja la serpiente en el panel de dibujo.
     *
     * @param g Los gráficos utilizados para dibujar.
     */
    public void draw(Graphics g) {
        drawSnake(g);
    }

    /**
     * Dibuja la serpiente en el panel de dibujo.
     *
     * @param g Los gráficos utilizados para dibujar.
     */
    public void drawSnake(Graphics g) {
        int bodyParts = 6;
        int snakeX[] = new int[35];
        int snakeY[] = new int[35];

        int initialX = (getWidth() - bodyParts * 35) / 2;
        int initialY = (getHeight() - 35) / 2;

        for (int i = 0; i < bodyParts; i++) {
            snakeX[i] = initialX + i * 35;
            snakeY[i] = initialY;
        }
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(snakeHeadColor);
                g.fillRect(snakeX[i], snakeY[i], 35, 35);
            } else {
                g.setColor(snakeBodyColor);
                g.fillRect(snakeX[i], snakeY[i], 35, 35);
            }
        }
    }
}
