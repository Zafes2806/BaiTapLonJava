import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private JLabel infoLabel, timeLabel;
    private JButton playAgainButton; // Thêm nút "Play Again"
    private Timer timer;
    private int currentPlayer;
    private final int X = 1;
    private final int O = 2;
    private final int SIZE = 3;
    private final int MAX_TIME = 10; // Thời gian tối đa cho mỗi lượt chơi (giây)
    private int remainingTime;

    public TicTacToeGame() {
        setTitle("Tic Tac Toe");
        setSize(300, 400); // Tăng kích thước để làm chỗ cho nút "Play Again"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buttons = new JButton[SIZE][SIZE];
        JPanel boardPanel = new JPanel(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }

        infoLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
        timeLabel = new JLabel("", SwingConstants.CENTER); // Label hiển thị thời gian
        playAgainButton = new JButton("Play Again"); // Nút "Play Again"
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1)); // Thêm bottomPanel để chứa timeLabel và playAgainButton
        bottomPanel.add(infoLabel);
        bottomPanel.add(timeLabel);
        bottomPanel.add(playAgainButton);

        add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime == 0) {
                    remainingTime = MAX_TIME;
                    switchPlayer();
                }
                updateTimeLabel();
            }
        });
        currentPlayer = X; // Bắt đầu với người chơi X
        remainingTime = MAX_TIME;
        timer.start();
        updateTimeLabel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (!button.getText().isEmpty()) {
            return;
        }

        button.setText(currentPlayer == X ? "X" : "O");
        remainingTime = MAX_TIME; // Reset thời gian cho lượt chơi mới
        if (checkWin())
            return;
        switchPlayer();
        updateTimeLabel();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == X) ? O : X;
        infoLabel.setText("Player " + (currentPlayer == X ? "X" : "O") + "'s turn");
    }

    private void updateTimeLabel() {
        timeLabel.setText("Time: " + remainingTime + "s");
    }

    private boolean checkWin() {
        // Kiểm tra hàng và cột
        for (int i = 0; i < SIZE; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText())
                    && buttons[i][0].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().isEmpty()) {
                endGame(buttons[i][0].getText());
                return true;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText())
                    && buttons[0][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().isEmpty()) {
                endGame(buttons[0][i].getText());
                return true;
            }
        }
        // Kiểm tra đường chéo
        if (buttons[0][0].getText().equals(buttons[1][1].getText())
                && buttons[0][0].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().isEmpty()) {
            endGame(buttons[0][0].getText());
            return true;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText())
                && buttons[0][2].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().isEmpty()) {
            endGame(buttons[0][2].getText());
            return true;
        }
        // Kiểm tra hòa
        boolean draw = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            endGame("draw");
        }
        return false;
    }

    private void endGame(String winner) {
        timer.stop();
        if (winner.equals("draw")) {
            infoLabel.setText("It's a draw!");
        } else {
            infoLabel.setText("Player " + winner + " wins!");
        }
        // Disable all buttons after game ends
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void resetGame() {
        timer.stop();
        currentPlayer = X;
        remainingTime = MAX_TIME;
        infoLabel.setText("Player X's turn");
        timeLabel.setText("Time: " + remainingTime + "s");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGame().setVisible(true);
            }
        });
    }
}
