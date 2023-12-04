

import app.AudioControllerFactory;
import interface_adapter.Audio.AudioController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AudioTest {

    @Test
    void testCreateAudioControllerSuccess() {
        // Provide a valid audio file path
        String audioFilePath = "src/main/java/power.wav"; // Replace with a valid path in your test environment

        AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);

        assertNotNull(audioController, "AudioController should be created successfully");
    }
    @Test
    void testCreateAudioControllerWithException() {
        // Provide an invalid file path to trigger an exception
        String audioFilePath = "invalid/path/to/audio.wav";

        AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);

        assertNull(audioController, "AudioController should be null on exception");
    }
}
