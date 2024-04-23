import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RockScissorsPaper extends JFrame {
    private ModeTwoPlayer modeTwoPlayer;

    private JButton jButton1, jButton2;

    public ModeTwoPlayer getModeTwoPlayer() {
        return modeTwoPlayer;
    }

    public void setModeTwoPlayer(ModeTwoPlayer modeTwoPlayer) {
        this.modeTwoPlayer = modeTwoPlayer;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    RockScissorsPaper() {
        this.setSize(1000, 1000);
        this.setLayout(new GridLayout(2, 1, 20, 10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        RockScissorsPaperListener rockScissorsPaperListener = new RockScissorsPaperListener(this);

        jButton1 = new JButton("Button1");
        jButton2 = new JButton("Button2");
        this.add(jButton1);
        // this.add(jButton2);
        // ModeTwoPlayer modeTwoPlayer = new ModeTwoPlayer();
        // this.modeTwoPlayer = modeTwoPlayer;
        // this.add(modeTwoPlayer);
        // modeTwoPlayer.setFocusable(true);

        jButton1.addActionListener(rockScissorsPaperListener);
        jButton2.addActionListener(rockScissorsPaperListener);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RockScissorsPaper();
    }
}
