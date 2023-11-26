package Views;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * La clase ScoreSection representa la sección de puntuación en el juego.
 */
@SuppressWarnings("serial")
public class ScoreSection extends JPanel {
    private JLabel totalScore;
    private JLabel totalMovements;
    private JLabel fruitsEaten;
    private JLabel currentLevel;

    /**
     * Constructor de ScoreSection.
     * Inicializa la sección de puntuación del juego.
     */
    public ScoreSection() {
        setLayout(new GridLayout(1, 4));
        setPreferredSize(new Dimension(600, 60));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        initializeComponents();
        setVisible(true);
    }

    /**
     * Inicializa los componentes de la sección de puntuación.
     */
    public void initializeComponents() {
        insertCurrentLevelSection();
        insertScoreSection();
        insertTotalMovementsSection();
        insertFruitsEatenSection();
    }  
    
    
    /**
     * Inserta la sección del nivel actual en la sección de puntuación.
     */
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

    
    /**
     * Inserta la sección de puntuación en la sección de puntuación.
     */
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

    
    /**
     * Inserta la sección de movimientos totales en la sección de puntuación.
     */
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

    /**
     * Inserta la sección de frutas comidas en la sección de puntuación.
     */
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


    /**
     * Crea una etiqueta con el texto especificado.
     *
     * @param text El texto para la etiqueta.
     * @return Una nueva etiqueta con el texto especificado.
     */
    public JLabel createLabel(String text) {
        JLabel newText = new JLabel(text);
        return newText;
    }

    /**
     * Obtiene la puntuación total en la sección de puntuación.
     *
     * @return La puntuación total en la sección de puntuación.
     */
    public JLabel getTotalScore() {
        return totalScore;
    }

    /**
     * Establece la puntuación total en la sección de puntuación.
     *
     * @param totalScore La nueva puntuación total en la sección de puntuación.
     */
    public void setTotalScore(JLabel totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * Obtiene los movimientos totales en la sección de puntuación.
     *
     * @return Los movimientos totales en la sección de puntuación.
     */
    public JLabel getTotalMovements() {
        return totalMovements;
    }

    /**
     * Establece los movimientos totales en la sección de puntuación.
     *
     * @param totalMovements Los nuevos movimientos totales en la sección de puntuación.
     */
    public void setTotalMovements(JLabel totalMovements) {
        this.totalMovements = totalMovements;
    }

    /**
     * Obtiene las frutas comidas en la sección de puntuación.
     *
     * @return Las frutas comidas en la sección de puntuación.
     */
    public JLabel getFruitsEaten() {
        return fruitsEaten;
    }

    /**
     * Establece las frutas comidas en la sección de puntuación.
     *
     * @param fruitsEaten Las nuevas frutas comidas en la sección de puntuación.
     */
    public void setFruitsEaten(JLabel fruitsEaten) {
        this.fruitsEaten = fruitsEaten;
    }

    /**
     * Obtiene el nivel actual en la sección de puntuación.
     *
     * @return El nivel actual en la sección de puntuación.
     */
    public JLabel getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Establece el nivel actual en la sección de puntuación.
     *
     * @param currentLevel El nuevo nivel actual en la sección de puntuación.
     */
    public void setCurrentLevel(JLabel currentLevel) {
        this.currentLevel = currentLevel;
    }
}
