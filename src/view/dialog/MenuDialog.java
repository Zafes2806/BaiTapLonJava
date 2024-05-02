package view.dialog;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import untils.ImagePaths;
import view.panel.MenuPanel;

public class MenuDialog extends JPanel {
    private final int width = 217;
    private final int height = 491;

    private JButton buttonMenuSinglePlayer;
    private JButton buttonMenuTwoPlayer;
    private JButton buttonMenuSettings;
    private JButton buttonMenuRank;
    private JButton buttonMenuAbout;
    private JButton buttonMenuExit;

    public MenuDialog() {
        setLayout(new GridLayout(6, 1, 19, 0));
        setPreferredSize(new Dimension(width, height));
        setOpaque(false);
        initComponents();
        this.setVisible(false);
    }

    private void initComponents() {
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
        this.add(buttonMenuSinglePlayer);

        buttonMenuTwoPlayer = new JButton(new ImageIcon(imageMenu2Player1));
        buttonMenuTwoPlayer.setRolloverIcon(new ImageIcon(imageMenu2Player2));
        buttonMenuTwoPlayer.setBorderPainted(false);
        buttonMenuTwoPlayer.setContentAreaFilled(false);
        buttonMenuTwoPlayer.setFocusPainted(false);
        this.add(buttonMenuTwoPlayer);

        buttonMenuSettings = new JButton(new ImageIcon(imageMenuSettings1));
        buttonMenuSettings.setRolloverIcon(new ImageIcon(imageMenuSettings2));
        buttonMenuSettings.setBorderPainted(false);
        buttonMenuSettings.setContentAreaFilled(false);
        buttonMenuSettings.setFocusPainted(false);
        this.add(buttonMenuSettings);

        buttonMenuRank = new JButton(new ImageIcon(imageMenuRank1));
        buttonMenuRank.setRolloverIcon(new ImageIcon(imageMenuRank2));
        buttonMenuRank.setBorderPainted(false);
        buttonMenuRank.setContentAreaFilled(false);
        buttonMenuRank.setFocusPainted(false);
        this.add(buttonMenuRank);

        buttonMenuAbout = new JButton(new ImageIcon(imageMenuAbout1));
        buttonMenuAbout.setRolloverIcon(new ImageIcon(imageMenuAbout2));
        buttonMenuAbout.setBorderPainted(false);
        buttonMenuAbout.setContentAreaFilled(false);
        buttonMenuAbout.setFocusPainted(false);

        buttonMenuAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent().getParent();
                MenuPanel menuPanel = (MenuPanel) panel;
                menuPanel.openAboutDialog();
                setEnabled(false);
            }

        });
        this.add(buttonMenuAbout);

        buttonMenuExit = new JButton(new ImageIcon(imageMenuExit1));
        buttonMenuExit.setRolloverIcon(new ImageIcon(imageMenuExit2));
        buttonMenuExit.setBorderPainted(false);
        buttonMenuExit.setContentAreaFilled(false);
        buttonMenuExit.setFocusPainted(false);
        buttonMenuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        this.add(buttonMenuExit);
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }
}
