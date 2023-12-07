package use_case.select_languages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import data_access.FileTranslationHistoryDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesPresenter;
import interface_adapter.select_languages.SelectLanguagesViewModel;

import java.beans.PropertyChangeListener;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class SelectLanguagesInteractorDiffblueTest {
    /**
     * Method under test:
     * {@link SelectLanguagesInteractor#SelectLanguagesInteractor(SelectLanguagesUserDataAccessInterface, SelectLanguagesOutputBoundary, HistoryViewModel)}
     */
    @Test
    void testConstructor() throws IOException {
        FileTranslationHistoryDataAccessObject userSelectLanguagesDataAccessInterface = new FileTranslationHistoryDataAccessObject(
                "Csv Path");
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        SelectLanguagesPresenter selectLanguagesOutputBoundary = new SelectLanguagesPresenter(viewManagerModel,
                selectLanguagesViewModel, new HistoryViewModel());

        SelectLanguagesInteractor actualSelectLanguagesInteractor = new SelectLanguagesInteractor(
                userSelectLanguagesDataAccessInterface, selectLanguagesOutputBoundary, new HistoryViewModel());

        assertTrue(actualSelectLanguagesInteractor.userDataAccessObject instanceof FileTranslationHistoryDataAccessObject);
        assertTrue(actualSelectLanguagesInteractor.languagesPresenter instanceof SelectLanguagesPresenter);
        assertEquals("History View", actualSelectLanguagesInteractor.historyViewModel.TITLE_LABEL);
    }

    /**
     * Method under test:
     * {@link SelectLanguagesInteractor#SelectLanguagesInteractor(SelectLanguagesUserDataAccessInterface, SelectLanguagesOutputBoundary, HistoryViewModel)}
     */
    @Test
    void testConstructor2() throws IOException {
        FileTranslationHistoryDataAccessObject userSelectLanguagesDataAccessInterface = new FileTranslationHistoryDataAccessObject(
                "Csv Path");

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        SelectLanguagesPresenter selectLanguagesOutputBoundary = new SelectLanguagesPresenter(viewManagerModel,
                selectLanguagesViewModel, new HistoryViewModel());

        SelectLanguagesInteractor actualSelectLanguagesInteractor = new SelectLanguagesInteractor(
                userSelectLanguagesDataAccessInterface, selectLanguagesOutputBoundary, new HistoryViewModel());

        assertTrue(actualSelectLanguagesInteractor.userDataAccessObject instanceof FileTranslationHistoryDataAccessObject);
        assertTrue(actualSelectLanguagesInteractor.languagesPresenter instanceof SelectLanguagesPresenter);
        assertEquals("History View", actualSelectLanguagesInteractor.historyViewModel.TITLE_LABEL);
    }
}
