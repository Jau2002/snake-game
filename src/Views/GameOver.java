package Views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import Controllers.GameController;

/**
 * La clase GameOver representa la pantalla de fin de juego.
 */
@SuppressWarnings("serial")
public class GameOver extends JPanel implements ActionListener {
	private JLabel totalScore;
	private JLabel totalMovements;
	private JLabel totalFruits;
	private JLabel maxLevel;
	private JButton menuButton;
	private JButton resetButton;
	private JTextField nameInput;
	
	private String score;
	private String movements;
	private String fruits;
	private String level;
	private String snakeSkin;
	
	private GameController controller;
	
	/**
     * Constructor de GameOver.
     *
     * @param score El puntaje obtenido en el juego.
     * @param movements Los movimientos realizados en el juego.
     * @param fruits Las frutas recogidas en el juego.
     * @param level El nivel alcanzado en el juego.
     * @param snakeSkinName El nombre de la piel de la serpiente utilizada en el juego.
     * @param controller El controlador del juego.
     */
	public GameOver(String score, String movements, String fruits, String level, String snakeSkinName, GameController controller) {
		this.controller = controller;		
		
		this.score = score;
		this.movements = movements;
		this.fruits = fruits;
		this.level = level;
		this.snakeSkin = snakeSkinName;
		
		this.setLayout(new GridLayout(5,1));
		this.setPreferredSize(new Dimension(600, 700));
		this.setBorder(new EmptyBorder(0,0,0,0));
		initializeComponents();
		this.setVisible(true);
	}
	
	/**
     * Inicializa los componentes de la pantalla de fin de juego.
     */
	public void initializeComponents() {
		insertGameOverTitle();
		insertNickNameLabel();
		insertScoringSection();
		insertmenuButton();
	}
	
	/**
     * Inserta el título de Game Over en la pantalla de fin de juego.
     */
	public void insertGameOverTitle() {
		JPanel section = new JPanel();
		section.setLayout(new GridBagLayout());
		section.setBorder(new EmptyBorder(40,0,0,0));
		
		JLabel title = new JLabel("Game Over");
		JLabel subTitle = new JLabel("You Lose");	
		
		Font titleFont = new Font("Arial", Font.BOLD, 65);
		title.setFont(titleFont);
		
		Font subTitleFont = new Font("Arial", Font.BOLD, 25);
		subTitle.setFont(subTitleFont);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(1,1,1,1);
		
		gbc.gridheight = 1;
		section.add(title, gbc);
		
		gbc.gridheight = 1;		
		gbc.gridy = 1;
		section.add(subTitle, gbc);
		
		this.add(section);
	}
	
	/**
     * Inserta la etiqueta de nombre de usuario en la pantalla de fin de juego.
     */
	public void insertNickNameLabel() {
		JPanel section = new JPanel();
		section.setLayout(new GridBagLayout());
		section.setSize(600, 100);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel inputLabel = new JLabel("Insert your nickname");
		inputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		nameInput = new JTextField();
		nameInput.setPreferredSize(new Dimension(240, 40));	
		nameInput.setFont(new Font("Arial", Font.PLAIN, 14));
		nameInput.setBorder(new EmptyBorder(0, 10, 0, 10));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(1,1,1,1);		
		
		section.add(inputLabel, gbc);	
		
		gbc.gridy = 1;
		section.add(nameInput, gbc);
		
		this.add(section);
		nameInput.requestFocus();
	}
	
	/**
     * Inserta la sección de puntuación en la pantalla de fin de juego.
     */
	public void insertScoringSection() {
		JPanel section = new JPanel(new GridLayout(2,1));
		
		JPanel scoreSection = new JPanel();
		scoreSection.setLayout(new GridLayout(1, 4));
		
		JLabel title = new JLabel("Your total score");
		title.setHorizontalAlignment(JLabel.CENTER);
		
		Font font = new Font("Arial", Font.BOLD, 25);
		title.setFont(font);
		
		section.add(title);		
		
		JPanel maxLevel = getmaxLevelSection();
		JPanel totalScore = getScoreSection();
		JPanel totalMovements = getTotalMovementsSection();
		JPanel totalFruits = gettotalFruitsSection();
		
		scoreSection.add(maxLevel);
		scoreSection.add(totalScore);
		scoreSection.add(totalMovements);
		scoreSection.add(totalFruits);
		
		section.add(scoreSection);
		
		this.add(section);
	}
	
	/**
     * Inserta el botón del menú en la pantalla de fin de juego.
     */
	public void insertmenuButton() {			
		resetButton = new JButton("Try Again");
		resetButton.setActionCommand("tryAgain");
		resetButton.addActionListener(this);
		resetButton.setPreferredSize(new Dimension(224, 40));
		resetButton.setFont(new Font("Arial", Font.BOLD, 22));
		
		menuButton = new JButton("Main Menu");
		menuButton.setActionCommand("backMenu");
		menuButton.addActionListener(this);
		menuButton.setPreferredSize(new Dimension(224, 40));
		menuButton.setFont(new Font("Arial", Font.BOLD, 22));
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setPreferredSize(new Dimension(buttonPanel.getPreferredSize().width, 120));
		buttonPanel.setBorder(new EmptyBorder(20,0,0,0));
		
		buttonPanel.add(resetButton);
		buttonPanel.add(menuButton);
		this.add(buttonPanel);
	}
	
	/**
     * Obtiene la sección del nivel máximo en la pantalla de fin de juego.
     *
     * @return La sección del nivel máximo en la pantalla de fin de juego.
     */
	public JPanel getmaxLevelSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));

	    JLabel title = createLabel("Max level:");
		title.setFont(new Font("Arial", Font.BOLD, 16));
	    
	    maxLevel = createLabel(level);
	    maxLevel.setFont(new Font("Arial", Font.BOLD, 22));

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);

	    gbc.gridy = 1;
	    section.add(maxLevel, gbc);

	    return section;
	}
	
	/**
     * Obtiene la sección de puntuación en la pantalla de fin de juego.
     *
     * @return La sección de puntuación en la pantalla de fin de juego.
     */
	public JPanel getScoreSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));
		
		JLabel title = createLabel("Total score:");
		title.setFont(new Font("Arial", Font.BOLD, 16));
		totalScore = createLabel(score);
		totalScore.setFont(new Font("Arial", Font.BOLD, 22));
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);

	    gbc.gridy = 1;
	    section.add(totalScore, gbc);
		
		return section;
	}
	
	/**
     * Obtiene la sección de movimientos totales en la pantalla de fin de juego.
     *
     * @return La sección de movimientos totales en la pantalla de fin de juego.
     */
	public JPanel getTotalMovementsSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));
		
		JLabel title = createLabel("Total Movements:");
		title.setFont(new Font("Arial", Font.BOLD, 16));
		totalMovements = createLabel(movements);
		totalMovements.setFont(new Font("Arial", Font.BOLD, 22));
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);
	    
	    gbc.gridy = 1;
	    section.add(totalMovements, gbc);
		
		return section;
	}
	
	/**
     * Obtiene la sección de frutas totales en la pantalla de fin de juego.
     *
     * @return La sección de frutas totales en la pantalla de fin de juego.
     */
	public JPanel gettotalFruitsSection() {
		JPanel section = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    section.setBorder(new EmptyBorder(0,0,0,0));
		
		JLabel title = createLabel("Total fruits:");
		title.setFont(new Font("Arial", Font.BOLD, 16));
		totalFruits = createLabel(fruits);
		totalFruits.setFont(new Font("Arial", Font.BOLD, 22));
		
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    section.add(title, gbc);
	    
	    gbc.gridy = 1;
		section.add(totalFruits, gbc);
		
		return section;
	}
	
	/**
     * Maneja las acciones realizadas en la pantalla de fin de juego.
     *
     * @param e El evento de acción.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if (command.equals("tryAgain") || command.equals("backMenu")) {
			
			String nickName = this.nameInput.getText();
			
			if(nickName.equals("")) {
				nickName = "No name";
			}
			
			controller.getGameRecord(score, movements, fruits, level, snakeSkin, nickName);
			
		}
	}
	
	/**
     * Crea una nueva etiqueta con el texto especificado.
     *
     * @param text El texto para la etiqueta.
     * @return Una nueva etiqueta con el texto especificado.
     */
	public JLabel createLabel(String text) {
		JLabel newText = new JLabel(text);
		return newText;
	}

	/**
     * Obtiene el botón del menú en la pantalla de fin de juego.
     *
     * @return El botón del menú en la pantalla de fin de juego.
     */
	public JButton getmenuButton() {
		return menuButton;
	}
	
	/**
     * Obtiene el botón de reinicio en la pantalla de fin de juego.
     *
     * @return El botón de reinicio en la pantalla de fin de juego.
     */
	public JButton getResetButton() {
		return resetButton;
	}
}
