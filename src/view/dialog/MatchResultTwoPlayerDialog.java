package view.dialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import untils.Constant;
import untils.ImagePaths;
import untils.Untils;
import view.panel.TwoPlayerPanel;

public class MatchResultTwoPlayerDialog extends JPanel {
    public static final int WIDTH = 627;
    public static final int HEIGHT = 385;

    private TwoPlayerPanel twoPlayerPanel;

    private JLabel matchScore;
    private JLabel matchReSult;
    private JButton buttonHome;
    private JButton buttonPlayAgain;

    public MatchResultTwoPlayerDialog(TwoPlayerPanel twoPlayerPanel) {
        this.twoPlayerPanel = twoPlayerPanel;
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponent();
        setOpaque(false);
        setVisible(false);
    }

    public void initComponent() {
        Font maintree_20 = Untils.getFont(20);
        
        matchScore = new JLabel("", JLabel.CENTER);
        matchScore.setFont(maintree_20);
        matchScore.setBounds(30, 120, 567, 30);
        add(matchScore);

        matchReSult = new JLabel("", JLabel.CENTER);
        matchReSult.setFont(maintree_20);
        matchReSult.setBounds(30, 170, 567, 30);
        add(matchReSult);

        buttonHome = Untils.getButton(ImagePaths.GAME_HOME_1,ImagePaths.GAME_HOME_2);
        buttonHome.setBounds(250, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        add(buttonHome);

        buttonPlayAgain = Untils.getButton(ImagePaths.GAME_PLAY_AGAIN_1,ImagePaths.GAME_PLAY_AGAIN_2);
        buttonPlayAgain.setBounds(310, 300, Constant.GAME_BUTTON_WIDTH, Constant.GAME_BUTTON_WIDTH);
        add(buttonPlayAgain);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageAboutDialog = new ImageIcon(ImagePaths.DIALOG_MATCH_RESULT).getImage();
        g.drawImage(imageAboutDialog, 0, 0, WIDTH, HEIGHT, this);
    }

    public void open() {
        update();
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    private void update() {
        int player1Score = twoPlayerPanel.getModeTwoPlayer().getPlayer1Score();
        int player2Score = twoPlayerPanel.getModeTwoPlayer().getPlayer2Score();

        String score = "Match score : " + player1Score + " - " + player2Score;
        matchScore.setText(score);

        String result;
        if (player1Score > player2Score)
            result = "Player 1 is the winner!";
        else if (player1Score < player2Score)
            result = "Player 2 is the winner!";
        else
            result = "It is a draw!";
        matchReSult.setText(result);
    }

    
}
