package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import untils.Constant;
import untils.ImagePaths;

public class SinglePlayerRulesDialog extends JPanel {
    private final int width = 674;
    private final int height = 465;
    private JButton exit;

    public SinglePlayerRulesDialog() {
        setLayout(null);
        Image imageExit1 = new ImageIcon(ImagePaths.GAME_EXIT_1).getImage();
        Image imageExit2 = new ImageIcon(ImagePaths.GAME_EXIT_2).getImage();
        setPreferredSize(new Dimension(width, height));
        exit = new JButton(new ImageIcon(imageExit1));
        exit.setRolloverIcon(new ImageIcon(imageExit2));
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusPainted(false);
        exit.setBounds(620, 7, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        add(exit);
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_RULES_SINGLE_PLAYER).getImage();
        g.drawImage(imageAboutDialog, 0, 0, width, height, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.getContentPane().setLayout(null);
        SinglePlayerRulesDialog singlePlayerRulesDialog = new SinglePlayerRulesDialog();
        singlePlayerRulesDialog.setBounds(213, 150, singlePlayerRulesDialog.width, singlePlayerRulesDialog.height);
        singlePlayerRulesDialog.setVisible(true);
        frame.add(singlePlayerRulesDialog);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
