package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AboutDialogController;
import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.MenuPanel;

public class AboutDialog extends JPanel {
    public static final int WIDTH = 627;
    public static final int HEIGHT = 385;

    private AboutDialogController aboutDialogController;
    
    private MenuPanel menuPanel;
    private JButton btnExit;

    public AboutDialog(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        aboutDialogController = new AboutDialogController(this);

        btnExit = Untils.getButton(ImagePaths.GAME_EXIT_1, ImagePaths.GAME_EXIT_2);
        btnExit.setBounds(570, 15, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        btnExit.setActionCommand("Exit");
        btnExit.addActionListener(aboutDialogController);
        add(btnExit);
        setOpaque(false);
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_ABOUT).getImage();
        g.drawImage(imageAboutDialog, 0, 0, WIDTH, HEIGHT, this);
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
