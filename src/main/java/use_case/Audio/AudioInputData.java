package use_case.Audio;

/**
 * This class represents the input data for the audio use case.
 * It holds the audio data as a byte array.
 */
public class AudioInputData {
    private final byte[] audioData;

    /**
     * Constructor for AudioInputData with the audio data as a byte array.
     *
     * @param audioData The audio data as a byte array.
     */
    public AudioInputData(byte[] audioData) {
        this.audioData = audioData;
    }

    /**
     * Returns the audio data.
     *
     * @return The audio data as a byte array.
     */
    public byte[] getAudioData() {
        return audioData;
    }
}