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
        Paper paper = new Paper();
        if (o.getClass().equals(this.getClass()))
            return 0;
        if (o.getClass().equals(paper.getClass()))
            return -1;
        return 1;
    }

}
