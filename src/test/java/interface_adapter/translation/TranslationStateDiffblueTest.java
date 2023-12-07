package interface_adapter.translation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TranslationStateDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TranslationState#TranslationState()}
     *   <li>{@link TranslationState#setOriginal(String)}
     *   <li>{@link TranslationState#setOriginalError(String)}
     *   <li>{@link TranslationState#setTranslated(String)}
     *   <li>{@link TranslationState#setTranslatedError(String)}
     *   <li>{@link TranslationState#setUsername(String)}
     *   <li>{@link TranslationState#setUsernameError()}
     *   <li>{@link TranslationState#getOriginal()}
     *   <li>{@link TranslationState#getOriginalError()}
     *   <li>{@link TranslationState#getTranslated()}
     *   <li>{@link TranslationState#getTranslatedError()}
     *   <li>{@link TranslationState#getUsername()}
     *   <li>{@link TranslationState#getUsernameError()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TranslationState actualTranslationState = new TranslationState();
        actualTranslationState.setOriginal("Original");
        actualTranslationState.setOriginalError("An error occurred");
        actualTranslationState.setTranslated("Translated");
        actualTranslationState.setTranslatedError("An error occurred");
        actualTranslationState.setUsername("janedoe");
        actualTranslationState.setUsernameError();
        String actualOriginal = actualTranslationState.getOriginal();
        String actualOriginalError = actualTranslationState.getOriginalError();
        String actualTranslated = actualTranslationState.getTranslated();
        String actualTranslatedError = actualTranslationState.getTranslatedError();
        String actualUsername = actualTranslationState.getUsername();
        actualTranslationState.getUsernameError();
        assertEquals("An error occurred", actualOriginalError);
        assertEquals("An error occurred", actualTranslatedError);
        assertEquals("Original", actualOriginal);
        assertEquals("Translated", actualTranslated);
        assertEquals("janedoe", actualUsername);
    }

    /**
     * Method under test:
     * {@link TranslationState#TranslationState(TranslationState)}
     */
    @Test
    void testConstructor2() {
        TranslationState actualTranslationState = new TranslationState(new TranslationState());
        assertNull(actualTranslationState.getOriginalError());
        assertNull(actualTranslationState.getTranslatedError());
        assertNull(actualTranslationState.getUsernameError());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, actualTranslationState.getOriginal());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, actualTranslationState.getTranslated());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, actualTranslationState.getUsername());
    }

    /**
     * Method under test:
     * {@link TranslationState#TranslationState(TranslationState)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "original" because "copy" is null
        //       at interface_adapter.translation.TranslationState.<init>(TranslationState.java:15)
        //   See https://diff.blue/R013 to resolve this issue.

        new TranslationState(null);
    }

    /**
     * Method under test: {@link TranslationState#clearState()}
     */
    @Test
    void testClearState() {
        TranslationState translationState = new TranslationState();
        translationState.clearState();
        assertNull(translationState.getOriginalError());
        assertNull(translationState.getTranslatedError());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, translationState.getOriginal());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, translationState.getTranslated());
    }
}
