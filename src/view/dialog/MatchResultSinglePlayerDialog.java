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
    private JButton buttonHome;
    private JButton buttonPlayAgain;
    private JButton buttonRank;

    public MatchResultSinglePlayerDialog(String name, int score) {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        Image imageHome1 = new ImageIcon(ImagePaths.GAME_HOME_1).getImage();
        Image imageHome2 = new ImageIcon(ImagePaths.GAME_HOME_2).getImage();
        Image imagePlayAgain1 = new ImageIcon(ImagePaths.GAME_PLAY_AGAIN_1).getImage();
        Image imagePlayAgain2 = new ImageIcon(ImagePaths.GAME_PLAY_AGAIN_2).getImage();
        Image imageRank1 = new ImageIcon(ImagePaths.GAME_RANK_1).getImage();
        Image imageRank2 = new ImageIcon(ImagePaths.GAME_RANK_2).getImage();

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

        buttonHome = new JButton(new ImageIcon(imageHome1));
        buttonHome.setRolloverIcon(new ImageIcon(imageHome2));
        buttonHome.setBounds(231, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        buttonHome.setBorderPainted(false);
        buttonHome.setContentAreaFilled(false);
        buttonHome.setFocusPainted(false);
        add(buttonHome);

        buttonPlayAgain = new JButton(new ImageIcon(imagePlayAgain1));
        buttonPlayAgain.setRolloverIcon(new ImageIcon(imagePlayAgain2));
        buttonPlayAgain.setBounds(291, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        buttonPlayAgain.setBorderPainted(false);
        buttonPlayAgain.setContentAreaFilled(false);
        buttonPlayAgain.setFocusPainted(false);
        add(buttonPlayAgain);

        buttonRank = new JButton(new ImageIcon(imageRank1));
        buttonRank.setRolloverIcon(new ImageIcon(imageRank2));
        buttonRank.setBounds(351, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        buttonRank.setBorderPainted(false);
        buttonRank.setContentAreaFilled(false);
        buttonRank.setFocusPainted(false);
        add(buttonRank);
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
