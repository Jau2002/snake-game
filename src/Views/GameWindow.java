package Views;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	private GamePanel app;
	
	public GameWindow() {
		app = new GamePanel();
		
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
