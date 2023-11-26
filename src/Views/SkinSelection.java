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

/**
 * La clase SkinSelection representa la selección de skin de la serpiente en el juego.
 */
@SuppressWarnings("serial")
public class SkinSelection extends JPanel implements ActionListener {
    private snakeSkinDrawPanel snakeSection;
    private JPanel snakeSelector;
    private Color headColor;
    private Color bodyColor;
    private String skinSelected;
    private JButton startGame;

    /**
     * Constructor de SkinSelection.
     * Inicializa la selección de piel skin de la serpiente en el juego.
     */
    public SkinSelection() {
        setLayout(new GridLayout(4, 1));
        setPreferredSize(new Dimension(600, 600));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        initializeComponents();
        setVisible(true);
    }

    /**
     * Inicializa los componentes de la selección de skin.
     */
    public void initializeComponents() {
        insertTitle();
        insertSnakeSection();
        insertSkinSelector();
        insertSetGameButton();
    }

    /**
     * Inserta el título en la selección de skin.
     */
    public void insertTitle() {
        JLabel mainTitle = new JLabel("Select skin");
        mainTitle.setFont(new Font("Arial", Font.BOLD, 45));
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        add(mainTitle);
    }

    /**
     * Inserta el sección de selección de skin.
     */
    public void insertSnakeSection() {
        snakeSection = new snakeSkinDrawPanel();
        add(snakeSection);
        repaint();
    }

    /**
     * Inserta el selector de radio buttons de skin en la selección de skin.
     */
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
        add(snakeSelector);
    }

    /**
     * Inserta el botón de inicio del juego en la selección de skin.
     */
    public void insertSetGameButton() {
        startGame = new JButton("StartGame");
        startGame.setActionCommand("skinStartGame");
        startGame.setPreferredSize(new Dimension(220, 40));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setPreferredSize(new Dimension(buttonPanel.getPreferredSize().width, 120));
        buttonPanel.add(startGame);
        this.add(buttonPanel);
    }

    /**
     * Obtiene un radio button para un color específico.
     *
     * @param color El color para el botón de radio.
     * @return Un radio button para el color especificado.
     */
    public JRadioButton getRadioButton(String color) {
        JRadioButton button = new JRadioButton(color);
        button.setActionCommand(color);
        return button;
    }

    /**
     * Maneja las acciones realizadas en la selección de skin.
     *
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String skin = e.getActionCommand();
        setSkin(skin);
    }

    /**
     * Establece la skin en la selección de skin.
     *
     * @param skin La skin a establecer.
     */
    public void setSkin(String skin) {
        skinSelected = skin;

        if (skin == "Green") {
            headColor = new Color(0, 255, 0);
            bodyColor = new Color(128, 255, 128);
            snakeSection.setSnakeColor(headColor, bodyColor);
        }
        if (skin == "Red") {
            headColor = new Color(255, 0, 0);
            bodyColor = new Color(255, 128, 128);
            snakeSection.setSnakeColor(headColor, bodyColor);
        }
        if (skin == "Blue") {
            headColor = new Color(0, 0, 255);
            bodyColor = new Color(128, 128, 255);
            snakeSection.setSnakeColor(headColor, bodyColor);
        }
        if (skin == "Violet") {
            headColor = new Color(148, 0, 211);
            bodyColor = new Color(186, 85, 211);
            snakeSection.setSnakeColor(headColor, bodyColor);
        }
        if (skin == "Gray") {
            headColor = new Color(128, 128, 128);
            bodyColor = new Color(192, 192, 192);
            snakeSection.setSnakeColor(headColor, bodyColor);
        }
    }

    /**
     * Obtiene la sección de la serpiente en la selección de skin.
     *
     * @return La sección de la serpiente en la selección de skin.
     */
    public snakeSkinDrawPanel getSnakeSection() {
        return snakeSection;
    }

    /**
     * Obtiene el selector de piel en la selección de skin.
     *
     * @return El selector de piel en la selección de skin.
     */
    public JPanel getSnakeSelector() {
        return snakeSelector;
    }

    /**
     * Obtiene el color de la cabeza de la serpiente en la selección de skin.
     *
     * @return El color de la cabeza de la serpiente en la selección de skin.
     */
    public Color getHeadColor() {
        return headColor;
    }

    /**
     * Obtiene el color del cuerpo de la serpiente en la selección de skin.
     *
     * @return El color del cuerpo de la serpiente en la selección de skin.
     */
    public Color getBodyColor() {
        return bodyColor;
    }

    /**
     * Obtiene el botón de inicio del juego en la selección de skin.
     *
     * @return El botón de inicio del juego en la selección de skin.
     */
    public JButton getStartGame() {
        return startGame;
    }

    /**
     * Obtiene el nombre de la piel seleccionada en la selección de skin.
     *
     * @return El nombre de la piel seleccionada en la selección de skin.
     */
    public String getSkinName() {
        return skinSelected;
    }

}
