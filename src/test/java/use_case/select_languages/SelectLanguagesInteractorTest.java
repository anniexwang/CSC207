package use_case.select_languages;

import data_access.FileTranslationHistoryDataAccessObject;
import interface_adapter.history.HistoryViewModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SelectLanguagesInteractorTest {

    @Test
    void successTest() throws IOException {
        String[] test = new String[]{"e","f"};
        SelectLanguagesInputData selectLanguagesInputData = new SelectLanguagesInputData(test);

        SelectLanguagesOutputBoundary selectLanguagesOutputBoundary = new SelectLanguagesOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectLanguagesOutputData response) {
                assertEquals(test, response.getLanguages());

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");

            }
        };

        SelectLanguagesUserDataAccessInterface selectLanguagesUserDataAccessInterface = new FileTranslationHistoryDataAccessObject("src/main/java/translations.csv");
        HistoryViewModel historyViewModel = new HistoryViewModel();
        SelectLanguagesInputBoundary selectLanguagesInputBoundary = new SelectLanguagesInteractor(selectLanguagesUserDataAccessInterface, selectLanguagesOutputBoundary, historyViewModel);
        selectLanguagesInputBoundary.execute(selectLanguagesInputData);
    }
    @Test
    void failureTest() throws IOException {
        String[] test = new String[]{"a"};
        SelectLanguagesInputData selectLanguagesInputData = new SelectLanguagesInputData(test);

        SelectLanguagesOutputBoundary selectLanguagesOutputBoundary = new SelectLanguagesOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectLanguagesOutputData response) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("language(s) not valid", error);
            }
        };
        SelectLanguagesUserDataAccessInterface selectLanguagesUserDataAccessInterface = new FileTranslationHistoryDataAccessObject("src/main/java/translations.csv");
        HistoryViewModel historyViewModel = new HistoryViewModel();
        SelectLanguagesInputBoundary selectLanguagesInputBoundary = new SelectLanguagesInteractor(selectLanguagesUserDataAccessInterface, selectLanguagesOutputBoundary, historyViewModel);
        selectLanguagesInputBoundary.execute(selectLanguagesInputData);
    }

    @Test
    void checkInputLanguages() {
        SelectLanguagesInteractor selectLanguagesInteractor = mock(SelectLanguagesInteractor.class);

        String[] testTrue = new String[]{"e","f"};
        String[] testFalse = new String[]{"a"};

        boolean actualTrue = selectLanguagesInteractor.checkInputLanguages(testTrue);
        boolean actualFalse = selectLanguagesInteractor.checkInputLanguages(testFalse);

        assertTrue(actualTrue);
        assertFalse(actualFalse);
    }
}