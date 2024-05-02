package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import untils.Constant;
import untils.ImagePaths;

public class AboutDialog extends JPanel {
    public static final int WIDTH = 627;
    public static final int HEIGHT = 385;
    private JButton exit;

    public AboutDialog() {
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        Image imageExit1 = new ImageIcon(ImagePaths.GAME_EXIT_1).getImage();
        Image imageExit2 = new ImageIcon(ImagePaths.GAME_EXIT_2).getImage();
        exit = new JButton(new ImageIcon(imageExit1));
        exit.setRolloverIcon(new ImageIcon(imageExit2));
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusPainted(false);
        exit.setBounds(570, 15, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
        add(exit);

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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.getContentPane().setLayout(null);
        AboutDialog aboutDialog = new AboutDialog();
        aboutDialog.setBounds(225, 200, AboutDialog.WIDTH, AboutDialog.HEIGHT);
        aboutDialog.setVisible(true);
        frame.add(aboutDialog);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
