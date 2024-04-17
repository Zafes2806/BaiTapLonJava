import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModeTwoPlayer extends JPanel {
    private ToolBoard toolBoard;
    private ToolDice toolDice;
    JLabel player1Label, player2Label, timeLabel, infoLabel;
    JLabel scorePlayer1Label, scorePlayer2Label;
    private Timer timer;
    private int currentPlayer;
    private int player1 = 1;
    private int player2 = 2;
    private final int MAX_TIME = 30;
    private int remainingTime;

    ModeTwoPlayer() {
        setPreferredSize(new Dimension(700, 600));
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 15);
        toolBoard = new ToolBoard();
        toolDice = new ToolDice();
        player1Label = new JLabel("Player 1", JLabel.CENTER);
        player1Label.setFont(font);
        player2Label = new JLabel("Player 2", JLabel.CENTER);
        player2Label.setFont(font);
        scorePlayer1Label = new JLabel("0", JLabel.CENTER);
        scorePlayer1Label.setFont(font);
        scorePlayer2Label = new JLabel("0", JLabel.CENTER);
        scorePlayer2Label.setFont(font);
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(font);

        JPanel panelPlayers = new JPanel(new GridBagLayout());
        panelPlayers.setBounds(10, 251, 85, 150);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        // c.weighty = 1;
        panelPlayers.add(player1Label, c);
        c.gridy = 1;
        // c.weighty = 1;
        panelPlayers.add(scorePlayer1Label, c);
        c.gridy = 2;
        c.weighty = 0.1;
        panelPlayers.add(new JLabel(), c);
        c.gridy = 3;
        c.weighty = 0;
        panelPlayers.add(scorePlayer2Label, c);
        c.gridy = 4;
        // c.weighty = 1;
        panelPlayers.add(player2Label, c);
        this.add(panelPlayers);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoLabel = new JLabel("Player1's turn", JLabel.CENTER);
        timeLabel = new JLabel("", JLabel.CENTER);
        infoPanel.add(infoLabel);
        infoPanel.add(timeLabel);
        infoPanel.setBounds(286, 11, 206, 46);
        this.add(infoPanel);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(143, 79, 502, 502);
        this.add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(700, 213, 168, 224);

        this.add(toolDice);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(906, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ModeTwoPlayer modeTwoPlayer = new ModeTwoPlayer();
        frame.add(modeTwoPlayer);
        frame.setVisible(true);
    }

}
