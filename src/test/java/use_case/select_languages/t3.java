package use_case.select_languages;

import interface_adapter.history.HistoryViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class t3 {
    @Test
    void testExecute() {
        SelectLanguagesUserDataAccessInterface userDataAccessInterface = Mockito.mock(SelectLanguagesUserDataAccessInterface.class);
        SelectLanguagesOutputBoundary outputBoundary = Mockito.mock(SelectLanguagesOutputBoundary.class);
        HistoryViewModel historyViewModel = Mockito.mock(HistoryViewModel.class);
        when(historyViewModel.languageHistory(Mockito.any())).thenReturn(new String[]{"e", "f"});
        SelectLanguagesInteractor interactor = new SelectLanguagesInteractor(userDataAccessInterface, outputBoundary, historyViewModel);
        interactor.execute(new SelectLanguagesInputData(new String[]{"e", "f"}));
        verify(outputBoundary).prepareSuccessView(Mockito.any());
        interactor.execute(new SelectLanguagesInputData(new String[]{"a"}));
        verify(outputBoundary).prepareFailView("language(s) not valid");
    }

    @Test
    void testCheckInputLanguages() {
        SelectLanguagesUserDataAccessInterface userDataAccessInterface = Mockito.mock(SelectLanguagesUserDataAccessInterface.class);
        SelectLanguagesOutputBoundary outputBoundary = Mockito.mock(SelectLanguagesOutputBoundary.class);
        HistoryViewModel historyViewModel = Mockito.mock(HistoryViewModel.class);
        when(historyViewModel.languageHistory(Mockito.any())).thenReturn(new String[]{"e", "f"});
        SelectLanguagesInteractor interactor = new SelectLanguagesInteractor(userDataAccessInterface, outputBoundary, historyViewModel);
        assertTrue(interactor.checkInputLanguages(new String[]{"e", "f"}));
        assertFalse(interactor.checkInputLanguages(new String[]{"a"}));
    }
}