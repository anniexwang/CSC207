package use_case.translate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TranslateOutputDataDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TranslateOutputData#TranslateOutputData(String, boolean)}
     *   <li>{@link TranslateOutputData#getTranslated()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("Translated", (new TranslateOutputData("Translated", true)).getTranslated());
    }
}
