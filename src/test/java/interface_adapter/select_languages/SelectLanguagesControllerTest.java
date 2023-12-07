package interface_adapter.select_languages;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.select_languages.SelectLanguagesInputBoundary;
import use_case.select_languages.SelectLanguagesInputData;

import static org.mockito.Mockito.verify;

class SelectLanguagesControllerTest {
    @Test
    void testExecute() {
        SelectLanguagesInputBoundary selectLanguagesInputBoundary = Mockito.mock(SelectLanguagesInputBoundary.class);
        SelectLanguagesController selectLanguagesController = new SelectLanguagesController(selectLanguagesInputBoundary);
        String[] languages = {"English", "Spanish"};
        selectLanguagesController.execute(languages);
        verify(selectLanguagesInputBoundary).execute(Mockito.any(SelectLanguagesInputData.class));
    }
}