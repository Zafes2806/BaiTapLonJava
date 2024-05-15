package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.SettingsDialogController;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.MenuPanel;

public class SettingsDialog extends JPanel {
    public static final int WIDTH = 384;
    public static final int HEIGHT = 241;

    private SettingsDialogController settingsDialogController;

    private MenuPanel menuPanel;
    private JButton btnMusicOFF;
    private JButton btnMusicON;
    private JButton btnSoundOFF;
    private JButton btnSoundON;
    private JButton btnExit;

    public SettingsDialog(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        settingsDialogController = new SettingsDialogController(this);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    private void initComponents() {
        btnMusicOFF = Untils.getButton(ImagePaths.MENU_OFF_1, ImagePaths.MENU_OFF_2);
        btnMusicOFF.setBounds(250, 78, 69, 27);
        btnMusicOFF.setActionCommand("Music OFF");
        btnMusicOFF.addActionListener(settingsDialogController);
        add(btnMusicOFF);

        btnMusicON = Untils.getButton(ImagePaths.MENU_ON_1, ImagePaths.MENU_ON_2);
        btnMusicON.setBounds(250, 78, 69, 27);
        btnMusicON.setActionCommand("Music ON");
        btnMusicON.setVisible(false);
        btnMusicON.addActionListener(settingsDialogController);
        add(btnMusicON);

        btnSoundOFF = Untils.getButton(ImagePaths.MENU_OFF_1, ImagePaths.MENU_OFF_2);
        btnSoundOFF.setBounds(250, 137, 69, 27);
        btnSoundOFF.setActionCommand("Sound OFF");
        btnSoundOFF.addActionListener(settingsDialogController);
        add(btnSoundOFF);

        btnSoundON = Untils.getButton(ImagePaths.MENU_ON_1, ImagePaths.MENU_ON_2);
        btnSoundON.setBounds(250, 137, 69, 27);
        btnSoundON.setActionCommand("Sound ON");
        btnSoundON.setVisible(false);
        btnSoundON.addActionListener(settingsDialogController);
        add(btnSoundON);

        btnExit = Untils.getButton(ImagePaths.GAME_EXIT_1, ImagePaths.GAME_EXIT_2);
        btnExit.setBounds(334, 10, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(settingsDialogController);
        add(btnExit);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.DIALOG_SETTINGS).getImage();
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), this);
    }

    public void offMusic() {
        btnMusicOFF.setVisible(false);
        btnMusicON.setVisible(true);
    }
    public void onMusic() {
        btnMusicOFF.setVisible(true);
        btnMusicON.setVisible(false);
    }

    public void offSound() {
        btnSoundOFF.setVisible(false);
        btnSoundON.setVisible(true);
    }
    public void onSound() {
        btnSoundOFF.setVisible(true);
        btnSoundON.setVisible(false);
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public void open() {
        if (getMenuPanel().getGameScreen().isMusic()) {
            btnMusicOFF.setVisible(true);
            btnMusicON.setVisible(false);
        } else {
            btnMusicON.setVisible(true);
            btnMusicOFF.setVisible(false);
        }
        if (getMenuPanel().getGameScreen().isSound()) {
            btnSoundOFF.setVisible(true);
            btnSoundON.setVisible(false);
        } else {
            btnSoundON.setVisible(true);
            btnSoundOFF.setVisible(false);
        }
        setVisible(true);
    }
    public void close() {
        setVisible(false);
    }
}
