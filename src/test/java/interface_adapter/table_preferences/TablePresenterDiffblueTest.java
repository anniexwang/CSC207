package interface_adapter.table_preferences;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.table_preferences.TableOutputData;

class TablePresenterDiffblueTest {
    /**
     * Method under test:
     * {@link TablePresenter#TablePresenter(ViewManagerModel, TableViewModel, SelectLanguagesViewModel, HistoryViewModel)}
     */
    @Test
    void testConstructor() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel, new HistoryViewModel());

    }

    /**
     * Method under test: {@link TablePresenter#prepareSuccessView(TableOutputData)}
     */
    @Test
    void testPrepareSuccessView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        TablePresenter tablePresenter = new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel,
                new HistoryViewModel());
        tablePresenter.prepareSuccessView(new TableOutputData("Table Type", "Sort Type", true));
    }

    /**
     * Method under test: {@link TablePresenter#prepareSuccessView(TableOutputData)}
     */
    @Test
    void testPrepareSuccessView3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        TablePresenter tablePresenter = new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel,
                new HistoryViewModel());
        tablePresenter.prepareSuccessView(new TableOutputData("Table Type", "Sort Type", true));
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link TablePresenter#prepareSuccessView(TableOutputData)}
     */
    @Test
    void testPrepareSuccessView6() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        TablePresenter tablePresenter = new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel,
                new HistoryViewModel());
        tablePresenter.prepareSuccessView(new TableOutputData("By Language", "Sort Type", true));
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link TablePresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link TablePresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView2() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareFailView("An error occurred");
    }
}
