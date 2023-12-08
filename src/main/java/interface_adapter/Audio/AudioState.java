package interface_adapter.Audio;

/**
 * Represents the current state of the audio system.
 * This class is used to manage and track the state of the audio system, specifically whether the audio is currently muted or not.
 */
public class AudioState {
    private boolean isMuted;

    /**
     * Constructor for the AudioState class.
     * Initializes the audio state as not muted.
     */
    public AudioState() {
        this.isMuted = false;  // Initialize with audio not muted
    }

    /**
     * Checks if the audio is currently muted.
     *
     * @return true if audio is muted, false otherwise.
     */
    public boolean isMuted() {
        return isMuted;
    }

    /**
     * Sets the mute state of the audio.
     *
     * @param muted true to mute the audio, false to unmute.
     */
    public void setMuted(boolean muted) {
        isMuted = muted;
    }

}