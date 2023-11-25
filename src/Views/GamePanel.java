package Views;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import Controllers.GameController;
import Utils.Snake;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {
    private GameMenu menu;
    private SkinSelection selectSkin;
    private JPanel game;
    private GameBoard board;
    private ScoreSection scores;
    private GameOver go;
    private GameController controller;


    public GamePanel(GameController controller) {
        this.controller = controller;

        setBorder(new EmptyBorder(0, 0, 0, 0));
        setVisible(true);
        startGame();
    }

    public void startGame() {
        insertMenu();
    }

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

    public void insertSkinSelection() {
        selectSkin = new SkinSelection();

        removeMenu();
        add(selectSkin);
        revalidate();
        repaint();

        JButton skinSectionStartButton = selectSkin.getStartGame();
        skinSectionStartButton.addActionListener(this);
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        validateAction(c);
    }

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

    public void setArcadeMode() {
        this.removeMenu();
        insertSkinSelection();
    }

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

    public void removeMenu() {
        remove(menu);
        revalidate();
        repaint();
    }

    public void removeBoard() {
        remove(game);
        revalidate();
        repaint();
    }

    public void removeSkinSelection() {
        remove(selectSkin);
        revalidate();
        repaint();
    }

    public void removeGameOver() {
        remove(go);
        revalidate();
        repaint();
    }

    public GameMenu getMenu() {
        return menu;
    }

    public GameBoard getBoard() {
        return board;
    }

    public GameOver getGO() {
        return go;
    }

}
