package interface_adapter.select_languages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SelectLanguagesStateDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SelectLanguagesState#SelectLanguagesState()}
     *   <li>{@link SelectLanguagesState#setLanguages(String[])}
     *   <li>{@link SelectLanguagesState#setLanguagesError(String)}
     *   <li>{@link SelectLanguagesState#getLanguages()}
     *   <li>{@link SelectLanguagesState#getLanguagesError()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SelectLanguagesState actualSelectLanguagesState = new SelectLanguagesState();
        String[] languages = new String[]{"en"};
        actualSelectLanguagesState.setLanguages(languages);
        actualSelectLanguagesState.setLanguagesError("en");
        String[] actualLanguages = actualSelectLanguagesState.getLanguages();
        assertEquals("en", actualSelectLanguagesState.getLanguagesError());
        assertSame(languages, actualLanguages);
    }

    /**
     * Method under test:
     * {@link SelectLanguagesState#SelectLanguagesState(SelectLanguagesState)}
     */
    @Test
    void testConstructor2() {
        SelectLanguagesState actualSelectLanguagesState = new SelectLanguagesState(new SelectLanguagesState());
        assertEquals("", actualSelectLanguagesState.getCurrentUsername());
        assertEquals("", actualSelectLanguagesState.getSortType());
        assertEquals("", actualSelectLanguagesState.getTableType());
        assertNull(actualSelectLanguagesState.getLanguages());
        assertNull(actualSelectLanguagesState.getLanguagesError());
    }

    /**
     * Method under test:
     * {@link SelectLanguagesState#SelectLanguagesState(SelectLanguagesState)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "languages" because "copy" is null
        //       at interface_adapter.select_languages.SelectLanguagesState.<init>(SelectLanguagesState.java:10)
        //   See https://diff.blue/R013 to resolve this issue.

        new SelectLanguagesState(null);
    }
}
