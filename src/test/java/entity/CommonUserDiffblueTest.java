package entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CommonUserDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CommonUser#CommonUser(String, String, ArrayList, ArrayList)}
     *   <li>{@link CommonUser#setTranslationHistory(ArrayList)}
     *   <li>{@link CommonUser#getFavorites()}
     *   <li>{@link CommonUser#getName()}
     *   <li>{@link CommonUser#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ArrayList<String> translationHistory = new ArrayList<>();
        ArrayList<String> favorites = new ArrayList<>();
        CommonUser actualCommonUser = new CommonUser("Name", "iloveyou", translationHistory, favorites);
        actualCommonUser.setTranslationHistory(new ArrayList<>());
        ArrayList<String> actualFavorites = actualCommonUser.getFavorites();
        String actualName = actualCommonUser.getName();
        assertEquals("Name", actualName);
        assertEquals("iloveyou", actualCommonUser.getPassword());
        assertEquals(translationHistory, actualFavorites);
        assertSame(favorites, actualFavorites);
    }

    /**
     * Method under test: {@link CommonUser#getTranslationHistory()}
     */
    @Test
    void testGetTranslationHistory() {
        ArrayList<String> translationHistory = new ArrayList<>();
        assertTrue(
                (new CommonUser("Name", "iloveyou", translationHistory, new ArrayList<>())).getTranslationHistory().isEmpty());
    }

    /**
     * Method under test: {@link CommonUser#getTranslationHistory()}
     */
    @Test
    void testGetTranslationHistory2() {
        ArrayList<String> translationHistory = new ArrayList<>();
        translationHistory.add("foo");
        ArrayList<String> actualTranslationHistory = (new CommonUser("Name", "iloveyou", translationHistory,
                new ArrayList<>())).getTranslationHistory();
        assertEquals("foo", actualTranslationHistory.get(0));
        assertEquals(1, actualTranslationHistory.size());
        assertSame(translationHistory, actualTranslationHistory);
    }
}
