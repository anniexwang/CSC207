package app;

import static org.mockito.Mockito.mock;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import org.junit.jupiter.api.Test;
import use_case.select_languages.SelectLanguagesUserDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class SelectLanguagesUseCaseFactoryTest {

    @Test
    void create() {
        ViewManagerModel viewManagerModel = mock(ViewManagerModel.class);
        SelectLanguagesViewModel selectLanguagesViewModel = mock(SelectLanguagesViewModel.class);
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        SelectLanguagesUserDataAccessInterface selectLanguagesUserDataAccessInterface = mock(SelectLanguagesUserDataAccessInterface.class);

        var result = SelectLanguagesUseCaseFactory.create(viewManagerModel, selectLanguagesViewModel, historyViewModel, selectLanguagesUserDataAccessInterface);

        assertNotNull(result);
    }
}