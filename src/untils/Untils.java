package untils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class Untils {
    public static Font getFont(int size) {
        Font maitree = null;
        try {
            File maitreeFont = new File("res/font/Maitree-Bold.ttf");
            maitree = Font.createFont(Font.TRUETYPE_FONT, maitreeFont).deriveFont(Font.BOLD, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return maitree;
    }
}
