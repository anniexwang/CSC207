package interface_adapter.Audio;

/**
 * Represents the current state of the audio system.
 */
public class AudioState {
    private boolean isMuted;

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

    // You can add more fields and methods here to represent other aspects
    // of the audio system's state, such as volume level, current track, etc.
}