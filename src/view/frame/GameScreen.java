package view.frame;

import javax.swing.JFrame;

import sound.SoundTrack;
import view.panel.MenuPanel;
import view.panel.SinglePlayerPanel;
import view.panel.TwoPlayerPanel;

public class GameScreen extends JFrame {
    private boolean music;
    private boolean sound;

    private SoundTrack soundTrack;

    public SoundTrack getSoundTrack() {
        return soundTrack;
    }

    private MenuPanel menuPanel;
    private SinglePlayerPanel singlePlayerPanel;
    private TwoPlayerPanel twoPlayerPanel;

    public GameScreen(boolean music, boolean sound) {
        this.sound = sound;
        this.music = music;
        setSize(1100, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPanel = new MenuPanel(this);
        menuPanel.setBounds(0, 0, MenuPanel.WIDTH, MenuPanel.HEIGHT);
        add(menuPanel);
        openMenuPanel();

        singlePlayerPanel = new SinglePlayerPanel(this);
        singlePlayerPanel.setBounds(0, 0, MenuPanel.WIDTH, MenuPanel.HEIGHT);
        add(singlePlayerPanel);

        twoPlayerPanel = new TwoPlayerPanel(this);
        twoPlayerPanel.setBounds(0, 0, TwoPlayerPanel.WIDTH, TwoPlayerPanel.HEIGHT);
        add(twoPlayerPanel);

        setLocationRelativeTo(null);
        setVisible(true);
        soundTrack = new SoundTrack(this);
        soundTrack.start();
        setResizable(false);
    }

    public void openMenuPanel() {
        menuPanel.open();
    }

    public void closeMenuPanel() {
        menuPanel.close();
    }

    public void openSinglePlayerPanel() {
        singlePlayerPanel.open();
    }

    public void closeSinglePlayerPanel() {
        singlePlayerPanel.close();
    }

    public void openTwoPlayerPanel() {
        twoPlayerPanel.open();
    }

    public void closeTwoPlayerPanel() {
        twoPlayerPanel.close();
    }

    public TwoPlayerPanel getTwoPlayerPanel() {
        return twoPlayerPanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public SinglePlayerPanel getSinglePlayerPanel() {
        return singlePlayerPanel;
    }

    public boolean isMusic() {
        return music;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public static void main(String[] args) {
        new GameScreen(false, false);
    }
}
