package data_access;

import use_case.Audio.AudioInputData;
import use_case.Audio.AudioUserDataAccessInterface;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AudioDataAccessObject implements AudioUserDataAccessInterface {
    private byte[] audioData;

    public AudioDataAccessObject(String filePath) throws IOException {
        this.audioData = loadAudioFile(filePath);
    }

    @Override
    public byte[] loadAudioFile(String filePath) throws IOException {
        return Files.readAllBytes(Paths.get(filePath));
    }

    public AudioInputData createAudioInputData() {
        return new AudioInputData(audioData);
    }
}