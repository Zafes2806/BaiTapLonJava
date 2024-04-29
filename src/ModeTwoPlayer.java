import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JPanel;

public class ModeTwoPlayer extends JPanel {
    private ToolBoard toolBoard;
    private ToolDice toolDice;
    JLabel timeLabel, infoLabel, remainingMovesLabel, roundLabel;
    JLabel scorePlayer1Label, scorePlayer2Label;
    JButton buttonHome, buttonPause, buttonResume, buttonSave, buttonMute, buttonUnmute;
    Font maitree_15;
    private Timer timer;
    private int currentPlayer;
    private final int player1 = 1;
    private final int player2 = 2;
    public static final int MAX_TIME = 30;
    public static final int NUM_PLAYS = 5;
    public static final int NUM_MOVES = 3;
    private int remainingTime;
    private int remainingMoves;
    private int player1Plays;
    private int player2Plays;
    private int player1Score;
    private int player2Score;
    private int round;

    private void initControlButtons() {
        Image imageHome1 = new ImageIcon(URLImage.home1).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageHome2 = new ImageIcon(URLImage.home2).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imagePause1 = new ImageIcon(URLImage.pause1).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imagePause2 = new ImageIcon(URLImage.pause2).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageResume1 = new ImageIcon(URLImage.resume1).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageResume2 = new ImageIcon(URLImage.resume2).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageSave1 = new ImageIcon(URLImage.save1).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageSave2 = new ImageIcon(URLImage.save2).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageMute1 = new ImageIcon(URLImage.mute1).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageMute2 = new ImageIcon(URLImage.mute2).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageUnmute1 = new ImageIcon(URLImage.unmute1).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        Image imageUnmute2 = new ImageIcon(URLImage.unmute2).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

        buttonHome = new JButton(new ImageIcon(imageHome1));
        buttonHome.setRolloverIcon(new ImageIcon(imageHome2));
        buttonHome.setBorderPainted(false);
        buttonHome.setContentAreaFilled(false);
        buttonHome.setFocusPainted(false);
        buttonHome.setBounds(5, 5, 40, 40);
        this.add(buttonHome);

        buttonPause = new JButton(new ImageIcon(imagePause1));
        buttonPause.setRolloverIcon(new ImageIcon(imagePause2));
        buttonPause.setBorderPainted(false);
        buttonPause.setContentAreaFilled(false);
        buttonPause.setFocusPainted(false);
        buttonPause.setBounds(50, 5, 40, 40);
        this.add(buttonPause);

        buttonResume = new JButton(new ImageIcon(imageResume1));
        buttonResume.setRolloverIcon(new ImageIcon(imageResume2));
        buttonResume.setBorderPainted(false);
        buttonResume.setContentAreaFilled(false);
        buttonResume.setFocusPainted(false);
        buttonResume.setBounds(50, 5, 40, 40);

        buttonSave = new JButton(new ImageIcon(imageSave1));
        buttonSave.setRolloverIcon(new ImageIcon(imageSave2));
        buttonSave.setBorderPainted(false);
        buttonSave.setContentAreaFilled(false);
        buttonSave.setFocusPainted(false);
        buttonSave.setBounds(5, 50, 40, 40);
        this.add(buttonSave);

        buttonMute = new JButton(new ImageIcon(imageMute1));
        buttonMute.setRolloverIcon(new ImageIcon(imageMute2));
        buttonMute.setBorderPainted(false);
        buttonMute.setContentAreaFilled(false);
        buttonMute.setFocusPainted(false);
        buttonMute.setBounds(50, 50, 40, 40);
        this.add(buttonMute);

        buttonUnmute = new JButton(new ImageIcon(imageUnmute1));
        buttonUnmute.setRolloverIcon(new ImageIcon(imageUnmute2));
        buttonUnmute.setBorderPainted(false);
        buttonUnmute.setContentAreaFilled(false);
        buttonUnmute.setFocusPainted(false);
        buttonUnmute.setBounds(50, 50, 40, 40);
    }

    ModeTwoPlayer() {
        setPreferredSize(new Dimension(1100, 800));
        this.setLayout(null);
        try {
            File maitreeFont = new File("res/font/Maitree-Bold.ttf");
            maitree_15 = Font.createFont(Font.TRUETYPE_FONT, maitreeFont).deriveFont(Font.BOLD, 16);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JPanel panelPlayers = new JPanel(new GridBagLayout());
        panelPlayers.setBounds(30, 335, 85, 150);
        GridBagConstraints c = new GridBagConstraints();
        JLabel player1Label = new JLabel("Player 1", JLabel.CENTER);
        player1Label.setFont(maitree_15);
        JLabel player2Label = new JLabel("Player 2", JLabel.CENTER);
        player2Label.setFont(maitree_15);
        scorePlayer1Label = new JLabel("0", JLabel.CENTER);
        scorePlayer1Label.setFont(maitree_15);
        scorePlayer2Label = new JLabel("0", JLabel.CENTER);
        scorePlayer2Label.setFont(maitree_15);
        c.gridx = 0;
        c.gridy = 0;
        panelPlayers.add(player1Label, c);
        c.gridy = 1;
        panelPlayers.add(scorePlayer1Label, c);
        c.gridy = 2;
        c.weighty = 1;
        panelPlayers.add(new JLabel(), c);
        c.gridy = 3;
        c.weighty = 0;
        panelPlayers.add(scorePlayer2Label, c);
        c.gridy = 4;
        panelPlayers.add(player2Label, c);
        panelPlayers.setOpaque(false);
        this.add(panelPlayers);

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        roundLabel = new JLabel("", JLabel.CENTER);
        roundLabel.setFont(maitree_15);
        infoLabel = new JLabel("Player1's turn", JLabel.CENTER);
        infoLabel.setFont(maitree_15);
        remainingMovesLabel = new JLabel("", JLabel.CENTER);
        remainingMovesLabel.setFont(maitree_15);
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(maitree_15);
        infoPanel.add(roundLabel);
        infoPanel.add(infoLabel);
        infoPanel.add(remainingMovesLabel);
        infoPanel.add(timeLabel);
        infoPanel.setBounds(392, 29, 210, 80);
        infoPanel.setOpaque(false);
        this.add(infoPanel);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(239, 170, 502, 502);
        toolBoard.setOpaque(false);
        this.add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(875, 297, 168, 224);
        toolDice.setOpaque(false);
        this.add(toolDice);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime == 0) {
                    remainingTime = MAX_TIME;
                    if (currentPlayer == player1)
                        player1Plays--;
                    else
                        player2Plays--;
                    if (checkWin())
                        return;
                    if (player1Plays == player2Plays) {
                        round++;
                        updateRound();
                    }
                    remainingMoves = NUM_MOVES;
                    updateRemainingMoves();
                    switchPlayer();
                }
                updateTimeLabel();
            }
        });
        initControlButtons();
        currentPlayer = player1;
        remainingTime = MAX_TIME;
        remainingMoves = NUM_MOVES;
        player1Plays = player2Plays = NUM_PLAYS;
        player1Score = player2Score = 0;
        round = 1;
        ModeTwoPlayerListener modeTwoPlayerListener = new ModeTwoPlayerListener(this);
        this.addKeyListener(modeTwoPlayerListener);
        this.setFocusable(true);
        this.setRequestFocusEnabled(true);
        timer.start();
        updateTimeLabel();
        updateRemainingMoves();
        updateRound();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(URLImage.background2Player);
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public void updateTimeLabel() {
        timeLabel.setText("Time: " + remainingTime + "s");
    }

    public void updateScorePlayer1() {
        scorePlayer1Label.setText(player1Score + "");
    }

    public void updateScorePlayer2() {
        scorePlayer2Label.setText(player2Score + "");
    }

    public void updateRound() {
        roundLabel.setText("Round: " + round);
    }

    public void updateRemainingMoves() {
        remainingMovesLabel.setText("Remaining Moves: " + remainingMoves);
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        infoLabel.setText("Player" + currentPlayer + "'s turn");
    }

    public void completePlayerMove() {
        if (currentPlayer == player1) {
            if (checkWinningMove()) {
                player1Score++;
            }
            player1Plays--;
            updateScorePlayer1();
        } else {
            if (checkWinningMove()) {
                player2Score++;
            }
            player2Plays--;
            updateScorePlayer2();
        }
    }

    private boolean checkWinningMove() {
        return toolDice.getChoice().compareTo(toolBoard.getChoice()) == 1;
    }

    public ToolBoard getToolBoard() {
        return toolBoard;
    }

    public void setToolBoard(ToolBoard toolBoard) {
        this.toolBoard = toolBoard;
    }

    public ToolDice getToolDice() {
        return toolDice;
    }

    public void setToolDice(ToolDice toolDice) {
        this.toolDice = toolDice;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    public JLabel getInfoLabel() {
        return infoLabel;
    }

    public void setInfoLabel(JLabel infoLabel) {
        this.infoLabel = infoLabel;
    }

    public JLabel getRemainingMovesLabel() {
        return remainingMovesLabel;
    }

    public void setRemainingMovesLabel(JLabel remainingMovesLabel) {
        this.remainingMovesLabel = remainingMovesLabel;
    }

    public JLabel getRoundLabel() {
        return roundLabel;
    }

    public void setRoundLabel(JLabel roundLabel) {
        this.roundLabel = roundLabel;
    }

    public JLabel getScorePlayer1Label() {
        return scorePlayer1Label;
    }

    public void setScorePlayer1Label(JLabel scorePlayer1Label) {
        this.scorePlayer1Label = scorePlayer1Label;
    }

    public JLabel getScorePlayer2Label() {
        return scorePlayer2Label;
    }

    public void setScorePlayer2Label(JLabel scorePlayer2Label) {
        this.scorePlayer2Label = scorePlayer2Label;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getRemainingMoves() {
        return remainingMoves;
    }

    public void setRemainingMoves(int remainingMoves) {
        this.remainingMoves = remainingMoves;
    }

    public int getPlayer1Plays() {
        return player1Plays;
    }

    public void setPlayer1Plays(int player1Plays) {
        this.player1Plays = player1Plays;
    }

    public int getPlayer2Plays() {
        return player2Plays;
    }

    public void setPlayer2Plays(int player2Plays) {
        this.player2Plays = player2Plays;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public boolean checkWin() {
        if (player1Plays != player2Plays)
            return false;
        if (player1Plays > 0 && player1Score - player2Score == 3) {
            endGame("1");
            return true;
        }
        if (player1Plays > 0 && player2Score - player1Score == 3) {
            endGame("2");
            return true;
        }
        if (player1Plays == 0 && player1Score > player2Score) {
            endGame("1");
            return true;
        }
        if (player1Plays == 0 && player2Score > player1Score) {
            endGame("2");
            return true;
        }
        if (player1Plays == 0 && player2Score == player1Score) {
            endGame("draw");
            return true;
        }
        return false;
    }

    private void endGame(String winner) {
        timer.stop();
        if (winner.equals("draw"))
            infoLabel.setText("It's a draw");
        else
            infoLabel.setText("Player" + winner + " wins!");
        this.setEnabled(false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1100, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ModeTwoPlayer modeTwoPlayer = new ModeTwoPlayer();
        frame.add(modeTwoPlayer);
        modeTwoPlayer.setFocusable(true);
        frame.setVisible(true);
    }

}
