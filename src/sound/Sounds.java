package sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {

    private static void playSound(String soundPath) {
        try {
            AudioInputStream input = AudioSystem.getAudioInputStream(new File(soundPath).getAbsoluteFile());
            Clip c = AudioSystem.getClip();
            c.open(input);
            c.start();

        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static void clickButtonSound() {
        playSound("resource/sounds/sound_click_button.wav");

    }

    public static void moveSound() {
        playSound("resource/sounds/sound_move.wav");

    }

}
