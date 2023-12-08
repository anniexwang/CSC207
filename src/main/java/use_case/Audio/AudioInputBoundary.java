package use_case.Audio;

/**
 * This interface represents the input boundary for the audio use case.
 * It provides a method to get the audio data.
 */
public interface AudioInputBoundary {

    /**
     * Returns the audio data.
     *
     * @return An instance of AudioInputData containing the audio data.
     */
    AudioInputData getAudioData();
}