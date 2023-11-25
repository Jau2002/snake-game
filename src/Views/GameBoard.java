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

import Utils.Fruit;
import Utils.Snake;

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
	private GamePanel parent;
	
	private Color gameBoardColor;
	private Color gridColor;
	
	public GameBoard(int screenWidth, int screenHeight, Snake snake, ScoreSection scores, GamePanel gameParent) {
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
		
		this.parent = gameParent;
		
		this.gameBoardColor = new Color(0,0,0);
		this.gridColor = new Color(20,20,20);
		
		// Setting gameBoard
		random = new Random();
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(gameBoardColor);
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
	        timer = null;
	    }
		
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
		}
	}
	
	public void drawGrid(Graphics g) {
		g.setColor(gridColor);
		
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
		
		if (currentScore >= 20 && currentScore <= 40) {
			if(!currentLevel.equals("2")) {
				scores.getCurrentLevel().setText("2");
				newSpeed = gameSpeed -= 20;
				
				gameBoardColor = new Color(190, 190, 190);
				this.setBackground(gameBoardColor);
			}
		}

		if(currentScore > 50 && currentScore <= 90) {
			if(!currentLevel.equals("3")) {
				scores.getCurrentLevel().setText("3");
				newSpeed = gameSpeed -= 20;
				
				gameBoardColor = new Color(110, 110, 110);
				this.setBackground(gameBoardColor);
			}
		}

		if(currentScore > 90 && currentScore <= 140) {
			if(!currentLevel.equals("4")) {
				scores.getCurrentLevel().setText("4");
				newSpeed = gameSpeed -= 30;
				
				gameBoardColor = new Color(90, 90, 90);
				this.setBackground(gameBoardColor);
			}
		}

		if (currentScore > 140 && currentScore <= 200) {
			if(!currentLevel.equals("5")) {
				scores.getCurrentLevel().setText("5");
				newSpeed = gameSpeed -= 30;
				
				gameBoardColor = new Color(20, 20, 20);
				this.setBackground(gameBoardColor);
			}
		}

		if (currentScore > 200) {
			if(!currentLevel.equals("6")) {
				scores.getCurrentLevel().setText("6");
				newSpeed = gameSpeed -= 40;
				
				gameBoardColor = new Color(0, 0, 0);
				this.setBackground(gameBoardColor);
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
			
			String totalScore = scores.getTotalScore().getText();
			String totalMovements = scores.getTotalMovements().getText();
			String finalFruits = scores.getFruitsEaten().getText();
			String finalLevel = scores.getCurrentLevel().getText();
			String snakeSkinName = gameSnake.getSkinName();
			
			parent.insertGameOver(totalScore, totalMovements, finalFruits, finalLevel, snakeSkinName);
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
			
			if (running != false) {
				int moves = convertStringToInt(scores.getTotalMovements().getText());
				moves += 1;
				
				scores.getTotalMovements().setText(""+moves);				
			}
		}
	}
	
}
