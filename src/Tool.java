import javax.swing.JLabel;

public abstract class Tool extends JLabel implements Comparable<Tool> {
    public void changeTool(Tool other) {
        this.setIcon(other.getIcon());
    }
}
