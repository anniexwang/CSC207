package use_case.Audio;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

class AudioInputDataDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AudioInputData#AudioInputData(byte[])}
     *   <li>{@link AudioInputData#getAudioData()}
     * </ul>
     */
    @Test
    void testConstructor() throws UnsupportedEncodingException {
        byte[] audioData = "AXAXAXAX".getBytes("UTF-8");
        assertSame(audioData, (new AudioInputData(audioData)).getAudioData());
    }
}
