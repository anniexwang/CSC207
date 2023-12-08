package interface_adapter.Audio;

import use_case.Audio.AudioInteractor;

/**
 * This class is responsible for controlling the audio functionality of the system.
 * It communicates with the AudioInteractor to perform operations such as play, mute, and check if the audio is muted.
 */
public class AudioController {
    private AudioInteractor audioInteractor;

    /**
     * Constructor for the AudioController class.
     *
     * @param audioInteractor The AudioInteractor instance.
     */
    public AudioController(AudioInteractor audioInteractor) {
        this.audioInteractor = audioInteractor;
    }

    /**
     * Plays the audio.
     * It calls the play method of the AudioInteractor.
     */
    public void play() {
        audioInteractor.play();
    }

    /**
     * Mutes the audio.
     * It calls the mute method of the AudioInteractor.
     */
    public void mute() {
        audioInteractor.mute();
    }

    /**
     * Checks if the audio is muted.
     * It calls the isMuted method of the AudioInteractor.
     *
     * @return True if the audio is muted, false otherwise.
     */
    public boolean isMuted() {
        return audioInteractor.isMuted();
    }
}