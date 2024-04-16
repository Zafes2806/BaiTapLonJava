import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main extends JFrame {

    public ToolDice toolDice;
    public ToolBoard toolsBoard;

    Main() {
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        toolDice = new ToolDice();
        toolsBoard = new ToolBoard();
        this.add(toolDice);
        this.add(toolsBoard);

        toolDice.setBounds(510, 169, toolDice.getToolDiceWidth(), toolDice.getToolDiceHeight());
        toolsBoard.setBounds(0, 0, toolsBoard.getPreferredDimension().width, toolsBoard.getPreferredDimension().height);
        // Thêm trình nghe sự kiện phím cho toolDice
        toolDice.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Xử lý khi phím được nhấn trong toolDice
                System.out.println("Phím được nhấn trong toolDice");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Xử lý khi phím được thả ra trong toolDice
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Xử lý khi một phím được gõ (pressed và released) trong toolDice
            }
        });
        KeyListener keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        toolDice.moveLeft();
                        toolsBoard.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        toolDice.moveRight();
                        toolsBoard.moveRight();
                        break;
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        toolDice.moveUp();
                        toolsBoard.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        toolDice.moveDown();
                        toolsBoard.moveDown();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        };

        // Thêm trình nghe sự kiện phím cho toolsBoard
        this.addKeyListener(keyListener);
        setVisible(true);
    }
}