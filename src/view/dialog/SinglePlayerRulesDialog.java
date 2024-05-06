package view.dialog;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import untils.Constant;
import untils.ImagePaths;
import untils.Untils;

public class SinglePlayerRulesDialog extends JPanel {
    private final int width = 674;
    private final int height = 485;
    private JButton btnOk;

    public SinglePlayerRulesDialog() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        btnOk = Untils.getButton(ImagePaths.GAME_OK_1, ImagePaths.GAME_OK_2);
        btnOk.setBounds(312, 425, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_HEIGHT);
        add(btnOk);

        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.DIALOG_RULES_SINGLE_PLAYER).getImage();
        g.drawImage(image, 0, 0, width, height - 20, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        JLayeredPane layeredPane = new JLayeredPane(); 
        frame.add(layeredPane);
        SinglePlayerRulesDialog singlePlayerRulesDialog = new SinglePlayerRulesDialog();
        singlePlayerRulesDialog.setBounds(213, 150, singlePlayerRulesDialog.width, singlePlayerRulesDialog.height);
        singlePlayerRulesDialog.setVisible(true);
        layeredPane.add(singlePlayerRulesDialog, JLayeredPane.DEFAULT_LAYER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
