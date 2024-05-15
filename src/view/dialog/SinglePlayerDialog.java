package view.dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import DAO.RankDAO;
import controller.SinglePlayerDialogController;
import model.Player;
import sound.SoundClock;
import untils.ImagePaths;
import untils.Untils;
import view.object.ToolBoard;
import view.object.ToolDice;
import view.panel.SinglePlayerPanel;

public class SinglePlayerDialog extends JPanel {
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    public static final int MAX_TIME = 30;
    public static final int NUM_MOVES = 3;
    public static final int PAUSE = 0;
    public static final int ENDGAME = 1;
    public static final int RUNNING = 2;
    private int remainingTime;
    private int remainingMoves;
    private int playerScore;
    private String playerName;

    private SinglePlayerPanel singlePlayerPanel;
    private SinglePlayerDialogController singlePlayerDialogController;

    private JLayeredPane jLayeredPane;
    private JPanel panel;
    private JPanel opacityPanel;

    private ToolBoard toolBoard;
    private ToolDice toolDice;
    private JLabel timeLabel, remainingMovesLabel;
    private JLabel scorePlayerLabel, namePlayerLabel;
    private JButton btnHome, btnPause, btnResume, btnPlayAgain, btnMute, btnUnmute, btnRules, btnRank, btnSave;

    private Timer timer;
    private int status;
    private SoundClock soundClock;

    public SinglePlayerDialog(SinglePlayerPanel singlePlayerPanel) {
        this.singlePlayerPanel = singlePlayerPanel;
        soundClock = new SoundClock(this);
        this.singlePlayerDialogController = new SinglePlayerDialogController(this);
        this.addKeyListener(singlePlayerDialogController);
        setPreferredSize(new Dimension(1100, 800));
        this.setLayout(null);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (status != RUNNING)
                    return;
                remainingTime--;
                updateTimeLabel();
                if (remainingTime == 5) {
                    if (getSinglePlayerPanel().getGameScreen().isSound()) {
                        soundClock.start();
                    }
                }
                if (remainingTime == 0) {
                    updateRemainingMoves();
                    RankDAO.addPlayer(new Player(playerName, playerScore));
                    RankDAO.updateRank();
                    endgame();
                }
            }
        });
        status = RUNNING;
        initComponent();
        initInfoPlayers();
        setVisible(false);
        setOpaque(false);
    }

    public void start() {
        timer.start();
    }

    public void pause() {
        btnPause.setVisible(false);
        btnResume.setVisible(true);
        if (status == ENDGAME)
            return;
        // timer.stop();
        status = PAUSE;
    }

    public void resume() {
        btnResume.setVisible(false);
        btnPause.setVisible(true);
        if (status == ENDGAME)
            return;
        // timer.restart();
        status = RUNNING;
    }

    public void mute() {
        btnMute.setVisible(false);
        btnUnmute.setVisible(true);
    }

    public void unmute() {
        btnUnmute.setVisible(false);
        btnMute.setVisible(true);
    }

    public int getStatus() {
        return status;
    }

    public void restart() {
        initInfoPlayers();
        status = RUNNING;

        panel.remove(toolBoard);
        toolBoard = new ToolBoard();
        toolBoard.setBounds(249, 190, ToolBoard.WIDTH, ToolBoard.HEIGHT);
        toolBoard.setOpaque(false);
        panel.add(toolBoard);

        panel.remove(toolDice);
        toolDice = new ToolDice();
        toolDice.setBounds(890, 317, ToolDice.WIDTH, ToolDice.HEIGHT);
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
        remainingTime = MAX_TIME;
        remainingMoves = NUM_MOVES;
        playerScore = 0;
        if (playerName == null)
            playerName = getSinglePlayerPanel().getNewGameDialog().getPlayerName();

        updateTimeLabel();
        updateRemainingMoves();
        updateScorePlayer();
        updateNamePlayer();
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

        JPanel panelInfoPlayer = new JPanel();
        panelInfoPlayer.setLayout(null);
        panelInfoPlayer.setBounds(30, 355, 120, 150);
        panelInfoPlayer.setOpaque(false);
        namePlayerLabel = new JLabel(getSinglePlayerPanel().getNewGameDialog().getPlayerName(), JLabel.CENTER);
        namePlayerLabel.setBounds(0, 30, 120, 40);
        namePlayerLabel.setFont(maitree_16);
        panelInfoPlayer.add(namePlayerLabel);
        scorePlayerLabel = new JLabel("Score: 0", JLabel.CENTER);
        scorePlayerLabel.setBounds(0, 90, 120, 40);
        scorePlayerLabel.setFont(maitree_16);
        panelInfoPlayer.add(scorePlayerLabel);
        panel.add(panelInfoPlayer);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        remainingMovesLabel = new JLabel("", JLabel.CENTER);
        remainingMovesLabel.setFont(maitree_16);
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(maitree_16);
        infoPanel.add(remainingMovesLabel);
        infoPanel.add(timeLabel);
        infoPanel.setBounds(400, 35, 210, 80);
        infoPanel.setOpaque(false);
        panel.add(infoPanel);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(249, 190, 502, 502);
        toolBoard.setOpaque(false);
        panel.add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(890, 317, 168, 224);
        toolDice.setOpaque(false);
        panel.add(toolDice);

        btnHome = Untils.getButton(ImagePaths.GAME_HOME_1, ImagePaths.GAME_HOME_2);
        btnHome.setBounds(5, 5, 50, 50);
        btnHome.setActionCommand("Home");
        btnHome.addActionListener(singlePlayerDialogController);
        panel.add(btnHome);

        btnPause = Untils.getButton(ImagePaths.GAME_PAUSE_1, ImagePaths.GAME_PAUSE_2);
        btnPause.setBounds(60, 5, 50, 50);
        btnPause.setActionCommand("Pause");
        btnPause.addActionListener(singlePlayerDialogController);
        panel.add(btnPause);

        btnResume = Untils.getButton(ImagePaths.GAME_RESUME_1, ImagePaths.GAME_RESUME_2);
        btnResume.setBounds(60, 5, 50, 50);
        btnResume.setActionCommand("Resume");
        btnResume.addActionListener(singlePlayerDialogController);
        btnResume.setVisible(false);
        panel.add(btnResume);

        btnRules = Untils.getButton(ImagePaths.GAME_RULES_1, ImagePaths.GAME_RULES_2);
        btnRules.setBounds(115, 5, 50, 50);
        btnRules.setActionCommand("Rules");
        btnRules.addActionListener(singlePlayerDialogController);
        btnRules.setVisible(true);
        panel.add(btnRules);

        btnPlayAgain = Untils.getButton(ImagePaths.GAME_PLAY_AGAIN_1, ImagePaths.GAME_PLAY_AGAIN_2);
        btnPlayAgain.setBounds(5, 60, 50, 50);
        btnPlayAgain.setActionCommand("Play Again");
        btnPlayAgain.addActionListener(singlePlayerDialogController);
        panel.add(btnPlayAgain);

        btnMute = Untils.getButton(ImagePaths.GAME_MUTE_1, ImagePaths.GAME_MUTE_2);
        btnMute.setBounds(60, 60, 50, 50);
        btnMute.setActionCommand("Mute");
        btnMute.addActionListener(singlePlayerDialogController);
        panel.add(btnMute);

        btnUnmute = Untils.getButton(ImagePaths.GAME_UNMUTE_1, ImagePaths.GAME_UNMUTE_2);
        btnUnmute.setBounds(60, 60, 50, 50);
        btnUnmute.setActionCommand("Unmute");
        btnUnmute.addActionListener(singlePlayerDialogController);
        btnUnmute.setVisible(false);
        panel.add(btnUnmute);

        btnSave = Untils.getButton(ImagePaths.GAME_SAVE_1, ImagePaths.GAME_SAVE_2);
        btnSave.setBounds(115, 60, 50, 50);
        btnSave.setActionCommand("Save");
        btnSave.addActionListener(singlePlayerDialogController);
        panel.add(btnSave);

        btnRank = Untils.getButton(ImagePaths.GAME_RANK_1, ImagePaths.GAME_RANK_2);
        btnRank.setBounds(5, 115, 50, 50);
        btnRank.setActionCommand("Rank");
        btnRank.addActionListener(singlePlayerDialogController);
        panel.add(btnRank);

        add(jLayeredPane);
    }

    public void update(String playerName, int playerScore, int remainingMoves, int remainingTime, ToolBoard toolBoard,
            ToolDice toolDice) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.remainingMoves = remainingMoves;
        this.remainingTime = remainingTime;
        updateNamePlayer();
        updateScorePlayer();
        updateRemainingMoves();
        updateTimeLabel();

        panel.remove(this.toolBoard);
        this.toolBoard = toolBoard;
        toolBoard.setBounds(249, 190, 502, 502);
        toolBoard.setOpaque(false);
        panel.add(toolBoard);

        panel.remove(this.toolDice);
        this.toolDice = toolDice;
        toolDice.setBounds(890, 317, 168, 224);
        toolDice.setOpaque(false);
        panel.add(toolDice);

        revalidate();
        repaint();
    }

    private void updateNamePlayer() {
        namePlayerLabel.setText(playerName);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon(ImagePaths.BACKGROUND_SINGLE_PLAYER).getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public void enable() {
        for (Component c : panel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).setRolloverEnabled(true);
                for (ActionListener l : ((JButton) c).getActionListeners())
                    if (l == singlePlayerDialogController)
                        return;
                ((JButton) c).addActionListener(singlePlayerDialogController);
            }
        }
        opacityPanel.setVisible(false);
        if (status == RUNNING)
            timer.restart();
        this.addKeyListener(singlePlayerDialogController);
    }

    public void endgame() {
        status = ENDGAME;
        timer.stop();
        this.setFocusable(false);
    }

    public void disable() {
        for (Component c : panel.getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).setRolloverEnabled(false);
                ((JButton) c).removeActionListener(singlePlayerDialogController);
            }
        }
        timer.stop();
        this.removeKeyListener(singlePlayerDialogController);
        opacityPanel.setVisible(true);
    }

    public void open() {
        if (getSinglePlayerPanel().getGameScreen().isMusic()) {
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

    public boolean checkWinningMove() {
        if (toolBoard.isMoveBackToSecondPrevious())
            return false;
        return toolDice.getChoice().compareTo(toolBoard.getChoice()) == 1;
    }

    public void updateTimeLabel() {
        timeLabel.setText("Time: " + remainingTime + "s");
    }

    public void updateScorePlayer() {
        scorePlayerLabel.setText("Score: " + playerScore);
    }

    public void updateRemainingMoves() {
        remainingMovesLabel.setText("Remaining Moves: " + remainingMoves);
    }

    public void completePlayerMove() {
        if (checkWinningMove()) {
            playerScore++;
        }
        updateScorePlayer();
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

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
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

    public SinglePlayerPanel getSinglePlayerPanel() {
        return singlePlayerPanel;
    }

    public void setToolBoard(ToolBoard toolBoard) {
        this.toolBoard = toolBoard;
    }

    public void setToolDice(ToolDice toolDice) {
        this.toolDice = toolDice;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
