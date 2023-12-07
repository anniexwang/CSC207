package use_case.select_languages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectLanguagesOutputDataTest {
    @Test
    void testGetLanguages() {
        String[] languages = {"English", "Spanish"};
        SelectLanguagesOutputData selectLanguagesOutputData = new SelectLanguagesOutputData(languages);
        assertArrayEquals(languages, selectLanguagesOutputData.getLanguages());
    }
}