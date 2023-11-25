package Views;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class GameMenu extends JPanel {
    private JButton arcadeModeButton;
    private JButton personalizedModeButton;
    private JButton leadBoardButton;

    public GameMenu() {
        setLayout(new GridLayout(3, 1));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        initializeComponents();
        setVisible(true);
    }

    public void initializeComponents() {
        insertTitle();
        insertArcadeModeButton();
        insertLeadBoardButton();
    }

    public void insertTitle() {
        JLabel mainTitle = new JLabel("Snake Game");
        mainTitle.setFont(new Font("Arial", Font.BOLD, 45));
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setVerticalAlignment(JLabel.CENTER);
        add(mainTitle);
    }

    public void insertArcadeModeButton() {
        arcadeModeButton = new JButton("Start Game");
        arcadeModeButton.setPreferredSize(new Dimension(150, 40));
        arcadeModeButton.setFont(new Font("Arial", Font.BOLD, 25));
        arcadeModeButton.setActionCommand("arcadeMode");
        add(arcadeModeButton);
    }

    public void insertLeadBoardButton() {
        leadBoardButton = new JButton("Game records");
        leadBoardButton.setPreferredSize(new Dimension(150, 40));
        leadBoardButton.setFont(new Font("Arial", Font.BOLD, 25));
        leadBoardButton.setActionCommand("gameRecords");
        add(leadBoardButton);
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
