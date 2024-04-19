import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JPanel;

public class ModeOnePlayer extends JPanel {
    private ToolBoard toolBoard;
    private ToolDice toolDice;
    private JLabel timeLabel, infoLabel, remainingMovesLabel, roundLabel;
    private JLabel scorePlayer1Label;
    private Timer timer;
    private int currentPlayer;
    private final int player1 = 1;
    public static final int MAX_TIME = 30;
    public static final int NUM_PLAYS = 5;
    public static final int NUM_MOVES = 3;
    private int remainingTime;
    private int remainingMoves;
    private int player1Plays;
    private int player1Score;
    private int round;

    ModeOnePlayer() {
        setPreferredSize(new Dimension(700, 600));
        setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 15);

        JPanel panelPlayers = new JPanel(new GridBagLayout());
        panelPlayers.setBounds(10, 251, 85, 150);
        GridBagConstraints c = new GridBagConstraints();
        JLabel player1Label = new JLabel("Player 1", JLabel.CENTER);
        player1Label.setFont(font);
        scorePlayer1Label = new JLabel("0", JLabel.CENTER);
        scorePlayer1Label.setFont(font);
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

        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        roundLabel = new JLabel("", JLabel.CENTER);
        roundLabel.setFont(font);
        infoLabel = new JLabel("Player 1's turn", JLabel.CENTER);
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
        add(infoPanel);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(143, 79, 502, 502);
        add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(700, 213, 168, 224);
        add(toolDice);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime == 0) {
                    remainingTime = MAX_TIME;
                    if (currentPlayer == player1)
                        player1Plays--;
                    if (checkWin()) {
                        endGame();
                        return;
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
        round = 1;
    }

    public void updateTimeLabel() {
        timeLabel.setText("Time: " + remainingTime + "s");
    }

    public void updateScorePlayer1() {
        scorePlayer1Label.setText(String.valueOf(player1Score));
    }

    public void updateRound() {
        roundLabel.setText("Round: " + round);
    }

    public void updateRemainingMoves() {
        remainingMovesLabel.setText("Remaining Moves: " + remainingMoves);
    }

    public void completePlayerMove() {
        if (currentPlayer == player1) {
            if (checkWinningMove()) {
                player1Score++;
            }
            player1Plays--;
            updateScorePlayer1();
        }
    }

    private boolean checkWinningMove() {
        return toolDice.getChoice().equals(toolBoard.getChoice());
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

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void startGame() {
        timer.start();
        updateRound();
        updateRemainingMoves();
        updateTimeLabel();
    }

    private void switchPlayer() {
        currentPlayer = player1;
        infoLabel.setText("Player 1's turn");
    }

    private boolean checkWin() {
        return player1Plays == 0;
    }

    private void endGame() {
        timer.stop();
        infoLabel.setText("Game Over");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mode One Player");
        ModeOnePlayer modeOnePlayer = new ModeOnePlayer();
        frame.setContentPane(modeOnePlayer);
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        modeOnePlayer.startGame();
    }
}