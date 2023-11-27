package view;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class AudioManager {
    private Clip audioClip;
    private boolean isMuted = false;

    // List to hold mute state change listeners


    public AudioManager(String audioFilePath) {
        try {
            InputStream audioStream = Objects.requireNonNull(getClass().getResourceAsStream(audioFilePath));
            byte[] audioBytes = toByteArray(audioStream);
            InputStream byteArrayInputStream = new ByteArrayInputStream(audioBytes);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(byteArrayInputStream);

            audioClip = AudioSystem.getClip();
            audioClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void startBackgroundMusic() {
        if (audioClip != null) {
            audioClip.start();
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void toggleMute() {
        if (audioClip != null) {
            isMuted = !isMuted;
            FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(isMuted ? gainControl.getMinimum() : gainControl.getMaximum());
        }
    }

    public boolean isMuted() {
        return isMuted;
    }

    public String getMuteButtonText() {
        return isMuted ? "Unmute" : "Mute";
    }

    public void stopBackgroundMusic() {
        if (audioClip != null) {
            audioClip.stop();
        }
    }

    // Helper method to convert InputStream to byte array
    private byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        return out.toByteArray();
    }
}
