package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import Models.Snake;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener{
	private GameMenu menu;
	private SkinSelection selectSkin;
	private JPanel game;
	private GameBoard board;
	private ScoreSection scores;
	
	public GamePanel() {
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
		board = new GameBoard(600, 600, snake, scores);

		game.add(scores, BorderLayout.NORTH);
		game.add(board, BorderLayout.CENTER);
		
		this.add(game);
		this.revalidate();
		this.repaint();
		board.requestFocusInWindow();
	}
	
	public void setPersonalizedMode() {
		
	}
	
	public void selectSnakeSkin() {
		
	}
	
	public void selectGameBoardType() {
		
	}
	
	public void removeMenu() {
		this.remove(menu);
		this.revalidate();
	    this.repaint();
	}
	
	public void removeBoard() {
		this.remove(board);
		this.revalidate();
	    this.repaint();
	}
	
	public void removeSkinSelection() {
		this.remove(selectSkin);
		this.revalidate();
	    this.repaint();
	}
	
	public GameMenu getMenu() {
		return menu;
	}
	
	public GameBoard getBoard() {
		return board;
	}
	
}
