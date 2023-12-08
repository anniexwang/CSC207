package app;

import data_access.AudioDataAccessObject;
import interface_adapter.Audio.AudioController;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;

/**
 * Factory class for creating an instance of AudioController.
 * This class encapsulates the creation logic of AudioController,
 * isolating the client classes from the implementation details.
 */
public class AudioControllerFactory {

    /**
     * Creates an instance of AudioController.
     *
     * @param audioFilePath The path to the audio file.
     * @return An instance of AudioController, or null if an exception occurs.
     */
    public static AudioController createAudioController(String audioFilePath) {
        try {
            // Create an instance of AudioDataAccessObject with the provided audio file path
            AudioDataAccessObject audioDAO = new AudioDataAccessObject(audioFilePath);

            // Use the AudioDataAccessObject to create an instance of AudioInputData
            AudioInputData audioInputData = audioDAO.createAudioInputData();

            // Create an instance of AudioInteractor with the AudioInputData
            AudioInteractor audioInteractor = new AudioInteractor(audioInputData);

            // Create and return an instance of AudioController with the AudioInteractor
            return new AudioController(audioInteractor);
        } catch (Exception e) {
            // Print the stack trace for debugging purposes
            e.printStackTrace();

            // Return null if an exception occurs
            // Consider a better error handling strategy for production code
            return null;
        }
    }
}