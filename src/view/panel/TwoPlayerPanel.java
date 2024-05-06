package view.panel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import view.dialog.MatchResultTwoPlayerDialog;
import view.dialog.TwoPlayerRulesDialog;
import view.frame.GameScreen;

public class TwoPlayerPanel extends JPanel {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;

    private GameScreen gameScreen;

    private JLayeredPane jLayeredPane;
    private JPanel opacityPanel;
    private ModeTwoPlayer modeTwoPlayer;
    private TwoPlayerRulesDialog twoPlayerRulesDialog;
    private MatchResultTwoPlayerDialog matchResultTwoPlayerDialog;

    public TwoPlayerPanel(GameScreen gameScreen) {
        setLayout(null);
        this.gameScreen = gameScreen;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponent();
        setOpaque(false);
        setVisible(false);
    }

    public void initComponent() {
        jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0, 0, WIDTH, HEIGHT);

        opacityPanel = new JPanel();
        opacityPanel.setBackground(new Color(0, 0, 0, 128));
        opacityPanel.setBounds(0, 1, 1100, 800);
        opacityPanel.setOpaque(true);
        opacityPanel.setVisible(false);
        
        jLayeredPane.add(opacityPanel, JLayeredPane.PALETTE_LAYER);

        twoPlayerRulesDialog = new TwoPlayerRulesDialog(this);
        twoPlayerRulesDialog.setBounds(213, 150, TwoPlayerRulesDialog.WIDTH, TwoPlayerRulesDialog.HEIGHT);
        twoPlayerRulesDialog.setVisible(true);
        jLayeredPane.add(twoPlayerRulesDialog, JLayeredPane.MODAL_LAYER);

        matchResultTwoPlayerDialog = new MatchResultTwoPlayerDialog(this);
        matchResultTwoPlayerDialog.setBounds(225, 200, MatchResultTwoPlayerDialog.WIDTH,
                MatchResultTwoPlayerDialog.HEIGHT);
        jLayeredPane.add(matchResultTwoPlayerDialog, JLayeredPane.MODAL_LAYER);

        add(jLayeredPane);
    }

    public void openModeTwoPlayer() {
        if (modeTwoPlayer == null) {
            modeTwoPlayer = new ModeTwoPlayer(this);
            modeTwoPlayer.setBounds(0, 0, ModeTwoPlayer.WIDTH, ModeTwoPlayer.HEIGHT);
            jLayeredPane.add(modeTwoPlayer, JLayeredPane.DEFAULT_LAYER);
        }
        modeTwoPlayer.open();
    }

    public void closeModeTwoPlayer() {
        jLayeredPane.remove(modeTwoPlayer);
        revalidate();
        repaint();
    }

    public void openTwoPlayerRulesDialog() {
        opacityPanel.setVisible(true);
        twoPlayerRulesDialog.setVisible(true);
    }

    public void closeTwoPlayerRulesDialog() {
        opacityPanel.setVisible(false);
        twoPlayerRulesDialog.setVisible(false);
    }

    public void openResultTwoPlayerDialog() {
        opacityPanel.setVisible(true);
        matchResultTwoPlayerDialog.open();
    }

    public void closeResultTwoPlayerDialog() {
        opacityPanel.setVisible(false);
        matchResultTwoPlayerDialog.close();
    }

    public ModeTwoPlayer getModeTwoPlayer() {
        return modeTwoPlayer;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }
}
