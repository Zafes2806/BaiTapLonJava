import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JPanel;

public class ModeTwoPlayer extends JPanel {
    private ToolBoard toolBoard;
    private ToolDice toolDice;
    JLabel timeLabel, infoLabel, remainingMovesLabel, roundLabel;
    JLabel scorePlayer1Label, scorePlayer2Label;
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

    ModeTwoPlayer() {
        setPreferredSize(new Dimension(700, 600));
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 15);

        JPanel panelPlayers = new JPanel(new GridBagLayout());
        panelPlayers.setBounds(10, 251, 85, 150);
        GridBagConstraints c = new GridBagConstraints();
        JLabel player1Label = new JLabel("Player 1", JLabel.CENTER);
        player1Label.setFont(font);
        JLabel player2Label = new JLabel("Player 2", JLabel.CENTER);
        player2Label.setFont(font);
        scorePlayer1Label = new JLabel("0", JLabel.CENTER);
        scorePlayer1Label.setFont(font);
        scorePlayer2Label = new JLabel("0", JLabel.CENTER);
        scorePlayer2Label.setFont(font);
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
        this.add(panelPlayers);

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        roundLabel = new JLabel("", JLabel.CENTER);
        roundLabel.setFont(font);
        infoLabel = new JLabel("Player1's turn", JLabel.CENTER);
        infoLabel.setFont(font);
        remainingMovesLabel = new JLabel("", JLabel.CENTER);
        remainingMovesLabel.setFont(font);
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(font);
        infoPanel.add(roundLabel);
        infoPanel.add(infoLabel);
        infoPanel.add(remainingMovesLabel);
        infoPanel.add(timeLabel);
        infoPanel.setBounds(286, 11, 206, 60);
        this.add(infoPanel);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(143, 79, 502, 502);
        this.add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(700, 213, 168, 224);
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
        currentPlayer = player1;
        remainingTime = MAX_TIME;
        remainingMoves = NUM_MOVES;
        player1Plays = player2Plays = NUM_PLAYS;
        player1Score = player2Score = 0;
        round = 1;
        ModeTwoPlayerListener modeTwoPlayerListener = new ModeTwoPlayerListener(this);
        this.addKeyListener(modeTwoPlayerListener);
        timer.start();
        updateTimeLabel();
        updateRemainingMoves();
        updateRound();
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
        frame.setSize(906, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ModeTwoPlayer modeTwoPlayer = new ModeTwoPlayer();
        frame.add(modeTwoPlayer);
        modeTwoPlayer.setFocusable(true);
        frame.setVisible(true);
    }

}
