package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.dialog.SettingsDialogController;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.MenuPanel;

public class SettingsDialog extends JPanel {
    public static final int WIDTH = 384;
    public static final int HEIGHT = 241;

    private SettingsDialogController settingsDialogController;

    private MenuPanel menuPanel;
    private JButton btnMucsicOFF;
    private JButton btnMusicON;
    private JButton btnSoundOFF;
    private JButton btnSoundON;
    private JButton btnExit;
    private boolean music;
    private boolean sound;


    public SettingsDialog(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        settingsDialogController = new SettingsDialogController(this);
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    public void initComponents() {
        btnMucsicOFF = Untils.getButton(ImagePaths.MENU_OFF_1, ImagePaths.MENU_OFF_2);
        btnMucsicOFF.setBounds(250, 78, 69, 27);
        btnMucsicOFF.setActionCommand("Music OFF");
        btnMucsicOFF.addActionListener(settingsDialogController);
        add(btnMucsicOFF);

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
        music = false;
        btnMucsicOFF.setVisible(false);
        btnMusicON.setVisible(true);
    }
    public void onMusic() {
        music = true;
        btnMucsicOFF.setVisible(true);
        btnMusicON.setVisible(false);
    }

    public void offSound() {
        sound = false;
        btnSoundOFF.setVisible(false);
        btnSoundON.setVisible(true);
    }
    public void onSound() {
        sound = true;
        btnSoundOFF.setVisible(true);
        btnSoundON.setVisible(false);
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public boolean isMusic() {
        return music;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public void open() {
        setVisible(true);
    }
    public void close() {
        setVisible(false);
    }
}
