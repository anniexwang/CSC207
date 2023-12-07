package interface_adapter.table_preferences;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Disabled;
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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TablePresenter.historyViewModel
        //     TablePresenter.selectLanguagesViewModel
        //     TablePresenter.tableViewModel
        //     TablePresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TablePresenter.historyViewModel
        //     TablePresenter.selectLanguagesViewModel
        //     TablePresenter.tableViewModel
        //     TablePresenter.viewManagerModel

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
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.table_preferences.TablePresenter.prepareSuccessView(TablePresenter.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        TablePresenter tablePresenter = new TablePresenter(null, tableViewModel, selectLanguagesViewModel,
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
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.select_languages.SelectLanguagesViewModel.getState()" because "this.selectLanguagesViewModel" is null
        //       at interface_adapter.table_preferences.TablePresenter.prepareSuccessView(TablePresenter.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TableViewModel tableViewModel = new TableViewModel();
        TablePresenter tablePresenter = new TablePresenter(viewManagerModel, tableViewModel, null, new HistoryViewModel());
        tablePresenter.prepareSuccessView(new TableOutputData("Table Type", "Sort Type", true));
    }

    /**
     * Method under test: {@link TablePresenter#prepareSuccessView(TableOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.history.HistoryViewModel.getState()" because "this.historyViewModel" is null
        //       at interface_adapter.table_preferences.TablePresenter.prepareSuccessView(TablePresenter.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TableViewModel tableViewModel = new TableViewModel();
        TablePresenter tablePresenter = new TablePresenter(viewManagerModel, tableViewModel, new SelectLanguagesViewModel(),
                null);
        tablePresenter.prepareSuccessView(new TableOutputData("Table Type", "Sort Type", true));
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
     * Method under test: {@link TablePresenter#prepareSuccessView(TableOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.table_preferences.TableOutputData.getTableType()" because "response" is null
        //       at interface_adapter.table_preferences.TablePresenter.prepareSuccessView(TablePresenter.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareSuccessView(null);
    }

    /**
     * Method under test: {@link TablePresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TablePresenter.historyViewModel
        //     TablePresenter.selectLanguagesViewModel
        //     TablePresenter.tableViewModel
        //     TablePresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TablePresenter.historyViewModel
        //     TablePresenter.selectLanguagesViewModel
        //     TablePresenter.tableViewModel
        //     TablePresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TableViewModel tableViewModel = new TableViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link TablePresenter#prepareFailView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareFailView3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.table_preferences.TableViewModel.getState()" because "this.tableViewModel" is null
        //       at interface_adapter.table_preferences.TablePresenter.prepareFailView(TablePresenter.java:52)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new TablePresenter(viewManagerModel, null, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareFailView("An error occurred");
    }
}
