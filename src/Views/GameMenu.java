package Views;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * La clase GameMenu representa el menú del juego.
 */
@SuppressWarnings("serial")
public class GameMenu extends JPanel {
    private JButton arcadeModeButton;
    private JButton personalizedModeButton;
    private JButton leadBoardButton;

    /**
     * Constructor de GameMenu.
     * Inicializa el menú del juego.
     */
    public GameMenu() {
        setLayout(new GridLayout(3, 1));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        initializeComponents();
        setVisible(true);
    }

    /**
     * Inicializa los componentes del menú del juego.
     */
    public void initializeComponents() {
        insertTitle();
        insertArcadeModeButton();
        insertLeadBoardButton();
    }
    
    /**
     * Inserta el título en el menú del juego.
     */
    public void insertTitle() {
        JLabel mainTitle = new JLabel("Snake Game");
        mainTitle.setFont(new Font("Arial", Font.BOLD, 45));
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        add(mainTitle);
    }
    
    /**
     * Inserta el botón de modo arcade en el menú del juego.
     */
    public void insertArcadeModeButton() {
        arcadeModeButton = new JButton("Start Game");
        arcadeModeButton.setPreferredSize(new Dimension(150, 40));
        arcadeModeButton.setFont(new Font("Arial", Font.BOLD, 25));
        arcadeModeButton.setActionCommand("arcadeMode");
        add(arcadeModeButton);
    }

    /**
     * Inserta el botón de tabla de líderes en el menú del juego.
     */
    public void insertLeadBoardButton() {
        leadBoardButton = new JButton("Game records");
        leadBoardButton.setPreferredSize(new Dimension(150, 40));
        leadBoardButton.setFont(new Font("Arial", Font.BOLD, 25));
        leadBoardButton.setActionCommand("gameRecords");
        add(leadBoardButton);
    }

    /**
     * Obtiene el botón de modo arcade del menú del juego.
     *
     * @return El botón de modo arcade del menú del juego.
     */
    public JButton getArcadeModeButton() {
        return arcadeModeButton;
    }

    /**
     * Obtiene el botón de modo personalizado del menú del juego.
     *
     * @return El botón de modo personalizado del menú del juego.
     */
    public JButton getPersonalizedModeButton() {
        return personalizedModeButton;
    }

    /**
     * Obtiene el botón de tabla de líderes del menú del juego.
     *
     * @return El botón de tabla de líderes del menú del juego.
     */
    public JButton getLeadBoardButton() {
        return leadBoardButton;
    }
}
