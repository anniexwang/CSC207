package use_case.Audio;

import java.io.IOException;

/**
 * This interface represents the data access operations for the audio use case.
 * It provides a method to load audio data from a file.
 */
public interface AudioUserDataAccessInterface {
    /**
     * Loads audio data from a given file path.
     *
     * @param filePath The path to the audio file.
     * @return The audio file contents as a byte array.
     * @throws IOException If an I/O error occurs reading from the file.
     */
    byte[] loadAudioFile(String filePath) throws IOException;
}