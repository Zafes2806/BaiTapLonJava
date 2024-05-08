package view.object;

import java.awt.Image;

import javax.swing.ImageIcon;

import untils.ImagePaths;

public class Rock extends Tool {
    public Rock() {
        Image image = new ImageIcon(ImagePaths.ROCK).getImage();
        this.setIcon(new ImageIcon(image));
    }

    @Override
    public int compareTo(Tool o) {
        if (o instanceof Rock)
            return 0;
        if (o instanceof Paper)
            return -1;
        return 1;
    }

}
