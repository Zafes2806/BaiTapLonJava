package view.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import untils.ImagePaths;
import view.dialog.TwoPlayerDialog;
import view.dialog.TwoPlayerRulesDialog;
import view.frame.GameScreen;

public class TwoPlayerPanel extends JPanel {    // Cửa sổ chế độ chơi 2 người
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;

    private GameScreen gameScreen;

    private TwoPlayerDialog twoPlayerDialog;
    private TwoPlayerRulesDialog twoPlayerRulesDialog;

    public TwoPlayerPanel(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponent();
        setOpaque(false);
        setVisible(false);
    }

    public void initComponent() {
        twoPlayerRulesDialog = new TwoPlayerRulesDialog(this);
        twoPlayerRulesDialog.setBounds(213, 170, TwoPlayerRulesDialog.WIDTH, TwoPlayerRulesDialog.HEIGHT);
        this.add(twoPlayerRulesDialog);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.BACKGROUND_TWO_PLAYER_PANEL).getImage();
        g.drawImage(image, 0, 0, this);
    }

    public void startTwoPlayer() {
        twoPlayerDialog = new TwoPlayerDialog(this);
        twoPlayerDialog.setBounds(0, 0, TwoPlayerDialog.WIDTH, TwoPlayerDialog.HEIGHT);
        this.add(twoPlayerDialog);
        twoPlayerDialog.open();
        twoPlayerDialog.requestFocus();
        twoPlayerDialog.start();
    }

    public void openTwoPlayerRulesDialog() {
        twoPlayerRulesDialog.setVisible(true);
    }

    public void closeTwoPlayerRulesDialog() {
        twoPlayerRulesDialog.setVisible(false);
    }

    public TwoPlayerDialog getTwoPlayerDialog() {
        return twoPlayerDialog;
    }

    public void setTwoPlayerDialog(TwoPlayerDialog twoPlayerDialog) {
        this.twoPlayerDialog = twoPlayerDialog;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void open() {
        openTwoPlayerRulesDialog();
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }
}
