import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModeTwoPlayer extends JPanel {
    private ToolBoard toolBoard;
    private ToolDice toolDice;
    private JPanel bangDiem;
    JLabel player1Label, player2Label, timeLabel;
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
        JPanel panelPlayers = new JPanel(new GridLayout(2, 2));
        panelPlayers.add(player1Label);
        panelPlayers.add(player2Label);
        panelPlayers.add(scorePlayer1Label);
        panelPlayers.add(scorePlayer2Label);
        bangDiem = new JPanel(new BorderLayout());
        bangDiem.add(panelPlayers, BorderLayout.CENTER);
        bangDiem.add(timeLabel, BorderLayout.SOUTH);

        this.add(bangDiem);
        bangDiem.setBounds(300, 0, 200, 60);

        toolBoard = new ToolBoard();
        toolBoard.setBounds(0, 150, toolBoard.getPreferredSize().width, toolBoard.getPreferredSize().height);
        this.add(toolBoard);

        toolDice = new ToolDice();
        toolDice.setBounds(toolBoard.getPreferredSize().width + 20, 150,
                toolDice.getPreferredSize().width, toolDice.getPreferredSize().height);

        this.add(toolDice);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        ModeTwoPlayer modeTwoPlayer = new ModeTwoPlayer();
        frame.add(modeTwoPlayer);
        frame.setVisible(true);
    }

}
