package use_case.Audio;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AudioInteractor implements AudioInputBoundary {
    private AudioInputData audioInputData;
    private Clip audioClip;
    private boolean isMuted = false;

    public AudioInteractor(AudioInputData audioInputData) {
        this.audioInputData = audioInputData;
        initializeAudioClip();
    }

    private void initializeAudioClip() {
        try {
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(audioInputData.getAudioData());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(byteInputStream);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    @Override
    public AudioInputData getAudioData() {
        return audioInputData;
    }

    public void play() {
        if (audioClip != null) {
            if (audioClip.isRunning()) {
                audioClip.stop();
            }
            audioClip.setFramePosition(0);  // restart the audio clip from the beginning
            audioClip.start();
        }
    }

    public void pause() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
        }
    }

    public void mute() {
        if (audioClip != null) {
            isMuted = !isMuted;
            FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(isMuted ? volumeControl.getMinimum() : volumeControl.getMaximum());
        }

    }
    /**
     * Returns the current mute status.
     *
     * @return True if muted, false otherwise.
     */
    public boolean isMuted() {
        return isMuted;
    }
}