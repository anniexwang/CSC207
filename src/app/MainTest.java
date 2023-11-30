package app;

import data_access.AudioDataAccessObject;
import data_access.FileUserDataAccessObject;
import interface_adapter.Audio.AudioController;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainTest {

    @Test
        void testCreateAudioControllerSuccess() {
            String audioFilePath = "src/power.wav";

            AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);

            assertNotNull(audioController, "AudioController should be created successfully");
        }
    void testCreateAudioControllerWithException() {
        String audioFilePath = "invalid/path/to/audio.wav"; // Assume this path leads to an exception

        AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);

        assertNull(audioController, "AudioController should be null on exception");
    }

    void testCreateAudioControllerFileNotFound() {
        String audioFilePath = "nonexistent/path/to/audio.wav";

        // Assuming AudioDataAccessObject throws a FileNotFoundException for nonexistent files
        AudioDataAccessObject mockAudioDAO = Mockito.mock(AudioDataAccessObject.class);
        when(mockAudioDAO.createAudioInputData()).thenThrow(new FileNotFoundException("File not found"));

        // Inject mock into the factory method, may require changes in the implementation
        AudioController audioController = AudioControllerFactory.createAudioController(audioFilePath);

        assertNull(audioController, "AudioController should be null for nonexistent file");
    }
    @Test
    void testCreateAudioController() {
        assertNull(AudioControllerFactory.createAudioController("saf"));
    }
}




