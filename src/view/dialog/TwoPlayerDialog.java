package view.dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import controller.TwoPlayerDialogController;
import sound.SoundClock;
import untils.ImagePaths;
import untils.Untils;
import view.object.ToolBoard;
import view.object.ToolDice;
import view.panel.TwoPlayerPanel;

import javax.swing.JPanel;

public class TwoPlayerDialog extends JPanel {
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
    private TwoPlayerDialogController twoPlayerDialogController;

    private JLayeredPane jLayeredPane;
    private JPanel panel;
    private JPanel opacityPanel;

    private ToolBoard toolBoard;
    private ToolDice toolDice;
    private JLabel timeLabel, infoLabel, remainingMovesLabel, roundLabel;
    private JLabel scorePlayer1Label, scorePlayer2Label;
    private JButton btnHome, btnPause, btnResume, btnPlayAgain, btnMute, btnUnmute, btnRules;

    private Timer timer;
    private boolean status;
    private SoundClock soundClock;

    public TwoPlayerDialog(TwoPlayerPanel twoPlayerPanel) {
        this.twoPlayerPanel = twoPlayerPanel;
        soundClock = new SoundClock(this);
        this.twoPlayerDialogController = new TwoPlayerDialogController(this);
        this.addKeyListener(twoPlayerDialogController);
        setPreferredSize(new Dimension(1100, 800));
        this.setLayout(null);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (status == false)
                    return;
                remainingTime--;
                updateTimeLabel();
                if (remainingTime == 5) {
                    if (getTwoPlayerPanel().getGameScreen().isSound()) {
                        soundClock.start();
                    }
                }
                if (remainingTime == 0) {
                    remainingTime = MAX_TIME;
                    if (currentPlayer == player1)
                        player1Plays--;
                    else
                        player2Plays--;
                    if (finishedRound() && checkWin()) {
                        endgame();
                        return;
                    }
                    if (finishedRound()) {
                        round++;
                        updateRound();
                    }
                    remainingMoves = NUM_MOVES;
                    updateRemainingMoves();
                    switchPlayer();
                }
            }
        });
        status = true;
        initComponent();
        initInfoPlayers();
        setVisible(false);
        setOpaque(false);
    }

    public void start() {
        timer.start();
    }

    public void pause() {
        status = false;
        btnPause.setVisible(false);
        btnResume.setVisible(true);
    }

    public void resume() {
        status = true;
        btnResume.setVisible(false);
        btnPause.setVisible(true);
    }

    public void mute() {
        btnMute.setVisible(false);
        btnUnmute.setVisible(true);
    }

    public void unmute() {
        btnUnmute.setVisible(false);
        btnMute.setVisible(true);
    }

    public boolean getStatus() {
        return status;
    }

    public void restart() {
        initInfoPlayers();

        panel.remove(toolBoard);
        toolBoard = new ToolBoard();
        toolBoard.setBounds(249, 190, 502, 502);
        toolBoard.setOpaque(false);
        panel.add(toolBoard);

        panel.remove(toolDice);
        toolDice = new ToolDice();
        toolDice.setBounds(890, 317, 168, 224);
        toolDice.setOpaque(false);
        panel.add(toolDice);

        revalidate();
        repaint();
        timer.restart();
        this.setFocusable(true);
    }

    public SoundClock getSoundClock() {
        return soundClock;
    }

    private void initInfoPlayers() {
        status = true;
        currentPlayer = player1;
        remainingTime = MAX_TIME;
        remainingMoves = NUM_MOVES;
        player1Plays = player2Plays = NUM_PLAYS;
        player1Score = player2Score = 0;
        round = 1;
        updateTimeLabel();
        updateRemainingMoves();
        updateCurrentPlayer();
        updateRound();
        updateScorePlayer1();
        updateScorePlayer2();
    }

    private void initComponent() {
        jLayeredPane = new JLayeredPane();
        jLayeredPane.setBounds(0, 0, WIDTH, HEIGHT);

        opacityPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 128));
                g.fillRect(0, 0, TwoPlayerDialog.WIDTH, TwoPlayerDialog.HEIGHT);
            }
        };
        opacityPanel.setBounds(0, 0, WIDTH, HEIGHT);
        opacityPanel.setOpaque(false);
        opacityPanel.setVisible(false);
        jLayeredPane.add(opacityPanel, JLayeredPane.PALETTE_LAYER);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, WIDTH, HEIGHT);
        panel.setOpaque(false);
        jLayeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);

        Font maitree_16 = Untils.getFont(16);

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
        panel.add(panelPlayers);

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
        panel.add(infoPanel);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(249, 190, ToolBoard.WIDTH, ToolBoard.HEIGHT);
        toolBoard.setOpaque(false);
        panel.add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(890, 317, ToolDice.WIDTH, ToolDice.HEIGHT);
        toolDice.setOpaque(false);
        panel.add(toolDice);

        btnHome = Untils.getButton(ImagePaths.GAME_HOME_1, ImagePaths.GAME_HOME_2);
        btnHome.setBounds(5, 5, 50, 50);
        btnHome.setActionCommand("Home");
        btnHome.addActionListener(twoPlayerDialogController);
        panel.add(btnHome);

        btnPause = Untils.getButton(ImagePaths.GAME_PAUSE_1, ImagePaths.GAME_PAUSE_2);
        btnPause.setBounds(60, 5, 50, 50);
        btnPause.setActionCommand("Pause");
        btnPause.addActionListener(twoPlayerDialogController);
        panel.add(btnPause);

        btnResume = Untils.getButton(ImagePaths.GAME_RESUME_1, ImagePaths.GAME_RESUME_2);
        btnResume.setBounds(60, 5, 50, 50);
        btnResume.setActionCommand("Resume");
        btnResume.addActionListener(twoPlayerDialogController);
        btnResume.setVisible(false);
        panel.add(btnResume);

        btnRules = Untils.getButton(ImagePaths.GAME_RULES_1, ImagePaths.GAME_RULES_2);
        btnRules.setBounds(115, 5, 50, 50);
        btnRules.setActionCommand("Rules");
        btnRules.addActionListener(twoPlayerDialogController);
        btnRules.setVisible(true);
        panel.add(btnRules);

        btnPlayAgain = Untils.getButton(ImagePaths.GAME_PLAY_AGAIN_1, ImagePaths.GAME_PLAY_AGAIN_2);
        btnPlayAgain.setBounds(5, 60, 50, 50);
        btnPlayAgain.setActionCommand("Play Again");
        btnPlayAgain.addActionListener(twoPlayerDialogController);
        panel.add(btnPlayAgain);

        btnMute = Untils.getButton(ImagePaths.GAME_MUTE_1, ImagePaths.GAME_MUTE_2);
        btnMute.setBounds(60, 60, 50, 50);
        btnMute.setActionCommand("Mute");
        btnMute.addActionListener(twoPlayerDialogController);
        panel.add(btnMute);

        btnUnmute = Untils.getButton(ImagePaths.GAME_UNMUTE_1, ImagePaths.GAME_UNMUTE_2);
        btnUnmute.setBounds(60, 60, 50, 50);
        btnUnmute.setActionCommand("Unmute");
        btnUnmute.addActionListener(twoPlayerDialogController);
        btnUnmute.setVisible(false);
        panel.add(btnUnmute);

        add(jLayeredPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.BACKGROUND_TWO_PLAYER).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public void enable() {
        for (Component c : panel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).setRolloverEnabled(true);
                for (ActionListener l : ((JButton) c).getActionListeners())
                    if (l == twoPlayerDialogController)
                        return;
                ((JButton) c).addActionListener(twoPlayerDialogController);
            }
        }
        opacityPanel.setVisible(false);
        timer.start();
        this.addKeyListener(twoPlayerDialogController);
    }

    public void disable() {
        for (Component c : panel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).setRolloverEnabled(false);
                ((JButton) c).removeActionListener(twoPlayerDialogController);
            }
        }
        timer.stop();
        this.removeKeyListener(twoPlayerDialogController);
        opacityPanel.setVisible(true);
    }

    public void endgame() {
        timer.stop();
        this.setFocusable(false);
        roundLabel.setText("Match score: " + player1Score + " - " + player2Score);
        infoLabel.setText("");
        String result;
        if (player1Score > player2Score)
            result = "Player 1 is the winner!";
        else if (player1Score < player2Score)
            result = "Player 2 is the winner!";
        else
            result = "It is a draw!";
        remainingMovesLabel.setText(result);
        timeLabel.setText("");
    }

    public void open() {
        if (getTwoPlayerPanel().getGameScreen().isMusic()) {
            btnMute.setVisible(true);
            btnUnmute.setVisible(false);
        } else {
            btnUnmute.setVisible(true);
            btnMute.setVisible(false);
        }
        setVisible(true);
    }

    public void close() {
        timer.stop();
        setVisible(false);
    }

    public TwoPlayerPanel getTwoPlayerPanel() {
        return twoPlayerPanel;
    }

    private boolean checkWinningMove() {
        if (toolBoard.isMoveBackToSecondPrevious())
            return false;
        return toolDice.getChoice().compareTo(toolBoard.getChoice()) == 1;
    }

    public boolean checkWin() {
        if (player1Plays == 0 || Math.abs(player1Score - player2Score) >= 3) {
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
        updateCurrentPlayer();
    }

    public void updateCurrentPlayer() {
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
        toolBoard.updatePreMove();
    }

    public ToolBoard getToolBoard() {
        return toolBoard;
    }

    public ToolDice getToolDice() {
        return toolDice;
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

    public int getPlayer2Plays() {
        return player2Plays;
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

    public boolean finishedRound() {
        return player1Plays == player2Plays;
    }

    public JButton getBtnUnmute() {
        return btnUnmute;
    }

    public JButton getBtnMute() {
        return btnMute;
    }

    public JButton getBtnPlayAgain() {
        return btnPlayAgain;
    }

    public JButton getBtnResume() {
        return btnResume;
    }

    public JButton getBtnPause() {
        return btnPause;
    }

    public JButton getBtnHome() {
        return btnHome;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}
