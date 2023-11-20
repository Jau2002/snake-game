package Views;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyAdapter extends KeyAdapter {
	private char direction;
	
	public GameKeyAdapter(GameBoard board) {
		this.direction = board.getDirection();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (direction != 'D') {
				direction = 'U';
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (direction != 'L') {
				direction = 'R';
			}
			break;
		case KeyEvent.VK_DOWN:
			if (direction != 'U') {
				direction = 'D';
			}
			break;
		case KeyEvent.VK_LEFT:
			if (direction != 'R') {
				direction = 'L';
			}
			break;
		default:
			break;
		}
	}
}
