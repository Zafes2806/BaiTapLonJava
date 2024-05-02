package view.dialog;

import javax.swing.*;
import java.awt.*;

public class LayeredPaneExample {
    public static void main(String[] args) {
        // Create a JFrame (the main window for the application).
        JFrame frame = new JFrame("JLayeredPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        // Create a JLayeredPane to manage the layering of components.
        // Add the JLayeredPane to the JFrame.

        // Create three colored panels to add to the layered pane.
        JPanel panel1 = createColoredPanel(Color.RED, 100, 100, 200, 200);
        frame.add(panel1);
        JPanel panel2 = createColoredPanel(Color.GREEN, 150, 150, 200, 200);
        // JPanel panel3 = createColoredPanel(Color.BLUE, 200, 200, 200, 200);

        // Add the panels to the layered pane with different layer values.
        // The layers determine the stacking order of the panels.
        frame.add(panel2);
        // frame.add(panel3);

        frame.setVisible(true); // Make the JFrame visible.
    }

    private static JPanel createColoredPanel(Color color, int x, int y, int width, int height) {
        // Create a colored JPanel with specified color and position.
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBounds(x, y, width, height);
        return panel;
    }
}