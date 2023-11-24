package Views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class GameMenu extends JPanel{
	private JButton arcadeModeButton;
	private JButton personalizedModeButton;
	private JButton leadBoardButton;
	
	public GameMenu() {
		this.setLayout(new GridLayout(4,1));
		this.setBorder(new EmptyBorder(0,0,0,0));
		initializeComponents();
		this.setVisible(true);
	}
	
	public void initializeComponents() {
		insertTitle();
		insertArcadeModeButton();
		insertPersonalizedModeButton();
		insertLeadBoardButton();
	}
	
	public void insertTitle(){
		JLabel mainTitle = new JLabel("Snake Game");
		mainTitle.setFont(new Font("Arial", Font.BOLD, 45));
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        this.add(mainTitle);
	}
	
	public void insertArcadeModeButton() {
		arcadeModeButton = new JButton("Arcade Mode");
		arcadeModeButton.setPreferredSize(new Dimension(150, 40));
		arcadeModeButton.setFont(new Font("Arial", Font.BOLD, 25));
		arcadeModeButton.setActionCommand("arcadeMode");
		
		this.add(arcadeModeButton);
	}
	
	public void insertPersonalizedModeButton() {
		personalizedModeButton = new JButton("Personalized Mode");
		personalizedModeButton.setPreferredSize(new Dimension(150, 40));
		personalizedModeButton.setFont(new Font("Arial", Font.BOLD, 25));
		personalizedModeButton.setActionCommand("personalizedMode");
		
        this.add(personalizedModeButton);
	}
	
	public void insertLeadBoardButton() {
		leadBoardButton = new JButton("Lead board");
		leadBoardButton.setPreferredSize(new Dimension(150, 40));
		leadBoardButton.setFont(new Font("Arial", Font.BOLD, 25));
		leadBoardButton.setActionCommand("leadBoard");
		
        this.add(leadBoardButton);
	}

	public JButton getArcadeModeButton() {
		return arcadeModeButton;
	}

	public JButton getPersonalizedModeButton() {
		return personalizedModeButton;
	}

	public JButton getLeadBoardButton() {
		return leadBoardButton;
	}	
}
