package use_case.Audio;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * This class is responsible for handling the audio functionality of the system.
 * It communicates with the AudioInputBoundary to perform operations such as playing, pausing, and muting the audio.
 */
public class AudioInteractor implements AudioInputBoundary {
    private AudioInputData audioInputData;
    private Clip audioClip;
    private boolean isMuted = false;

    /**
     * Constructor for the AudioInteractor class.
     *
     * @param audioInputData The AudioInputData instance containing the audio data.
     */
    public AudioInteractor(AudioInputData audioInputData) {
        this.audioInputData = audioInputData;
        initializeAudioClip();
    }

    /**
     * Initializes the audio clip.
     * It creates an AudioInputStream from the audio data and opens the audio clip.
     */
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

    /**
     * Returns the audio data.
     *
     * @return An instance of AudioInputData containing the audio data.
     */
    @Override
    public AudioInputData getAudioData() {
        return audioInputData;
    }

    /**
     * Plays the audio.
     * If the audio clip is already running, it stops the audio clip.
     * It then sets the frame position to 0 and starts the audio clip.
     */
    public void play() {
        if (audioClip != null) {
            if (audioClip.isRunning()) {
                audioClip.stop();
            }
            audioClip.setFramePosition(0);  // restart the audio clip from the beginning
            audioClip.start();
        }
    }

    /**
     * Pauses the audio.
     * If the audio clip is running, it stops the audio clip.
     */
    public void pause() {
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
        }
    }

    /**
     * Mutes the audio.
     * If the audio clip is not null, it toggles the mute status and sets the volume accordingly.
     */
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