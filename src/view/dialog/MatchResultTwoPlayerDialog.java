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

public class MatchResultTwoPlayerDialog extends JPanel {
    private final int width = 627;
    private final int height = 385;
    private JLabel matchScore;
    private JLabel matchReSult;
    private JButton buttonHome;
    private JButton buttonPlayAgain;
    private JButton buttonRank;

    public MatchResultTwoPlayerDialog(int player1Score, int player2Score) {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        Image imageHome1 = new ImageIcon(ImagePaths.GAME_HOME_1).getImage();
        Image imageHome2 = new ImageIcon(ImagePaths.GAME_HOME_2).getImage();
        Image imagePlayAgain1 = new ImageIcon(ImagePaths.GAME_PLAY_AGAIN_1).getImage();
        Image imagePlayAgain2 = new ImageIcon(ImagePaths.GAME_PLAY_AGAIN_2).getImage();
        Image imageRank1 = new ImageIcon(ImagePaths.GAME_RANK_1).getImage();
        Image imageRank2 = new ImageIcon(ImagePaths.GAME_RANK_2).getImage();

        Font maintree_20 = Untils.getFont(20);
        matchScore = new JLabel("Match score : " + player1Score + " - " + player2Score, JLabel.CENTER);
        matchScore.setFont(maintree_20);
        matchScore.setBounds(30, 120, 567, 30);
        add(matchScore);

        String result;
        if (player1Score > player2Score)
            result = "Player 1 is the winner!";
        else if (player1Score < player2Score)
            result = "Player 2 is the winner!";
        else
            result = "It is a draw!";
        matchReSult = new JLabel(result, JLabel.CENTER);
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
        MatchResultTwoPlayerDialog aboutDialog = new MatchResultTwoPlayerDialog(10, 15);
        aboutDialog.setBounds(225, 200, aboutDialog.width, aboutDialog.height);
        aboutDialog.setVisible(true);
        frame.add(aboutDialog);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
