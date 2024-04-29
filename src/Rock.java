import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Rock extends Tool {

    Rock() {
        Image image = new ImageIcon("res/image/Rock.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(image));
    }

    @Override
    public int compareTo(Tool o) {
        Paper paper = new Paper();
        if (o.getClass().equals(this.getClass()))
            return 0;
        if (o.getClass().equals(paper.getClass()))
            return -1;
        return 1;
    }

}
