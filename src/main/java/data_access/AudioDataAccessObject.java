package data_access;

import use_case.Audio.AudioInputData;
import use_case.Audio.AudioUserDataAccessInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class is responsible for loading audio data from a file.
 * It implements the AudioUserDataAccessInterface.
 */
public class AudioDataAccessObject implements AudioUserDataAccessInterface {
    private byte[] audioData;

    /**
     * Constructor for the AudioDataAccessObject.
     * It loads the audio data from the file at the given path.
     *
     * @param filePath The path to the audio file.
     * @throws IOException If an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
     */
    public AudioDataAccessObject(String filePath) throws IOException {
        this.audioData = loadAudioFile(filePath);
    }

    /**
     * Loads the audio data from the file at the given path.
     *
     * @param filePath The path to the audio file.
     * @return The audio data as a byte array.
     * @throws IOException If an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read.
     */
    @Override
    public byte[] loadAudioFile(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    /**
     * Creates an AudioInputData object with the loaded audio data.
     *
     * @return An AudioInputData object containing the audio data.
     */
    public AudioInputData createAudioInputData() {
        return new AudioInputData(audioData);
    }
}