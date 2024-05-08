package view.object;

import java.awt.Image;

import javax.swing.ImageIcon;

import untils.ImagePaths;

public class Scissors extends Tool {
    public Scissors() {
        Image image = new ImageIcon(ImagePaths.SCISSORS).getImage();
        this.setIcon(new ImageIcon(image));
    }

    @Override
    public int compareTo(Tool o) {
        if (o instanceof Scissors)
            return 0;
        if (o instanceof Paper)
            return -1;
        return 1;
    }
}
