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


}
