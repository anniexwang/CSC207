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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareSuccessView(TranslationPresenter.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.getState()" because "this.translationViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareSuccessView(TranslationPresenter.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationState.setTranslated(String)" because "translationState" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareSuccessView(TranslationPresenter.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.translation.TranslationPresenter.backToSignup(TranslationPresenter.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getViewName()" because "this.signupViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.backToSignup(TranslationPresenter.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.translation.TranslationPresenter.goToHistory(TranslationPresenter.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.table_preferences.TableViewModel.getViewName()" because "this.tableViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.goToHistory(TranslationPresenter.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareCancelView();
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareCancelView()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareCancelView3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.getState()" because "this.translationViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareCancelView(TranslationPresenter.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, null, signupViewModel, new TableViewModel())).prepareCancelView();
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationPresenter.signupViewModel
        //     TranslationPresenter.tableViewModel
        //     TranslationPresenter.translationViewModel
        //     TranslationPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link TranslationPresenter#prepareFailView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareFailView3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.getState()" because "this.translationViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareFailView(TranslationPresenter.java:51)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationPresenter(viewManagerModel, null, signupViewModel, new TableViewModel()))
                .prepareFailView("An error occurred");
    }
}
