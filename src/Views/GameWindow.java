package Views;


import java.awt.Dimension;

import javax.swing.JFrame;

import Controllers.GameController;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
    private GamePanel app;
    private GameController controller;

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

    public GamePanel getApp() {
        return app;
    }
}
