package sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import view.frame.GameScreen;

public class SoundTrack implements Runnable {
    private Thread thread;
    private GameScreen gameScreen;
    private Clip clip;
    private volatile boolean running;

    private String filePath;

    public SoundTrack(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        filePath = "resource/sounds/sound_track.wav";
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
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            while (running) {
                if (!gameScreen.isMusic())
                    stop();
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
