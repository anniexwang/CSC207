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
    @Test
    @Disabled("TODO: Complete this test")
    void testIsMuted2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.Audio.AudioInteractor.isMuted()" because "this.audioInteractor" is null
        //       at interface_adapter.Audio.AudioController.isMuted(AudioController.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        (new AudioController(null)).isMuted();
    }
}
