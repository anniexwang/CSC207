package interface_adapter.Audio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudioStateTest {
    @Test
    void testIsMuted() {
        AudioState audioState = new AudioState();
        assertFalse(audioState.isMuted());
        audioState.setMuted(true);
        assertTrue(audioState.isMuted());
    }

    @Test
    void testSetMuted() {
        AudioState audioState = new AudioState();
        audioState.setMuted(true);
        assertTrue(audioState.isMuted());
        audioState.setMuted(false);
        assertFalse(audioState.isMuted());
    }
}