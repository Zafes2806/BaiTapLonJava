import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockScissorsPaperListener implements ActionListener {
    private RockScissorsPaper rockScissorsPaper;

    public RockScissorsPaperListener(RockScissorsPaper rockScissorsPaper) {
        this.rockScissorsPaper = rockScissorsPaper;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(rockScissorsPaper.getjButton1().getText())) {
            rockScissorsPaper.remove(rockScissorsPaper.getjButton1());
            // rockScissorsPaper.remove(rockScissorsPaper.getjButton2());
            rockScissorsPaper.setLayout(new BorderLayout());
            // rockScissorsPaper.setVisible(false);
            ModeTwoPlayer modeTwoPlayer = new ModeTwoPlayer();
            rockScissorsPaper.setModeTwoPlayer(modeTwoPlayer);
            rockScissorsPaper.add(modeTwoPlayer);
            modeTwoPlayer.setFocusable(true);
            modeTwoPlayer.requestFocusInWindow();
            rockScissorsPaper.setVisible(true);
            // rockScissorsPaper.repaint();
        }
    }
}
