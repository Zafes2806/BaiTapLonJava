package view.panel;

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
import javax.swing.JLabel;
import javax.swing.Timer;

import controller.panel.ModeTwoPlayerController;
import untils.ImagePaths;
import untils.Untils;
import view.object.ToolBoard;
import view.object.ToolDice;

import javax.swing.JPanel;

public class ModeTwoPlayer extends JPanel {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
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

    private TwoPlayerPanel twoPlayerPanel;
    private ModeTwoPlayerController modeTwoPlayerListener;
    private ToolBoard toolBoard;
    private ToolDice toolDice;
    private JLabel timeLabel, infoLabel, remainingMovesLabel, roundLabel;
    private JLabel scorePlayer1Label, scorePlayer2Label;
    private JButton btnHome, btnPause, btnResume, btnSave, btnMute, btnUnmute;
    private Font maitree_16;
    private Timer timer;

    ModeTwoPlayer(TwoPlayerPanel twoPlayerPanel) {
        this.twoPlayerPanel = twoPlayerPanel;
        this.modeTwoPlayerListener = new ModeTwoPlayerController(this);
        setPreferredSize(new Dimension(1100, 800));
        this.setLayout(null);
        try {
            File maitreeFont = new File("res/font/Maitree-Bold.ttf");
            maitree_16 = Font.createFont(Font.TRUETYPE_FONT, maitreeFont).deriveFont(Font.BOLD, 16);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        JPanel panelPlayers = new JPanel(new GridBagLayout());
        panelPlayers.setBounds(30, 355, 85, 150);
        GridBagConstraints c = new GridBagConstraints();
        JLabel player1Label = new JLabel("Player 1", JLabel.CENTER);
        player1Label.setFont(maitree_16);
        JLabel player2Label = new JLabel("Player 2", JLabel.CENTER);
        player2Label.setFont(maitree_16);
        scorePlayer1Label = new JLabel("0", JLabel.CENTER);
        scorePlayer1Label.setFont(maitree_16);
        scorePlayer2Label = new JLabel("0", JLabel.CENTER);
        scorePlayer2Label.setFont(maitree_16);
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
        roundLabel.setFont(maitree_16);
        infoLabel = new JLabel("Player1's turn", JLabel.CENTER);
        infoLabel.setFont(maitree_16);
        remainingMovesLabel = new JLabel("", JLabel.CENTER);
        remainingMovesLabel.setFont(maitree_16);
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(maitree_16);
        infoPanel.add(roundLabel);
        infoPanel.add(infoLabel);
        infoPanel.add(remainingMovesLabel);
        infoPanel.add(timeLabel);
        infoPanel.setBounds(400, 35, 210, 80);
        infoPanel.setOpaque(false);
        this.add(infoPanel);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(249, 190, 502, 502);
        toolBoard.setOpaque(false);
        this.add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(890, 317, 168, 224);
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

        this.addKeyListener(modeTwoPlayerListener);
        timer.start();
        updateTimeLabel();
        updateRemainingMoves();
        updateRound();
    }

    private void initControlButtons() {
        btnHome = Untils.getButton(ImagePaths.GAME_HOME_1, ImagePaths.GAME_HOME_2);
        btnHome.setActionCommand("buttonHome");
        btnHome.setBounds(5, 5, 50, 50);
        btnHome.addActionListener(modeTwoPlayerListener);
        this.add(btnHome);

        btnPause = Untils.getButton(ImagePaths.GAME_PAUSE_1, ImagePaths.GAME_PAUSE_2);
        btnPause.setBounds(60, 5, 50, 50);
        btnPause.addActionListener(modeTwoPlayerListener);
        this.add(btnPause);

        btnResume = Untils.getButton(ImagePaths.GAME_RESUME_1, ImagePaths.GAME_RESUME_2);
        btnResume.setBounds(60, 5, 50, 50);
        btnResume.addActionListener(modeTwoPlayerListener);

        btnSave = Untils.getButton(ImagePaths.GAME_SAVE_1, ImagePaths.GAME_SAVE_2);
        btnSave.setBounds(5, 60, 50, 50);
        btnSave.addActionListener(modeTwoPlayerListener);
        this.add(btnSave);


        btnMute = Untils.getButton(ImagePaths.GAME_MUTE_1, ImagePaths.GAME_MUTE_2);
        btnMute.setBounds(60, 60, 50, 50);
        btnMute.addActionListener(modeTwoPlayerListener);
        this.add(btnMute);

        btnUnmute = Untils.getButton(ImagePaths.GAME_UNMUTE_1, ImagePaths.GAME_UNMUTE_2);
        btnUnmute.setBounds(60, 60, 50, 50);
        btnUnmute.addActionListener(modeTwoPlayerListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.BACKGROUND_TWO_PLAYER).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public void open() {
        setVisible(true);
    }

    public void close() {
        setVisible(false);
    }

    public TwoPlayerPanel getTwoPlayerPanel() {
        return twoPlayerPanel;
    }

    private boolean checkWinningMove() {
        return toolDice.getChoice().compareTo(toolBoard.getChoice()) == 1;
    }

    public boolean checkWin() {
        if (player1Plays != player2Plays)
            return false;
        if (player1Plays == 0 || Math.abs(player1Score - player2Score) >= 3) {
            twoPlayerPanel.openResultTwoPlayerDialog();
            return true;
        }
        return false;
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

    public void setRound(int i) {
        round = i;
    }
}
