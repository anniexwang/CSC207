package use_case.Audio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AudioInteractorDiffblueTest {
    /**
     * Method under test: {@link AudioInteractor#AudioInteractor(AudioInputData)}
     */
    @Test
    void testConstructor() throws UnsupportedEncodingException {
        AudioInputData audioInputData = new AudioInputData("AXAXAXAX".getBytes("UTF-8"));
        AudioInteractor actualAudioInteractor = new AudioInteractor(audioInputData);
        assertFalse(actualAudioInteractor.isMuted());
        assertSame(audioInputData, actualAudioInteractor.getAudioData());
    }

    /**
     * Method under test: {@link AudioInteractor#AudioInteractor(AudioInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.Audio.AudioInputData.getAudioData()" because "this.audioInputData" is null
        //       at use_case.Audio.AudioInteractor.initializeAudioClip(AudioInteractor.java:19)
        //       at use_case.Audio.AudioInteractor.<init>(AudioInteractor.java:14)
        //   See https://diff.blue/R013 to resolve this issue.

        new AudioInteractor(null);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AudioInteractor#getAudioData()}
     *   <li>{@link AudioInteractor#isMuted()}
     * </ul>
     */
    @Test
    void testGetAudioData() throws UnsupportedEncodingException {
        AudioInputData audioInputData = new AudioInputData("AXAXAXAX".getBytes("UTF-8"));
        AudioInteractor audioInteractor = new AudioInteractor(audioInputData);
        AudioInputData actualAudioData = audioInteractor.getAudioData();
        assertFalse(audioInteractor.isMuted());
        assertSame(audioInputData, actualAudioData);
    }

    /**
     * Method under test: {@link AudioInteractor#play()}
     */
    @Test
    void testPlay() throws UnsupportedEncodingException {
        AudioInputData audioInputData = new AudioInputData("AXAXAXAX".getBytes("UTF-8"));
        AudioInteractor audioInteractor = new AudioInteractor(audioInputData);
        audioInteractor.play();
        assertFalse(audioInteractor.isMuted());
        assertSame(audioInputData, audioInteractor.getAudioData());
    }

    /**
     * Method under test: {@link AudioInteractor#pause()}
     */
    @Test
    void testPause() throws UnsupportedEncodingException {
        AudioInputData audioInputData = new AudioInputData("AXAXAXAX".getBytes("UTF-8"));
        AudioInteractor audioInteractor = new AudioInteractor(audioInputData);
        audioInteractor.pause();
        assertFalse(audioInteractor.isMuted());
        assertSame(audioInputData, audioInteractor.getAudioData());
    }

    /**
     * Method under test: {@link AudioInteractor#mute()}
     */
    @Test
    void testMute() throws UnsupportedEncodingException {
        AudioInputData audioInputData = new AudioInputData("AXAXAXAX".getBytes("UTF-8"));
        AudioInteractor audioInteractor = new AudioInteractor(audioInputData);
        audioInteractor.mute();
        assertFalse(audioInteractor.isMuted());
        assertSame(audioInputData, audioInteractor.getAudioData());
    }
}
