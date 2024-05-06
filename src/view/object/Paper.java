package view.object;

import java.awt.Image;

import javax.swing.ImageIcon;

import untils.ImagePaths;

public class Paper extends Tool {

    public Paper() {
        Image image = new ImageIcon(ImagePaths.PAPER).getImage();
        this.setIcon(new ImageIcon(image));
    }

    @Override
    public int compareTo(Tool o) {
        Rock rock = new Rock();
        if (o.getClass().equals(this.getClass()))
            return 0;
        if (o.getClass().equals(rock.getClass()))
            return 1;
        return -1;
    }

}
