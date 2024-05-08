package view.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import untils.ImagePaths;
import view.dialog.NewGameDialog;
import view.dialog.RankDialogInSinglePlayer;
import view.dialog.SinglePlayerDialog;
import view.dialog.SinglePlayerMatchResultDialog;
import view.dialog.SinglePlayerOptionsDialog;
import view.dialog.SinglePlayerRulesDialog;
import view.frame.GameScreen;

public class SinglePlayerPanel extends JPanel {
    public static int WIDTH = 1100;
    public static int HEIGHT = 800;

    private GameScreen gameScreen;

    private SinglePlayerDialog singlePlayerDialog;
    private SinglePlayerOptionsDialog singlePlayerOptionsDialog;
    private NewGameDialog newGameDialog;
    private SinglePlayerRulesDialog singlePlayerRulesDialog;
    private SinglePlayerMatchResultDialog singlePlayerMatchResultDialog;
    private RankDialogInSinglePlayer rankDialog;

    public SinglePlayerPanel(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponents();
        setVisible(false);
        setOpaque(false);
    }

    public void initComponents() {
        singlePlayerOptionsDialog = new SinglePlayerOptionsDialog(this);
        singlePlayerOptionsDialog.setBounds(442, 300, SinglePlayerOptionsDialog.WIDTH,
                SinglePlayerOptionsDialog.HEIGHT);
        add(singlePlayerOptionsDialog);

        newGameDialog = new NewGameDialog(this);
        newGameDialog.setBounds(331, 300, NewGameDialog.WIDTH, NewGameDialog.HEIGHT);
        add(newGameDialog);

        singlePlayerRulesDialog = new SinglePlayerRulesDialog(this);
        singlePlayerRulesDialog.setBounds(213, 200, SinglePlayerRulesDialog.WIDTH, SinglePlayerRulesDialog.HEIGHT);
        add(singlePlayerRulesDialog);

        singlePlayerMatchResultDialog = new SinglePlayerMatchResultDialog(this);
        singlePlayerMatchResultDialog.setBounds(225, 200, SinglePlayerMatchResultDialog.WIDTH,
                SinglePlayerMatchResultDialog.HEIGHT);
        add(singlePlayerMatchResultDialog);
        
        rankDialog = new RankDialogInSinglePlayer(this);
        rankDialog.setBounds(225, 200, RankDialogInSinglePlayer.WIDTH, RankDialogInSinglePlayer.HEIGHT);
        this.add(rankDialog);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.BACKGROUND_SINGLE_PLAYER_PANEL).getImage();
        g.drawImage(image, 0, 0, this);
    }

    public void startSinglePlayer() {
        singlePlayerDialog = new SinglePlayerDialog(this);
        singlePlayerDialog.setBounds(0, 0, SinglePlayerDialog.WIDTH, SinglePlayerDialog.HEIGHT);
        this.add(singlePlayerDialog);
        singlePlayerDialog.open();
        singlePlayerDialog.requestFocus();
        singlePlayerDialog.start();
    }

    public void closeSinglePlayerDialog() {
        singlePlayerDialog.close();
    }

    public void openSinglePlayerOptionsDialog() {
        singlePlayerOptionsDialog.open();
    }

    public void closeSinglePlayerOptionsDialog() {
        singlePlayerOptionsDialog.close();
    }

    public void openNewGameDialog() {
        newGameDialog.open();
    }

    public void closeNewGameDialog() {
        newGameDialog.close();
    }

    public void openSinglePlayerRulesDialog() {
        singlePlayerRulesDialog.open();
    }

    public void closeSinglePlayerRulesDialog() {
        singlePlayerRulesDialog.close();
    }

    public void openSinglePlayerMatchResultDialog() {
        singlePlayerMatchResultDialog.open();
    }

    public void closeSinglePlayerMatchResultDialog() {
        singlePlayerMatchResultDialog.close();
    }

    public void openRankDialog() {
        rankDialog.open();
    }

    public void closeRankDialog() {
        rankDialog.close();
    }

    public void open() {
        singlePlayerOptionsDialog.open();
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public SinglePlayerRulesDialog getSinglePlayerRulesDialog() {
        return singlePlayerRulesDialog;
    }

    public NewGameDialog getNewGameDialog() {
        return newGameDialog;
    }

    public SinglePlayerDialog getSinglePlayerDialog() {
        return singlePlayerDialog;
    }

    public void setSinglePlayerDialog(SinglePlayerDialog singlePlayerDialog) { 
        this.singlePlayerDialog = singlePlayerDialog;
     }

   

    
}
