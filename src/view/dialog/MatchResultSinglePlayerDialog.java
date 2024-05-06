package view.dialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import untils.Constant;
import untils.ImagePaths;
import untils.Untils;

public class MatchResultSinglePlayerDialog extends JPanel {
    private final int width = 627;
    private final int height = 385;
    private JLabel infoPlayer;
    private JLabel matchReSult;
    private JButton btnHome;
    private JButton btnPlayAgain;
    private JButton btnRank;

    public MatchResultSinglePlayerDialog(String name, int score) {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        Font maintree_20 = Untils.getFont(20);
        infoPlayer = new JLabel("Player's name: " + name, JLabel.CENTER);
        infoPlayer.setFont(maintree_20);
        infoPlayer.setBounds(30, 120, 567, 30);
        add(infoPlayer);

        matchReSult = new JLabel("Player's score: " + score, JLabel.CENTER);
        matchReSult.setFont(maintree_20);
        matchReSult.setBounds(30, 170, 567, 30);
        add(matchReSult);
        setVisible(false);

        btnHome = Untils.getButton(ImagePaths.GAME_HOME_1, ImagePaths.GAME_HOME_2);
        btnHome.setBounds(231, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        add(btnHome);

        btnPlayAgain = Untils.getButton(ImagePaths.GAME_PLAY_AGAIN_1, ImagePaths.GAME_PLAY_AGAIN_2);
        btnPlayAgain.setBounds(291, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        add(btnPlayAgain);

        btnRank = Untils.getButton(ImagePaths.GAME_RANK_1, ImagePaths.GAME_RANK_2);
        btnRank.setBounds(351, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        add(btnRank);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_MATCH_RESULT).getImage();
        g.drawImage(imageAboutDialog, 0, 0, width, height, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.getContentPane().setLayout(null);
        MatchResultSinglePlayerDialog aboutDialog = new MatchResultSinglePlayerDialog("Zafes", 15);
        aboutDialog.setBounds(225, 200, aboutDialog.width, aboutDialog.height);
        aboutDialog.setVisible(true);
        frame.add(aboutDialog);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
