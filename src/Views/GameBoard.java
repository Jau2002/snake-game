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
import javax.swing.border.EmptyBorder;

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
	private ScoreSection scores;
	
	public GameBoard(int screenWidth, int screenHeight, Snake snake, ScoreSection scores) {
		// Board Initial conditions
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;		
		this.unitSize = 25;
		this.gameUnits = (screenWidth * screenHeight)/unitSize;
		this.gameSpeed = 150;
		this.direction = 'R';
		
		// Set score data
		this.scores = scores;
		
		// Set Snake
		gameSnake = snake;
		
		// Setting gameBoard
		random = new Random();
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.addKeyListener(new BoardKeyAdapter());				
		
		startGame();
	}
	
	public void startGame() {		
		newFruit();
		running = true;
		initializeTimer();		
	}
	
	private void initializeTimer() {
		if (timer != null) {
	        timer.stop();
	        timer = null; // Libera recursos
	    }
		
	    // Asegúrate de que gameSpeed tenga un valor inicial adecuado
	    timer = new Timer(gameSpeed, this);
	    timer.setInitialDelay(0);
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
	
	public void drawFruit(Graphics g) {
		int x = currentFruit.getFruitX();
		int y = currentFruit.getFruitY();
		Color fruitColor = currentFruit.getColor();
		
		if (currentFruit.getFruitType().equals("Cherry") || currentFruit.getFruitType().equals("Banana")) {
			//System.out.println("Debug: X=" + currentFruit.getFruitX() + ", Y=" + currentFruit.getFruitY());			
		}
		
		g.setColor(fruitColor);
		g.fillOval(x, y, unitSize, unitSize);
	}
	
	public void drawSnake(Graphics g) {
		int bodyParts = gameSnake.getBodyParts();
		int snakeX[] = gameSnake.getX();
		int snakeY[] = gameSnake.getY();
		Color headColor = gameSnake.getSnakeHeadColor();
		Color bodyColor = gameSnake.getSnakeBodyColor();
		
		for(int i = 0; i < bodyParts; i++) {
			if (i == 0) {
				g.setColor(headColor);
				g.fillRect(snakeX[i], snakeY[i], unitSize, unitSize);
			} else {
				g.setColor(bodyColor);
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
			int fruitsEaten = this.convertStringToInt(scores.getFruitsEaten().getText());
			fruitsEaten += 1;
			
			int fruitScore = this.convertStringToInt(scores.getTotalScore().getText());
			fruitScore += currentFruit.getGivenPoints();
			
			scores.getFruitsEaten().setText(""+fruitsEaten);
			scores.getTotalScore().setText(""+fruitScore);
			
			int newWidth = bodyParts + currentFruit.getGivenLength();
			gameSnake.setBodyParts(newWidth);
			
			checkLevel();			
			newFruit();
		}
	}
	
	public void checkLevel() {
		int currentScore = this.convertStringToInt(scores.getTotalScore().getText());
		String currentLevel = scores.getCurrentLevel().getText();
		int newSpeed = 0;
		
		if (currentScore >= 40 && currentScore <= 90) {
			if(!currentLevel.equals("2")) {
				scores.getCurrentLevel().setText("2");
				newSpeed = gameSpeed -= 15;
			}
		}

		if(currentScore > 90 && currentScore <= 160) {
			if(!currentLevel.equals("3")) {
				scores.getCurrentLevel().setText("3");
				newSpeed = gameSpeed -= 15;
			}
		}

		if(currentScore > 160 && currentScore <= 210) {
			if(!currentLevel.equals("4")) {
				scores.getCurrentLevel().setText("4");
				newSpeed = gameSpeed -= 15;
			}
		}

		if (currentScore > 210 && currentScore <= 270) {
			if(!currentLevel.equals("5")) {
				scores.getCurrentLevel().setText("5");
				newSpeed = gameSpeed -= 15;
			}
		}

		if (currentScore > 270) {
			if(!currentLevel.equals("6")) {
				scores.getCurrentLevel().setText("6");
				newSpeed = gameSpeed -= 15;
			}
		}
		
		if (newSpeed != 0) {
			gameSpeed = newSpeed;
			initializeTimer();
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
		if(snakeX[0] == screenWidth) {
			running = false;
		}
		// Top border
		if(snakeY[0] < 0) {
			running = false;
		}
		// bottom Border
		if(snakeY[0] == screenHeight) {
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
		
		revalidate();
		repaint();
	}
	
	public void newFruit() {
		int prob = random.nextInt(100) + 1;

	    int x, y;
	    do {
	        x = random.nextInt((int) (screenWidth / unitSize)) * unitSize;
	        y = random.nextInt((int) (screenHeight / unitSize)) * unitSize;
	    } while (isSnakePart(x, y));

	    currentFruit = new Fruit(x, y, prob);
	}
	
	public boolean isSnakePart(int x, int y) {
		int bodyParts = gameSnake.getBodyParts();
		int snakeX[] = gameSnake.getX();
		int snakeY[] = gameSnake.getY();
		
	    for (int i = 0; i < bodyParts; i++) {
	        if (x == snakeX[i] && y == snakeY[i]) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public int convertStringToInt(String str) {
	    int num = 0;
	    try {
	        num = Integer.parseInt(str);
	    } catch (NumberFormatException e) {
	        System.out.println("Error: la cadena no puede convertirse a un entero.");
	    }
	    return num;
	}
	
	public class BoardKeyAdapter extends KeyAdapter {	
		// Bug conflicto
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
			
			int moves = convertStringToInt(scores.getTotalMovements().getText());
			moves += 1;
			
			scores.getTotalMovements().setText(""+moves);
		}
	}
	
}
