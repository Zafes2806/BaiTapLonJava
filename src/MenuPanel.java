import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 700);
        // frame.getContentPane().setBackground(Color.GREEN);
        System.out.println(frame.getHeight());
        System.out.println(frame.getContentPane().getWidth());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        Icon icon1 = new ImageIcon(
                new ImageIcon("image/Back1.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        Icon icon2 = new ImageIcon(
                new ImageIcon("image/Back2.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        JButton button = new JButton();
        button.setIcon(icon1);
        button.setRolloverIcon(icon2);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(600, 550, icon1.getIconWidth(), icon1.getIconHeight());
        ToolBoard toolBoard = new ToolBoard();
        frame.add(toolBoard);
        toolBoard.setBounds(0, 0, 700, 500);
        frame.add(button);
        frame.setVisible(true);
    }
}
