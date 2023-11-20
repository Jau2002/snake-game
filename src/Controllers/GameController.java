package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.GameWindow;

public class GameController implements ActionListener{
	@SuppressWarnings("unused")
	private GameWindow window;
	
	public GameController() {
		startGame();
	}
	
	public void startGame() {
		window = new GameWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
