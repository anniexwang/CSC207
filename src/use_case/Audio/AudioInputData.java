package use_case.Audio;

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

    public byte[] getAudioData() {
        return audioData;
    }
}