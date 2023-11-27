package interface_adapter.Audio;

import use_case.Audio.AudioInteractor;

public class AudioController {
    private AudioInteractor audioInteractor;

    public AudioController(AudioInteractor audioInteractor) {
        this.audioInteractor = audioInteractor;
    }

    public void play() {
        audioInteractor.play();
    }


    public void mute() {
        audioInteractor.mute();
    }

    public boolean isMuted() {
        return audioInteractor.isMuted();

}
}