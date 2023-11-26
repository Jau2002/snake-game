package Views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import Controllers.GameController;
import Utils.Snake;

/**
 * La clase GamePanel representa el panel del juego.
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
    private GameMenu menu;
    private SkinSelection selectSkin;
    private JPanel game;
    private GameBoard board;
    private ScoreSection scores;
    private GameOver go;
    private GameController controller;

    /**
     * Constructor de GamePanel.
     *
     * @param controller El controlador del juego.
     */
    public GamePanel(GameController controller) {
        this.controller = controller;

        setBorder(new EmptyBorder(0, 0, 0, 0));
        setVisible(true);
        startGame();
    }

    /**
     * Inicia el juego insertando el menú.
     */
    public void startGame() {
        insertMenu();
    }

    /**
     * Inserta el menú en el panel del juego.
     */
    public void insertMenu() {
        menu = new GameMenu();
        add(menu);
        revalidate();
        repaint();
        menu.setPreferredSize(new Dimension(600, 660));

        JButton arcadeModeButton = menu.getArcadeModeButton();
        JButton leadBoardButton = menu.getLeadBoardButton();

        arcadeModeButton.addActionListener(this);
        leadBoardButton.addActionListener(this);
    }

    /**
     * Inserta la selección de piel en el panel del juego.
     */
    public void insertSkinSelection() {
        selectSkin = new SkinSelection();

        removeMenu();
        add(selectSkin);
        revalidate();
        repaint();

        JButton skinSectionStartButton = selectSkin.getStartGame();
        skinSectionStartButton.addActionListener(this);
    }

    /**
     * Inserta la pantalla de fin de juego en el panel del juego.
     *
     * @param score El puntaje obtenido en el juego.
     * @param movements Los movimientos realizados en el juego.
     * @param fruits Las frutas recogidas en el juego.
     * @param level El nivel alcanzado en el juego.
     * @param snakeSkinName El nombre de la piel de la serpiente utilizada en el juego.
     */
    public void insertGameOver(String score, String movements, String fruits, String level, String snakeSkinName) {
        removeBoard();
        go = new GameOver(score, movements, fruits, level, snakeSkinName, controller);
        add(go);
        revalidate();
        repaint();

        JButton menuButton = go.getmenuButton();
        JButton retryButton = go.getResetButton();

        menuButton.addActionListener(this);
        retryButton.addActionListener(this);
    }

    /**
     * Maneja las acciones realizadas en el panel del juego.
     *
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        validateAction(c);
    }

    /**
     * Valida la acción realizada en el panel del juego.
     *
     * @param c El comando de la acción.
     */
    public void validateAction(String c) {
        if (c.equals("arcadeMode")) {
            setArcadeMode();
        } else if (c.equals("personalizedMode")) {

        } else if (c.equals("gameRecords")) {
            controller.getRecords().readRecords();

        } else if (c.equals("skinStartGame")) {
            String skinName = selectSkin.getSkinName();
            Color snakeHeadColor = selectSkin.getHeadColor();
            Color snakeBodyColor = selectSkin.getBodyColor();

            Snake newSnake = new Snake(4, skinName, snakeHeadColor, snakeBodyColor);
            removeSkinSelection();
            createNewGame(newSnake);
        } else if (c.equals("tryAgain")) {
            removeGameOver();
            setArcadeMode();
        } else if (c.equals("backMenu")) {
            removeGameOver();
            startGame();
        }

    }

    /**
     * Establece el modo arcade en el panel del juego.
     */
    public void setArcadeMode() {
        this.removeMenu();
        insertSkinSelection();
    }

    /**
     * Crea un nuevo juego en el panel del juego.
     *
     * @param snake La serpiente del juego.
     */
    public void createNewGame(Snake snake) {
        game = new JPanel();
        game.setLayout(new BorderLayout());

        scores = new ScoreSection();
        board = new GameBoard(600, 600, snake, scores, this);

        game.add(scores, BorderLayout.NORTH);
        game.add(board, BorderLayout.CENTER);

        add(game);
        revalidate();
        repaint();
        board.requestFocusInWindow();
    }

    /**
     * Elimina el menú del panel del juego.
     */
    public void removeMenu() {
        remove(menu);
        revalidate();
        repaint();
    }

    /**
     * Elimina el tablero del panel del juego.
     */
    public void removeBoard() {
        remove(game);
        revalidate();
        repaint();
    }

    /**
     * Elimina la selección de piel del panel del juego.
     */
    public void removeSkinSelection() {
        remove(selectSkin);
        revalidate();
        repaint();
    }

    /**
     * Elimina la pantalla de fin de juego del panel del juego.
     */
    public void removeGameOver() {
        remove(go);
        revalidate();
        repaint();
    }

    /**
     * Obtiene el menú del panel del juego.
     *
     * @return El menú del panel del juego.
     */
    public GameMenu getMenu() {
        return menu;
    }

    /**
     * Obtiene el tablero del panel del juego.
     *
     * @return El tablero del panel del juego.
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * Obtiene la pantalla de fin de juego del panel del juego.
     *
     * @return La pantalla de fin de juego del panel del juego.
     */
    public GameOver getGO() {
        return go;
    }

}
