package view.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import untils.ImagePaths;
import view.dialog.AboutDialog;
import view.dialog.MenuDialog;

public class MenuPanel extends JPanel {
    private AboutDialog aboutDialog;
    private MenuDialog menuDialog;

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
        initComponents();
    }

    private void initComponents() {
        aboutDialog = new AboutDialog();
        this.add(aboutDialog);

        menuDialog = new MenuDialog();
        menuDialog.setBounds(442, 218, 217, 491);
        this.add(menuDialog);
        menuDialog.open();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBackGround = new ImageIcon(ImagePaths.BACKGROUND_MENU_PANEL).getImage();
        g.drawImage(imageBackGround, 0, 0, getWidth(), getHeight(), this);
    }

    public void openMenuDialog() {

    }

    public void openAboutDialog() {
        aboutDialog.setBounds(225, 200, AboutDialog.WIDTH, AboutDialog.HEIGHT);
        aboutDialog.open();
    }

}
