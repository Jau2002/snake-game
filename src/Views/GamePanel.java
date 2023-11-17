package Views;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener{
	
	// Board
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	// Determina el tamaño de los cuadrados
	static final int UNIT_SIZE = 25;
	
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 75;
	
	//Snake
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];	
	int bodyParts = 6;
	
	// Fruits
	int fruitsEaten;
	int fruitX;
	int fruitY;
	
	// Snake Direction, possible values 'U', 'D', 'L', 'R'
	char direction = 'R';
	
	// checks if snake is running
	boolean running = false;
	
	// Timer
	Timer timer;
	Random random;

	public GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new GameKeyAdapter());
		startGame();
	}
	
	public void startGame() {
		newFruit();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
	}
	
	public void draw(Graphics g) {		
		if (running) {
			for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {
				// drawLine(x1,x2,y1,y2)
				// Draw vertical lines
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				// Draw horizontal lines
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
			
			// drawing fruit
			g.setColor(Color.red);
			g.fillOval(fruitX, fruitY, UNIT_SIZE, UNIT_SIZE);
			
			// drawing Snake
			for(int i = 0; i < bodyParts; i++) {
				if (i == 0) {
					g.setColor(Color.GREEN);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}		
			
			// Drawing score
			printScore(g);
		} else {
			gameOver(g);
		}
	}
	
	public void newFruit() {
		// Determining the fruit location in X and Y axis according to the width and height of the board and the size of each unit
		fruitX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		fruitY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE; 
 	}
	
	public void printScore(Graphics g) {
		// Game Over text
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: " + fruitsEaten, ((SCREEN_WIDTH - metrics.stringWidth("Score" + fruitsEaten))/2), g.getFont().getSize());
	}
	
	public void move() {
		for (int i = bodyParts; i>0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		
		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE; 
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		default:
			break;
		}
	}
	
	public void checkFruit() {
		if((x[0] == fruitX) && (y[0] == fruitY)) {
			bodyParts++;
			fruitsEaten++;
			newFruit();
		}
	}
	
	public void checkCollitions() {
		// checks if head collides with body
		for (int i = bodyParts; i > 0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}	
		
		// check if head collides with borders
		// Left Border
		if(x[0] < 0) {
			running = false;
		}
		// Right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		// Top border
		if(y[0] < 0) {
			running = false;
		}
		// bottom Border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		
		if (!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		printScore(g);
		// Game Over text
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", ((SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2), SCREEN_HEIGHT/2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(running) {
			move();
			checkFruit();
			checkCollitions();			
		}
		
		repaint();
	}
	
	public class GameKeyAdapter extends KeyAdapter {
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

}
