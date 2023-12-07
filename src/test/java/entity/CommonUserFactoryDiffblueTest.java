package entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CommonUserFactoryDiffblueTest {
    /**
     * Method under test:
     * {@link CommonUserFactory#create(String, String, ArrayList, ArrayList)}
     */
    @Test
    void testCreate() {
        CommonUserFactory commonUserFactory = new CommonUserFactory();
        ArrayList<String> translationHistory = new ArrayList<>();
        User actualCreateResult = commonUserFactory.create("Name", "iloveyou", translationHistory, new ArrayList<>());
        assertEquals("Name", actualCreateResult.getName());
        assertEquals("iloveyou", actualCreateResult.getPassword());
        assertEquals(translationHistory, actualCreateResult.getFavorites());
        assertEquals(translationHistory, actualCreateResult.getTranslationHistory());
    }

    /**
     * Method under test:
     * {@link CommonUserFactory#create(String, String, ArrayList, ArrayList)}
     */
    @Test
    void testCreate2() {
        CommonUserFactory commonUserFactory = new CommonUserFactory();

        ArrayList<String> translationHistory = new ArrayList<>();
        translationHistory.add("foo");
        User actualCreateResult = commonUserFactory.create("Name", "iloveyou", translationHistory, new ArrayList<>());
        assertEquals("Name", actualCreateResult.getName());
        assertEquals("iloveyou", actualCreateResult.getPassword());
        assertEquals(1, actualCreateResult.getTranslationHistory().size());
        assertTrue(actualCreateResult.getFavorites().isEmpty());
    }

    /**
     * Method under test:
     * {@link CommonUserFactory#create(String, String, ArrayList, ArrayList)}
     */
    @Test
    void testCreate3() {
        CommonUserFactory commonUserFactory = new CommonUserFactory();

        ArrayList<String> translationHistory = new ArrayList<>();
        translationHistory.add("42");
        translationHistory.add("foo");
        User actualCreateResult = commonUserFactory.create("Name", "iloveyou", translationHistory, new ArrayList<>());
        assertEquals("Name", actualCreateResult.getName());
        assertEquals("iloveyou", actualCreateResult.getPassword());
        assertEquals(2, actualCreateResult.getTranslationHistory().size());
        assertTrue(actualCreateResult.getFavorites().isEmpty());
    }

    /**
     * Method under test:
     * {@link CommonUserFactory#create(String, String, ArrayList, ArrayList)}
     */
    @Test
    void testCreate4() {
        CommonUserFactory commonUserFactory = new CommonUserFactory();
        ArrayList<String> translationHistory = new ArrayList<>();

        ArrayList<String> favorites = new ArrayList<>();
        favorites.add("foo");
        User actualCreateResult = commonUserFactory.create("Name", "iloveyou", translationHistory, favorites);
        assertEquals("Name", actualCreateResult.getName());
        assertEquals("iloveyou", actualCreateResult.getPassword());
        assertEquals(1, actualCreateResult.getFavorites().size());
        assertEquals(translationHistory, actualCreateResult.getTranslationHistory());
    }

    /**
     * Method under test:
     * {@link CommonUserFactory#create(String, String, ArrayList, ArrayList)}
     */
    @Test
    void testCreate5() {
        CommonUserFactory commonUserFactory = new CommonUserFactory();
        ArrayList<String> translationHistory = new ArrayList<>();

        ArrayList<String> favorites = new ArrayList<>();
        favorites.add("42");
        favorites.add("foo");
        User actualCreateResult = commonUserFactory.create("Name", "iloveyou", translationHistory, favorites);
        assertEquals("Name", actualCreateResult.getName());
        assertEquals("iloveyou", actualCreateResult.getPassword());
        assertEquals(2, actualCreateResult.getFavorites().size());
        assertEquals(translationHistory, actualCreateResult.getTranslationHistory());
    }
}
