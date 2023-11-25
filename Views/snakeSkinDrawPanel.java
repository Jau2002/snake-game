package Views;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class snakeSkinDrawPanel extends JPanel {
    private Color snakeHeadColor = new Color(0, 255, 0);
    private Color snakeBodyColor = new Color(128, 255, 128);

    public snakeSkinDrawPanel() {
        setVisible(true);
    }

    public void setSnakeColor(Color headColor, Color bodyColor) {
        this.snakeHeadColor = headColor;
        this.snakeBodyColor = bodyColor;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        drawSnake(g);
    }

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
