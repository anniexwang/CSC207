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
     * Method under test: {@link SelectLanguagesPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {


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


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        (new SelectLanguagesPresenter(viewManagerModel, selectLanguagesViewModel, new HistoryViewModel()))
                .prepareFailView("An error occurred");
    }

}
