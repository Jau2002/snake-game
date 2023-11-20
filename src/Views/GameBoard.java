package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import Models.Fruit;
import Models.Snake;
//import Views.GameKeyAdapter;

@SuppressWarnings("serial")
public class GameBoard extends JPanel implements ActionListener {	
	private int screenWidth;
	private int screenHeight;
	private int unitSize;
	private int gameUnits;
	private int gameSpeed;
	private boolean running = false;
	private char direction;
	Timer timer;
	Random random;
	
	private Snake gameSnake;
	private Fruit currentFruit;
	
	int fruitsEaten;
	int movesQuantity;
	int score;
	
	public GameBoard(int screenWidth, int screenHeight, String snakeSkin, int snakeBodyParts) {
		// Board Initial conditions
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;		
		this.unitSize = 25;
		this.gameUnits = (screenWidth * screenHeight)/unitSize;
		this.gameSpeed = 100;
		this.direction = 'R';
		
		// Set Snake
		gameSnake = new Snake(gameUnits, snakeSkin, snakeBodyParts);
		
		// Setting gameBoard
		random = new Random();
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new BoardKeyAdapter());
		startGame();
	}
	
	public void startGame() {
		newFruit();
		running = true;
		timer = new Timer(gameSpeed, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);		
	}
	
	public void draw(Graphics g) {		
		if (running) {
			drawGrid(g);
			drawFruit(g);
			drawSnake(g);
			
			// Drawing score
			//printScore(g);
		} else {
			//gameOver(g);
		}
	}
	
	public void drawGrid(Graphics g) {
		for (int i = 0; i < screenHeight/unitSize; i++) {
			// Draw vertical
			g.drawLine(i*unitSize, 0, i*unitSize, screenHeight);
			// Draw horizontal
			g.drawLine(0, i*unitSize, screenWidth, i*unitSize);
		}
	}
	
	public void newFruit() {
		int x = random.nextInt((int)(screenWidth/unitSize))*unitSize;
		int y = random.nextInt((int)(screenHeight/unitSize))*unitSize; 
		
		currentFruit = new Fruit(x, y);
		
 	}
	
	public void drawFruit(Graphics g) {
		int x = currentFruit.getFruitX();
		int y = currentFruit.getFruitY();
		
		g.setColor(Color.red);
		g.fillOval(x, y, unitSize, unitSize);
	}
	
	public void drawSnake(Graphics g) {
		int bodyParts = gameSnake.getBodyParts();
		int snakeX[] = gameSnake.getX();
		int snakeY[] = gameSnake.getY();
		
		for(int i = 0; i < bodyParts; i++) {
			if (i == 0) {
				g.setColor(Color.GREEN);
				g.fillRect(snakeX[i], snakeY[i], unitSize, unitSize);
			} else {
				g.setColor(new Color(45,180,0));
				g.fillRect(snakeX[i], snakeY[i], unitSize, unitSize);
			}
		}	
	}
	
	public void move() {
		int bodyParts = gameSnake.getBodyParts();
		int snakeX[] = gameSnake.getX();
		int snakeY[] = gameSnake.getY();
		
		for (int i = bodyParts; i>0; i--) {
			snakeX[i] = snakeX[i - 1];
			snakeY[i] = snakeY[i - 1];
		}
		
		switch (direction) {
		case 'U':
			snakeY[0] = snakeY[0] - unitSize; 
			break;
		case 'R':
			snakeX[0] = snakeX[0] + unitSize;
			break;
		case 'D':
			snakeY[0] = snakeY[0] + unitSize;
			break;
		case 'L':
			snakeX[0] = snakeX[0] - unitSize;
			break;
		default:
			break;
		}
	}
	
	public void checkFruit() {
		int bodyParts = gameSnake.getBodyParts();
		int snakeX[] = gameSnake.getX();
		int snakeY[] = gameSnake.getY();
		
		int fruitX = currentFruit.getFruitX();
		int fruitY = currentFruit.getFruitY();
		
		if((snakeX[0] == fruitX) && (snakeY[0] == fruitY)) {
			int newWidth = bodyParts + 1;
			gameSnake.setBodyParts(newWidth);
			fruitsEaten++;
			newFruit();
		}
	}
	
	public void checkCollitions() {
		int bodyParts = gameSnake.getBodyParts();
		int snakeX[] = gameSnake.getX();
		int snakeY[] = gameSnake.getY();
		// checks if head collides with body
		for (int i = bodyParts; i > 0; i--) {
			if((snakeX[0] == snakeX[i]) && (snakeY[0] == snakeY[i])) {
				running = false;
			}
		}	
		
		// check if head collides with borders
		// Left Border
		if(snakeX[0] < 0) {
			running = false;
		}
		// Right border
		if(snakeX[0] >= screenWidth) {
			running = false;
		}
		// Top border
		if(snakeY[0] < 0) {
			running = false;
		}
		// bottom Border
		if(snakeY[0] >= screenHeight) {
			running = false;
		}
		
		if (!running) {
			timer.stop();
		}
	}
	
	public char getDirection() {
		return direction;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(running) {
			move();
			checkFruit();
			checkCollitions();			
		}
		
		repaint();
	}
	
	public class BoardKeyAdapter extends KeyAdapter {		
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
