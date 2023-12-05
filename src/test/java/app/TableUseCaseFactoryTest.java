package app;

import static org.mockito.Mockito.mock;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import interface_adapter.table_preferences.TableViewModel;
import org.junit.jupiter.api.Test;
import use_case.table_preferences.TableUserDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class TableUseCaseFactoryTest {

    @Test
    void create() {
        ViewManagerModel viewManagerModel = mock(ViewManagerModel.class);
        TableViewModel tableViewModel = mock(TableViewModel.class);
        SelectLanguagesViewModel selectLanguagesViewModel = mock(SelectLanguagesViewModel.class);
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        TableUserDataAccessInterface userDataAccessObject = mock(TableUserDataAccessInterface.class);

        var result = TableUseCaseFactory.create(viewManagerModel, tableViewModel, selectLanguagesViewModel, historyViewModel, userDataAccessObject);

        assertNotNull(result);
    }
}