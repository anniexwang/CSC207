package interface_adapter.Audio;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;

class AudioControllerDiffblueTest {
    /**
     * Method under test: {@link AudioController#isMuted()}
     */
    @Test
    void testIsMuted() throws UnsupportedEncodingException {
        assertFalse((new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))))).isMuted());
    }

    /**
     * Method under test: {@link AudioController#isMuted()}
     */
}
