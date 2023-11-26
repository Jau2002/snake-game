package Views;

import java.awt.Dimension;
import javax.swing.JFrame;
import Controllers.GameController;

/**
 * La clase GameWindow representa la ventana del juego.
 */
@SuppressWarnings("serial")
public class GameWindow extends JFrame {
    private GamePanel app;
    private GameController controller;

    /**
     * Constructor de GameWindow.
     *
     * @param appController El controlador del juego.
     */
    public GameWindow(GameController appController) {
        controller = appController;
        app = new GamePanel(controller);
        add(app);
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(610, 700));
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Obtiene el panel del juego.
     *
     * @return El panel del juego.
     */
    public GamePanel getApp() {
        return app;
    }
}
