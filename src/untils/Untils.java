package untils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Untils {
    public static Font getFont(int size) {
        Font maitree = null;
        try {
            File maitreeFont = new File("resource/font/Maitree-Bold.ttf");
            maitree = Font.createFont(Font.TRUETYPE_FONT, maitreeFont).deriveFont(Font.BOLD, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return maitree;
    }

    public static JButton getButton(String imagePath1, String imagePath2) {
        JButton button = new JButton();
        Image image1 = new ImageIcon(imagePath1).getImage();
        Image image2 = new ImageIcon(imagePath2).getImage();
        button.setIcon(new ImageIcon(image1));
        button.setRolloverIcon(new ImageIcon(image2));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        return button;
    }
}
