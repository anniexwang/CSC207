package interface_adapter.translation;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.table_preferences.TableViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TranslationPresenterDiffblueTest {
    /**
     * Method under test:
     * {@link TranslationPresenter#TranslationPresenter(ViewManagerModel, TranslationViewModel, SignupViewModel, TableViewModel)}
     */
    @Test
    void testConstructor() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel());

    }

    /**
     * Method under test: {@link TranslationPresenter#prepareSuccessView(String)}
     */
    @Test
    void testPrepareSuccessView() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareSuccessView("Response");
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareSuccessView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView2() {

        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(null, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareSuccessView("Response");
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareSuccessView(String)}
     */
    @Test
    void testPrepareSuccessView3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareSuccessView("Response");
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareSuccessView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView4() {

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, null, signupViewModel, new TableViewModel()))
                .prepareSuccessView("Response");
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareSuccessView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView5() {


        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);

        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.setState(null);
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareSuccessView("Response");
    }

    /**
     * Method under test: {@link TranslationPresenter#backToSignup()}
     */
    @Test
    void testBackToSignup() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .backToSignup();
    }

    /**
     * Method under test: {@link TranslationPresenter#backToSignup()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBackToSignup2() {


        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(null, translationViewModel, signupViewModel, new TableViewModel())).backToSignup();
    }

    /**
     * Method under test: {@link TranslationPresenter#backToSignup()}
     */
    @Test
    void testBackToSignup3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .backToSignup();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link TranslationPresenter#backToSignup()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBackToSignup4() {


        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, null, new TableViewModel())).backToSignup();
    }

    /**
     * Method under test: {@link TranslationPresenter#goToHistory()}
     */
    @Test
    void testGoToHistory() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .goToHistory();
    }

    /**
     * Method under test: {@link TranslationPresenter#goToHistory()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToHistory2() {

        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(null, translationViewModel, signupViewModel, new TableViewModel())).goToHistory();
    }

    /**
     * Method under test: {@link TranslationPresenter#goToHistory()}
     */
    @Test
    void testGoToHistory3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .goToHistory();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link TranslationPresenter#goToHistory()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToHistory4() {


        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, new SignupViewModel(), null)).goToHistory();
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareCancelView()}
     */
    @Test
    void testPrepareCancelView() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareCancelView();
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareCancelView()}
     */
    @Test
    void testPrepareCancelView2() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareCancelView();
    }



    /**
     * Method under test: {@link TranslationPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView2() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareFailView("An error occurred");
    }


}
