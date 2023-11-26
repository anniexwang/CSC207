package app;

import data_access.AudioDataAccessObject;
import interface_adapter.Audio.AudioController;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;

public class AudioControllerFactory {

    public static AudioController createAudioController(String audioFilePath) {
        try {
            AudioDataAccessObject audioDAO = new AudioDataAccessObject(audioFilePath);
            AudioInputData audioInputData = audioDAO.createAudioInputData();

            AudioInteractor audioInteractor = new AudioInteractor(audioInputData);
            return new AudioController(audioInteractor);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions
            return null; // or handle it another way
        }
    }
}