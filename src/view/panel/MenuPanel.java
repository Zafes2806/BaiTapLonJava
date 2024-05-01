package view.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import untils.Constant;
import untils.ImagePaths;

public class MenuPanel extends JPanel {
    private JButton buttonMenuSinglePlayer;
    private JButton buttonMenuTwoPlayer;
    private JButton buttonMenuSettings;
    private JButton buttonMenuRank;
    private JButton buttonMenuAbout;
    private JButton buttonMenuExit;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MenuPanel menuPanel = new MenuPanel();
        frame.setSize(menuPanel.getPreferredSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(menuPanel);
        frame.setVisible(true);
    }

    public MenuPanel() {
        this.setPreferredSize(new Dimension(1100, 800));
        this.setLayout(null);
        Image imageMenu1Player1 = new ImageIcon(ImagePaths.MENU_SINGLE_PLAYER_1).getImage();
        Image imageMenu1Player2 = new ImageIcon(ImagePaths.MENU_SINGER_PLAYER_2).getImage();
        Image imageMenu2Player1 = new ImageIcon(ImagePaths.MENU_TWO_PLAYER_1).getImage();
        Image imageMenu2Player2 = new ImageIcon(ImagePaths.MENU_TWO_PLAYER_2).getImage();
        Image imageMenuSettings1 = new ImageIcon(ImagePaths.MENU_SETTINGS_1).getImage();
        Image imageMenuSettings2 = new ImageIcon(ImagePaths.MENU_SETTINGS_2).getImage();
        Image imageMenuRank1 = new ImageIcon(ImagePaths.MENU_RANK_1).getImage();
        Image imageMenuRank2 = new ImageIcon(ImagePaths.MENU_RANK_2).getImage();
        Image imageMenuAbout1 = new ImageIcon(ImagePaths.MENU_ABOUT_1).getImage();
        Image imageMenuAbout2 = new ImageIcon(ImagePaths.MENU_ABOUT_2).getImage();
        Image imageMenuExit1 = new ImageIcon(ImagePaths.MENU_EXIT_1).getImage();
        Image imageMenuExit2 = new ImageIcon(ImagePaths.MENU_EXIT_2).getImage();

        buttonMenuSinglePlayer = new JButton(new ImageIcon(imageMenu1Player1));
        buttonMenuSinglePlayer.setRolloverIcon(new ImageIcon(imageMenu1Player2));
        buttonMenuSinglePlayer.setBorderPainted(false);
        buttonMenuSinglePlayer.setContentAreaFilled(false);
        buttonMenuSinglePlayer.setFocusPainted(false);
        buttonMenuSinglePlayer.setBounds(442, 218, Constant.MENU_BUTTON_WIDTH, Constant.MENU_BUTTON_HEIGHT);
        this.add(buttonMenuSinglePlayer);

        buttonMenuTwoPlayer = new JButton(new ImageIcon(imageMenu2Player1));
        buttonMenuTwoPlayer.setRolloverIcon(new ImageIcon(imageMenu2Player2));
        buttonMenuTwoPlayer.setBorderPainted(false);
        buttonMenuTwoPlayer.setContentAreaFilled(false);
        buttonMenuTwoPlayer.setFocusPainted(false);
        buttonMenuTwoPlayer.setBounds(442, 303, 217, 66);
        this.add(buttonMenuTwoPlayer);

        buttonMenuSettings = new JButton(new ImageIcon(imageMenuSettings1));
        buttonMenuSettings.setRolloverIcon(new ImageIcon(imageMenuSettings2));
        buttonMenuSettings.setBorderPainted(false);
        buttonMenuSettings.setContentAreaFilled(false);
        buttonMenuSettings.setFocusPainted(false);
        buttonMenuSettings.setBounds(442, 388, 217, 66);
        this.add(buttonMenuSettings);

        buttonMenuRank = new JButton(new ImageIcon(imageMenuRank1));
        buttonMenuRank.setRolloverIcon(new ImageIcon(imageMenuRank2));
        buttonMenuRank.setBorderPainted(false);
        buttonMenuRank.setContentAreaFilled(false);
        buttonMenuRank.setFocusPainted(false);
        buttonMenuRank.setBounds(442, 473, 217, 66);
        this.add(buttonMenuRank);

        buttonMenuAbout = new JButton(new ImageIcon(imageMenuAbout1));
        buttonMenuAbout.setRolloverIcon(new ImageIcon(imageMenuAbout2));
        buttonMenuAbout.setBorderPainted(false);
        buttonMenuAbout.setContentAreaFilled(false);
        buttonMenuAbout.setFocusPainted(false);
        buttonMenuAbout.setBounds(442, 558, 217, 66);
        this.add(buttonMenuAbout);

        buttonMenuExit = new JButton(new ImageIcon(imageMenuExit1));
        buttonMenuExit.setRolloverIcon(new ImageIcon(imageMenuExit2));
        buttonMenuExit.setBorderPainted(false);
        buttonMenuExit.setContentAreaFilled(false);
        buttonMenuExit.setFocusPainted(false);
        buttonMenuExit.setBounds(442, 643, 217, 66);
        this.add(buttonMenuExit);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBackGround = new ImageIcon(ImagePaths.BACKGROUND_MENU_PANEL).getImage();
        g.drawImage(imageBackGround, 0, 0, getWidth(), getHeight(), this);
    }

    public JButton getButtonMenuSinglePlayer() {
        return buttonMenuSinglePlayer;
    }

    public void setButtonMenuSinglePlayer(JButton buttonMenu1Player) {
        this.buttonMenuSinglePlayer = buttonMenu1Player;
    }

    public JButton getButtonMenuTwoPlayer() {
        return buttonMenuTwoPlayer;
    }

    public void setButtonMenuTwoPlayer(JButton buttonMenu2Player) {
        this.buttonMenuTwoPlayer = buttonMenu2Player;
    }

    public JButton getButtonMenuSettings() {
        return buttonMenuSettings;
    }

    public void setButtonMenuSettings(JButton buttonMenuSettings) {
        this.buttonMenuSettings = buttonMenuSettings;
    }

    public JButton getButtonMenuRank() {
        return buttonMenuRank;
    }

    public void setButtonMenuRank(JButton buttonMenuRank) {
        this.buttonMenuRank = buttonMenuRank;
    }

    public JButton getButtonMenuAbout() {
        return buttonMenuAbout;
    }

    public void setButtonMenuAbout(JButton buttonMenuAbout) {
        this.buttonMenuAbout = buttonMenuAbout;
    }

    public JButton getButtonMenuExit() {
        return buttonMenuExit;
    }

    public void setButtonMenuExit(JButton buttonMenuExit) {
        this.buttonMenuExit = buttonMenuExit;
    }
}
