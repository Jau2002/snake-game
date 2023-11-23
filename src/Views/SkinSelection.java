package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SkinSelection extends JPanel implements ActionListener{
	private snakeSkinDrawPanel snakeSection; 
	private JPanel snakeSelector;
	private Color headColor;
	private Color bodyColor;
	private String skinSelected;
	private JButton startGame;
	
	public SkinSelection() {
		this.setLayout(new GridLayout(4,1));
		this.setPreferredSize(new Dimension(600, 600));
		this.setBorder(new EmptyBorder(0,0,0,0));
		initializeComponents();
		this.setVisible(true);
	}
	
	public void initializeComponents() {
		insertTitle();
		insertSnakeSection();
		insertSkinSelector();
		insertSetGameButton();
	}
	
	public void insertTitle(){
		JLabel mainTitle = new JLabel("Select skin");
		mainTitle.setFont(new Font("Arial", Font.BOLD, 45));
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        this.add(mainTitle);
	}
	
	public void insertSnakeSection() {
		snakeSection = new snakeSkinDrawPanel();		
	    this.add(snakeSection);
	    repaint();
		
	}	
	
	public void insertSkinSelector() {
		String skins[] = {"Green", "Red", "Blue", "Violet", "Gray"};
		snakeSelector = new JPanel();
		snakeSelector.setLayout(new GridLayout(1, 5));
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 0; i < skins.length; i++) {
			JRadioButton newButton = getRadioButton(skins[i]);
			newButton.addActionListener(this);		
			group.add(newButton);
			
			if (skins[i].equals("Green")) {
				newButton.setSelected(true);
				setSkin("Green");
			}
			
			JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			buttonPanel.add(newButton);
			snakeSelector.add(buttonPanel);
		}
		
		this.add(snakeSelector);
	}
	
	public void insertSetGameButton() {
		startGame = new JButton("StartGame");
		startGame.setActionCommand("skinStartGame");
		startGame.setPreferredSize(new Dimension(220, 40));
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setPreferredSize(new Dimension(buttonPanel.getPreferredSize().width, 120));
		buttonPanel.add(startGame);
		this.add(buttonPanel);
	}
	
	public JRadioButton getRadioButton(String color) {
		JRadioButton button = new JRadioButton(color);
		button.setActionCommand(color);
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String skin = e.getActionCommand();
		setSkin(skin);
	}
	
	public void setSkin(String skin) {		
		
		skinSelected = skin;
		
		switch(skin) {
		case "Green":
			headColor = new Color(0, 255, 0);
			bodyColor = new Color(128, 255, 128);
			
			snakeSection.setSnakeColor(headColor, bodyColor);
			break;
		case "Red":
			headColor = new Color(255, 0, 0);
			bodyColor = new Color(255, 128, 128);
			
			snakeSection.setSnakeColor(headColor, bodyColor);
			break;
		case "Blue":
			headColor = new Color(0, 0, 255);
			bodyColor = new Color(128, 128, 255);
			
			snakeSection.setSnakeColor(headColor, bodyColor);
			break;
		case "Violet":
			headColor = new Color(148,0,211);
			bodyColor = new Color(186, 85, 211);
			
			snakeSection.setSnakeColor(headColor, bodyColor);
			break;
		case "Gray":
			headColor = new Color(128,128,128);
			bodyColor = new Color(192,192,192);
			
			snakeSection.setSnakeColor(headColor, bodyColor);
			break;
		default:
			break;
		}
	}

	public snakeSkinDrawPanel getSnakeSection() {
		return snakeSection;
	}

	public JPanel getSnakeSelector() {
		return snakeSelector;
	}

	public Color getHeadColor() {
		return headColor;
	}

	public Color getBodyColor() {
		return bodyColor;
	}

	public JButton getStartGame() {
		return startGame;
	}
	
	public String getSkinName() {
		return skinSelected;
	}
}
