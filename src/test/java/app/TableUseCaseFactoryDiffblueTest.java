package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import data_access.FileTranslationHistoryDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import interface_adapter.table_preferences.TableViewModel;

import java.beans.PropertyChangeListener;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.table_preferences.TableUserDataAccessInterface;

class TableUseCaseFactoryDiffblueTest {
    /**
     * Method under test:
     * {@link TableUseCaseFactory#create(ViewManagerModel, TableViewModel, SelectLanguagesViewModel, HistoryViewModel, TableUserDataAccessInterface)}
     */
    @Test
    void testCreate() throws IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        assertEquals("Table Preferences View", TableUseCaseFactory.create(viewManagerModel, tableViewModel,
                selectLanguagesViewModel, historyViewModel, new FileTranslationHistoryDataAccessObject("Csv Path")).viewName);
    }

    /**
     * Method under test:
     * {@link TableUseCaseFactory#create(ViewManagerModel, TableViewModel, SelectLanguagesViewModel, HistoryViewModel, TableUserDataAccessInterface)}
     */
    @Test
    void testCreate2() throws IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        assertEquals("Table Preferences View", TableUseCaseFactory.create(viewManagerModel, tableViewModel,
                selectLanguagesViewModel, historyViewModel, new FileTranslationHistoryDataAccessObject("Csv Path")).viewName);
    }

    /**
     * Method under test:
     * {@link TableUseCaseFactory#create(ViewManagerModel, TableViewModel, SelectLanguagesViewModel, HistoryViewModel, TableUserDataAccessInterface)}
     */

}
