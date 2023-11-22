package Controllers;

import Views.GameWindow;

public class GameController {
	private GameWindow window;
	
	public GameController() {
		startGame();
	}
	
	public void startGame() {
		window = new GameWindow();
	}
	
	public GameWindow getWindow() {
		return window;
	}
}