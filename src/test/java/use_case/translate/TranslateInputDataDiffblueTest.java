package use_case.translate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TranslateInputDataDiffblueTest {
    /**
     * Method under test:
     * {@link TranslateInputData#TranslateInputData(String, String)}
     */
    @Test
    void testConstructor() {
        TranslateInputData actualTranslateInputData = new TranslateInputData("Original", "janedoe");

        assertEquals("Original", actualTranslateInputData.getOriginal());
        assertEquals("en", actualTranslateInputData.getOriginalLang());
        assertEquals("janedoe", actualTranslateInputData.getUsername());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TranslateInputData#getOriginal()}
     *   <li>{@link TranslateInputData#getOriginalLang()}
     *   <li>{@link TranslateInputData#getUsername()}
     * </ul>
     */
    @Test
    void testGetOriginal() {
        TranslateInputData translateInputData = new TranslateInputData("Original", "janedoe");
        String actualOriginal = translateInputData.getOriginal();
        String actualOriginalLang = translateInputData.getOriginalLang();
        assertEquals("Original", actualOriginal);
        assertEquals("en", actualOriginalLang);
        assertEquals("janedoe", translateInputData.getUsername());
    }
}
