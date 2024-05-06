package untils;

import javax.swing.*;
import java.awt.*;

public class LayeredPaneExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Tạo một JFrame
            JFrame frame = new JFrame("LayeredPane Example");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);


            // Tạo một JPanel với màu nền đỏ
            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.RED);
            panel1.setBounds(50, 50, 200, 200);

            // Tạo một JPanel với màu nền xanh lá cây
            JPanel panel2 = new JPanel();
            panel2.setBackground(Color.GREEN);
            panel2.setBounds(100, 100, 200, 200);

           

            // Thêm các thành phần vào JLayeredPane
            frame.add(panel1);
            frame.add(panel2);
          

            

            frame.setVisible(true);
        });
    }
}
