package use_case.Audio;

import java.io.IOException;

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