package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import Controllers.GameController;
import Models.Snake;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
	private GameMenu menu;
	private SkinSelection selectSkin;
	private JPanel game;
	private GameBoard board;
	private ScoreSection scores;
	private GameOver go;
	private GameController controller;
	
	public GamePanel(GameController controller) {
		this.controller = controller;		
		
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.setVisible(true);
		startGame();
	}
	
	public void startGame() {
		insertMenu();
	}
	
	public void insertMenu() {
		menu = new GameMenu();
		this.add(menu);
		this.revalidate();
	    this.repaint();
	    
	    menu.setPreferredSize(new Dimension(600, 660));
	    
	    JButton arcadeModeButton = menu.getArcadeModeButton();
		JButton personalizedModeButton = menu.getPersonalizedModeButton();
		JButton leadBoardButton = menu.getLeadBoardButton();
		
		arcadeModeButton.addActionListener(this);
		personalizedModeButton.addActionListener(this);
		leadBoardButton.addActionListener(this);
	}
	
	public void insertSkinSelection() {
		selectSkin = new SkinSelection();
		
		this.removeMenu();		
		this.add(selectSkin);
		this.revalidate();
	    this.repaint();	  
	    
	    // Select Skin Elements
	 	JButton skinSectionStartButton = selectSkin.getStartGame();
	 	skinSectionStartButton.addActionListener(this);
	}
	
	public void insertGameOver(String score, String movements, String fruits, String level, String snakeSkinName) {
		this.removeBoard();
		
		go = new GameOver(score, movements, fruits, level, snakeSkinName, controller);
		this.add(go);
		this.revalidate();
		this.repaint();
		
		JButton menuButton = go.getmenuButton();
		JButton retryButton = go.getResetButton();
		
		menuButton.addActionListener(this);
		retryButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String c = e.getActionCommand();
		
		validateAction(c);
	}	
	
	public void validateAction(String c) {
		if (c.equals("arcadeMode")) {
			this.setArcadeMode();
		} else if (c.equals("personalizedMode")) {
			
		} else if(c.equals("leadBoard")) {
			
		} else if(c.equals("skinStartGame")) {
			String skinName = selectSkin.getSkinName();
			Color snakeHeadColor = selectSkin.getHeadColor();
			Color snakeBodyColor = selectSkin.getBodyColor();
			
			Snake newSnake = new Snake(4, skinName, snakeHeadColor, snakeBodyColor);			
			removeSkinSelection();			
			createNewGame(newSnake);
		} else if (c.equals("tryAgain")) {
			this.removeGameOver();
			this.setArcadeMode();
		} else if (c.equals("backMenu")) {
			this.removeGameOver();
			startGame();
		}
		
	}
	
	public void setArcadeMode() {
		this.removeMenu();
		insertSkinSelection();	
	}
	
	public void createNewGame(Snake snake) {		
		game = new JPanel();
		game.setLayout(new BorderLayout());

		scores = new ScoreSection();
		board = new GameBoard(600, 600, snake, scores, this);

		game.add(scores, BorderLayout.NORTH);
		game.add(board, BorderLayout.CENTER);
		
		this.add(game);
		this.revalidate();
		this.repaint();
		board.requestFocusInWindow();
	}
	
	public void setPersonalizedMode() {
		
	}
	
	public void selectGameBoardType() {
		
	}
	
	public void removeMenu() {
		this.remove(menu);
		this.revalidate();
	    this.repaint();
	}
	
	public void removeBoard() {
		this.remove(game);
		this.revalidate();
	    this.repaint();
	}
	
	public void removeSkinSelection() {
		this.remove(selectSkin);
		this.revalidate();
	    this.repaint();
	}
	
	public void removeGameOver() {
		this.remove(go);
		this.revalidate();
	    this.repaint();
	}
	
	public GameMenu getMenu() {
		return menu;
	}
	
	public GameBoard getBoard() {
		return board;
	}
	
	public GameOver getGO() {
		return go;
	}
	
}
