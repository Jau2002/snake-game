package Views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class ScoreSection extends JPanel {
	private JLabel totalScore;
	private JLabel totalMovements;
	private JLabel fruitsEaten;
	private JLabel currentLevel;
	
	public ScoreSection() {
		this.setLayout(new GridLayout(1,4));
		this.setPreferredSize(new Dimension(600, 60));
		this.setBorder(new EmptyBorder(0,0,0,0));
		initializeComponents();
		this.setVisible(true);
	}
	
	public void initializeComponents() {
		insertCurrentLevelSection();
		insertScoreSection();
		insertTotalMovementsSection();
		insertFruitsEatenSection();
	}
	
	public void insertCurrentLevelSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));

	    JLabel title = createLabel("Level:");
	    currentLevel = createLabel("1");

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);

	    gbc.gridy = 1;
	    section.add(currentLevel, gbc);

	    this.add(section);
	}
	
	public void insertScoreSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));
		
		JLabel title = createLabel("Score:");
		totalScore = createLabel("0");
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);

	    gbc.gridy = 1;
	    section.add(totalScore, gbc);
		
		this.add(section);
	}
	
	public void insertTotalMovementsSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));
		
		JLabel title = createLabel("Movements:");
		totalMovements = createLabel("0");
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);
	    
	    gbc.gridy = 1;
	    section.add(totalMovements, gbc);
		
		this.add(section);
	}
	
	public void insertFruitsEatenSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));
		
		JLabel title = createLabel("Fruits eaten:");
		fruitsEaten = createLabel("0");
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);
	    
	    gbc.gridy = 1;
		section.add(fruitsEaten, gbc);
		
		this.add(section);
	}
	
	public JLabel createLabel(String text) {
		JLabel newText = new JLabel(text);
		return newText;
	}

	public JLabel getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(JLabel totalScore) {
		this.totalScore = totalScore;
	}

	public JLabel getTotalMovements() {
		return totalMovements;
	}

	public void setTotalMovements(JLabel totalMovements) {
		this.totalMovements = totalMovements;
	}

	public JLabel getFruitsEaten() {
		return fruitsEaten;
	}

	public void setFruitsEaten(JLabel fruitsEaten) {
		this.fruitsEaten = fruitsEaten;
	}

	public JLabel getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(JLabel currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	
}
