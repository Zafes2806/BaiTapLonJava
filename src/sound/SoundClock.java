package sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import view.dialog.SinglePlayerDialog;
import view.dialog.TwoPlayerDialog;
import view.frame.GameScreen;

public class SoundClock implements Runnable {
    private Thread thread;
    private JPanel panel;
    private Clip clip;
    private volatile boolean running;

    public boolean isRunning() {
        return running;
    }

    private String filePath;

    public SoundClock(JPanel panel) {
        this.panel = panel;
        filePath = "resource/sounds/sound_clock.wav";
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
        if (clip != null) {
            clip.stop();
            clip.close();
        }
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            while (running) {
                if (panel instanceof SinglePlayerDialog) {
                    SinglePlayerDialog singlePlayerDialog = (SinglePlayerDialog) panel;
                    GameScreen gameScreen = singlePlayerDialog.getSinglePlayerPanel().getGameScreen();
                    if (!gameScreen.isSound() || singlePlayerDialog.getRemainingTime() > 5
                            || singlePlayerDialog.getRemainingTime() < 0)
                        stop();
                } else if (panel instanceof TwoPlayerDialog) {
                    TwoPlayerDialog twoPlayerDialog = (TwoPlayerDialog) panel;
                    GameScreen gameScreen = twoPlayerDialog.getTwoPlayerPanel().getGameScreen();
                    if (!gameScreen.isSound() || twoPlayerDialog.getRemainingTime() > 5
                            || twoPlayerDialog.getRemainingTime() < 0)
                        stop();
                }
            }
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        } finally {
            if (clip != null) {
                clip.stop();
                clip.close();
            }
        }
    }
}
