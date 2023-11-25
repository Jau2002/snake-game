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
        setLayout(new GridLayout(1, 4));
        setPreferredSize(new Dimension(600, 60));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        initializeComponents();
        setVisible(true);
    }

    public void initializeComponents() {
        insertCurrentLevelSection();
        insertScoreSection();
        insertTotalMovementsSection();
        insertFruitsEatenSection();
    }

    public void insert(String Action, String num) {
        JPanel section = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        section.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel title = createLabel(Action);
        currentLevel = createLabel(num);

        gbc.gridx = 0;
        gbc.gridy = 0;
        section.add(title, gbc);

        gbc.gridy = 1;
        section.add(currentLevel, gbc);

        add(section);
    }

    public void insertCurrentLevelSection() {
        JPanel section = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        section.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel title = createLabel("Level:");
        currentLevel = createLabel("1");

        gbc.gridx = 0;
        gbc.gridy = 0;
        section.add(title, gbc);

        gbc.gridy = 1;
        section.add(currentLevel, gbc);

        add(section);
    }

    public void insertScoreSection() {
        JPanel section = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        section.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel title = createLabel("Score:");
        totalScore = createLabel("0");

        gbc.gridx = 0;
        gbc.gridy = 0;
        section.add(title, gbc);

        gbc.gridy = 1;
        section.add(totalScore, gbc);

        add(section);
    }

    public void insertTotalMovementsSection() {
        JPanel section = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        section.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel title = createLabel("Movements:");
        totalMovements = createLabel("0");

        gbc.gridx = 0;
        gbc.gridy = 0;
        section.add(title, gbc);

        gbc.gridy = 1;
        section.add(totalMovements, gbc);

        add(section);
    }

    public void insertFruitsEatenSection() {
        JPanel section = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        section.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel title = createLabel("Fruits eaten:");
        fruitsEaten = createLabel("0");

        gbc.gridx = 0;
        gbc.gridy = 0;
        section.add(title, gbc);

        gbc.gridy = 1;
        section.add(fruitsEaten, gbc);

        add(section);
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
