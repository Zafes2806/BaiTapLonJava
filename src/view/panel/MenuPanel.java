package view.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import untils.ImagePaths;
import view.dialog.AboutDialog;
import view.dialog.MenuDialog;
import view.dialog.RankDialog;
import view.dialog.SettingsDialog;
import view.frame.GameScreen;

public class MenuPanel extends JPanel {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;

    private GameScreen gameScreen;

    private MenuDialog menuDialog;
    private SettingsDialog settingsDialog;
    private RankDialog rankDialog;
    private AboutDialog aboutDialog;
    private SinglePlayerOptionsPanel singlePlayerOptionsPanel;

    public MenuPanel(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);
        initComponents();
        setVisible(false);
    }

    private void initComponents() {
        menuDialog = new MenuDialog(this);
        menuDialog.setBounds(442, 218, MenuDialog.WIDTH, MenuDialog.HEIGHT);
        this.add(menuDialog); 
        menuDialog.open();

        settingsDialog = new SettingsDialog(this);
        settingsDialog.setBounds(358, 250, SettingsDialog.WIDTH, SettingsDialog.HEIGHT);
        this.add(settingsDialog);

        rankDialog = new RankDialog(this);
        rankDialog.setBounds(225, 200, RankDialog.WIDTH, RankDialog.HEIGHT);
        this.add(rankDialog);

        aboutDialog = new AboutDialog(this);
        aboutDialog.setBounds(225, 200, AboutDialog.WIDTH, AboutDialog.HEIGHT);
        this.add(aboutDialog);

        singlePlayerOptionsPanel = new SinglePlayerOptionsPanel(this);
        singlePlayerOptionsPanel.setBounds(0, 0, SinglePlayerOptionsPanel.WIDTH, SinglePlayerOptionsPanel.HEIGHT);
        this.add(singlePlayerOptionsPanel);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBackGround = new ImageIcon(ImagePaths.BACKGROUND_MENU_PANEL).getImage();
        g.drawImage(imageBackGround, 0, 0, getWidth(), getHeight(), this);
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void openMenuDialog() {
        menuDialog.open();
    }

    public void closeMenuDialog() {
        menuDialog.close();
    }

    
    public void openSettingsDialog() {
        menuDialog.close();
        settingsDialog.open();
    }

    public void closeSettingsDialog() {
        settingsDialog.close();
        menuDialog.open();
    }

    public void openRankDialog() {
        menuDialog.close();
        rankDialog.open();
    }

    public void closeRankDialog() {
        rankDialog.close();
        menuDialog.open();
    }

    
    public void openAboutDialog() {
        menuDialog.close();
        aboutDialog.open();
    }

    public void closeAboutDialog() {
        aboutDialog.close();
        menuDialog.open();
    }
    public void openSinglePlayerOptionsPanel() {
        menuDialog.close();
        singlePlayerOptionsPanel.open();
    }
    public void closeSinglePlayerOptionsPanel() {
        singlePlayerOptionsPanel.close();
        menuDialog.open();
    }

    public void exit() {
        System.exit(1);
    }

    public void open() {
        setVisible(true);
    }
    public void close() {
        setVisible(false);
    }
}
