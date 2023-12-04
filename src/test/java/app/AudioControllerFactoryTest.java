package app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import interface_adapter.Audio.AudioController;
import org.junit.jupiter.api.Test;

class AudioControllerFactoryTest {
    /**
     * Method under test:
     * {@link AudioControllerFactory#createAudioController(String)}
     */
    @Test
    void testCreateAudioController() {
        assertNull(AudioControllerFactory.createAudioController("/directory/foo.txt"));
    }

    @Test
    public void testCreateAudioControllerWithValidFilePath() {
        String audioFilePath = "src/main/java/power.wav";
        AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);
        assertNotNull(audioController, "AudioController should not be null when provided with a valid file path.");
    }

    @Test
    public void testCreateAudioControllerWithInvalidFilePath() {
        String audioFilePath = "invalid_audio_file.wav";
        AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);
        assertNull(audioController, "AudioController should be null when provided with an invalid file path.");
    }

    @Test
    public void testCreateAudioControllerWithNullFilePath() {
        String audioFilePath = null;
        AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);
        assertNull(audioController, "AudioController should be null when provided with a null file path.");
    }

    }