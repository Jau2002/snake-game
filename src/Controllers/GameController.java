package Controllers;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;

import Views.GameWindow;

public class GameController {
	private GameWindow window;
	
	public GameController() {
		startGame();
	}
	
	public void startGame() {
		window = new GameWindow(this);
	}
	
	public GameWindow getWindow() {
		return window;
	}
	
	public void getGameRecord(String score, String movements, String fruits, String level, String snakeSkinName, String nickname) {
		System.out.println(
				"{"
				+ "\n " + "Nickname: " + nickname + "," 
				+ "\n " + "Score: " + score + ","
				+ "\n " + "Total Movements: " + movements + ","
				+ "\n " + "Total fruits: " + fruits + ","
				+ "\n " + "Max Level reached: " + level + ","
				+ "\n " + "Skin: " + snakeSkinName
				+ "\n}");
	}
}