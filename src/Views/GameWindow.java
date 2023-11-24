package Views;

import java.awt.Dimension;

import javax.swing.JFrame;

import Controllers.GameController;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	private GamePanel app;
	private GameController controller;
	
	public GameWindow(GameController appController) {
		controller = appController;
		app = new GamePanel(controller);
		
		this.add(app);
		this.setTitle("Snake Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(610, 700));
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public GamePanel getApp() {
		return app;
	}
	
	
}
