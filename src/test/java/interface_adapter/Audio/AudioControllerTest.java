package interface_adapter.Audio;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.Audio.AudioInteractor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AudioControllerTest {
    @Test
    void testPlay() {
        AudioInteractor audioInteractor = Mockito.mock(AudioInteractor.class);
        AudioController audioController = new AudioController(audioInteractor);
        audioController.play();
        verify(audioInteractor).play();
    }

    @Test
    void testMute() {
        AudioInteractor audioInteractor = Mockito.mock(AudioInteractor.class);
        AudioController audioController = new AudioController(audioInteractor);
        audioController.mute();
        verify(audioInteractor).mute();
    }

    @Test
    void testIsMuted() {
        AudioInteractor audioInteractor = Mockito.mock(AudioInteractor.class);
        when(audioInteractor.isMuted()).thenReturn(true);
        AudioController audioController = new AudioController(audioInteractor);
        assertTrue(audioController.isMuted());

        when(audioInteractor.isMuted()).thenReturn(false);
        assertFalse(audioController.isMuted());
    }
}