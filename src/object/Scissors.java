package object;

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
        Rock rock = new Rock();
        if (o.getClass().equals(this.getClass()))
            return 0;
        if (o.getClass().equals(rock.getClass()))
            return -1;
        return 1;
    }

}
