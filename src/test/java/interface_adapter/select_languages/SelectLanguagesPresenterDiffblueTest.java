package interface_adapter.select_languages;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.select_languages.SelectLanguagesOutputData;

class SelectLanguagesPresenterDiffblueTest {
    /**
     * Method under test:
     * {@link SelectLanguagesPresenter#SelectLanguagesPresenter(ViewManagerModel, SelectLanguagesViewModel, HistoryViewModel)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SelectLanguagesPresenter.historyViewModel
        //     SelectLanguagesPresenter.selectLanguagesViewModel
        //     SelectLanguagesPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        new SelectLanguagesPresenter(viewManagerModel, selectLanguagesViewModel, new HistoryViewModel());

    }

    /**
     * Method under test:
     * {@link SelectLanguagesPresenter#prepareSuccessView(SelectLanguagesOutputData)}
     */
    @Test
    void testPrepareSuccessView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SelectLanguagesPresenter.historyViewModel
        //     SelectLanguagesPresenter.selectLanguagesViewModel
        //     SelectLanguagesPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        SelectLanguagesPresenter selectLanguagesPresenter = new SelectLanguagesPresenter(viewManagerModel,
                selectLanguagesViewModel, new HistoryViewModel());
        selectLanguagesPresenter.prepareSuccessView(new SelectLanguagesOutputData(new String[]{"en"}));
    }

    /**
     * Method under test:
     * {@link SelectLanguagesPresenter#prepareSuccessView(SelectLanguagesOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.select_languages.SelectLanguagesPresenter.prepareSuccessView(SelectLanguagesPresenter.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        SelectLanguagesPresenter selectLanguagesPresenter = new SelectLanguagesPresenter(null, selectLanguagesViewModel,
                new HistoryViewModel());
        selectLanguagesPresenter.prepareSuccessView(new SelectLanguagesOutputData(new String[]{"en"}));
    }

    /**
     * Method under test:
     * {@link SelectLanguagesPresenter#prepareSuccessView(SelectLanguagesOutputData)}
     */
    @Test
    void testPrepareSuccessView3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        SelectLanguagesPresenter selectLanguagesPresenter = new SelectLanguagesPresenter(viewManagerModel,
                selectLanguagesViewModel, new HistoryViewModel());
        selectLanguagesPresenter.prepareSuccessView(new SelectLanguagesOutputData(new String[]{"en"}));
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test:
     * {@link SelectLanguagesPresenter#prepareSuccessView(SelectLanguagesOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.history.HistoryViewModel.getState()" because "this.historyViewModel" is null
        //       at interface_adapter.select_languages.SelectLanguagesPresenter.prepareSuccessView(SelectLanguagesPresenter.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SelectLanguagesPresenter selectLanguagesPresenter = new SelectLanguagesPresenter(viewManagerModel,
                new SelectLanguagesViewModel(), null);
        selectLanguagesPresenter.prepareSuccessView(new SelectLanguagesOutputData(new String[]{"en"}));
    }

    /**
     * Method under test: {@link SelectLanguagesPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SelectLanguagesPresenter.historyViewModel
        //     SelectLanguagesPresenter.selectLanguagesViewModel
        //     SelectLanguagesPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new SelectLanguagesPresenter(viewManagerModel, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link SelectLanguagesPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SelectLanguagesPresenter.historyViewModel
        //     SelectLanguagesPresenter.selectLanguagesViewModel
        //     SelectLanguagesPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new SelectLanguagesPresenter(viewManagerModel, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link SelectLanguagesPresenter#prepareFailView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareFailView3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.select_languages.SelectLanguagesViewModel.getState()" because "this.selectLanguagesViewModel" is null
        //       at interface_adapter.select_languages.SelectLanguagesPresenter.prepareFailView(SelectLanguagesPresenter.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        (new SelectLanguagesPresenter(viewManagerModel, null, new HistoryViewModel())).prepareFailView("An error occurred");
    }
}
