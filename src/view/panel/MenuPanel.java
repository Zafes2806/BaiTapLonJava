package view.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import untils.ImagePaths;
import view.dialog.AboutDialog;
import view.dialog.MenuDialog;
import view.dialog.RankDialogInMenu;
import view.dialog.SettingsDialog;
import view.frame.GameScreen;

public class MenuPanel extends JPanel {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;

    private GameScreen gameScreen;

    private MenuDialog menuDialog;
    private SettingsDialog settingsDialog;
    private RankDialogInMenu rankDialogInMenu;
    private AboutDialog aboutDialog;

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

        rankDialogInMenu = new RankDialogInMenu(this);
        rankDialogInMenu.setBounds(225, 200, RankDialogInMenu.WIDTH, RankDialogInMenu.HEIGHT);
        this.add(rankDialogInMenu);

        aboutDialog = new AboutDialog(this);
        aboutDialog.setBounds(225, 200, AboutDialog.WIDTH, AboutDialog.HEIGHT);
        this.add(aboutDialog);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBackGround = new ImageIcon(ImagePaths.BACKGROUND_MENU_PANEL).getImage();
        g.drawImage(imageBackGround, 0, 0, WIDTH, HEIGHT, this);
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
        settingsDialog.open();
    }

    public void closeSettingsDialog() {
        settingsDialog.close();
    }

    public void openRankDialog() {
        rankDialogInMenu.open();
    }

    public void closeRankDialog() {
        rankDialogInMenu.close();
    }

    public void openAboutDialog() {
        aboutDialog.open();
    }

    public void closeAboutDialog() {
        aboutDialog.close();
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
