package interface_adapter.translation;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.table_preferences.TableViewModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.translate.TranslateInputBoundary;
import use_case.translate.TranslateInputData;

class TranslationControllerDiffblueTest {
    /**
     * Method under test:
     * {@link TranslationController#TranslationController(TranslateInputBoundary, TranslationPresenter, TranslationViewModel)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationController.translateUseCaseInteractor
        //     TranslationController.translationPresenter
        //     TranslationController.translationViewModel

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel());

    }

    /**
     * Method under test: {@link TranslationController#backToSignup()}
     */
    @Test
    void testBackToSignup() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationController.translateUseCaseInteractor
        //     TranslationController.translationPresenter
        //     TranslationController.translationViewModel

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .backToSignup();
    }

    /**
     * Method under test: {@link TranslationController#backToSignup()}
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
        //       at interface_adapter.translation.TranslationController.backToSignup(TranslationController.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(null, translationViewModel, signupViewModel,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .backToSignup();
    }

    /**
     * Method under test: {@link TranslationController#backToSignup()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBackToSignup3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getViewName()" because "this.signupViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.backToSignup(TranslationPresenter.java:33)
        //       at interface_adapter.translation.TranslationController.backToSignup(TranslationController.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel, null,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .backToSignup();
    }

    /**
     * Method under test: {@link TranslationController#goToHistory()}
     */
    @Test
    void testGoToHistory() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationController.translateUseCaseInteractor
        //     TranslationController.translationPresenter
        //     TranslationController.translationViewModel

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .goToHistory();
    }

    /**
     * Method under test: {@link TranslationController#goToHistory()}
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
        //       at interface_adapter.translation.TranslationController.goToHistory(TranslationController.java:24)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(null, translationViewModel, signupViewModel,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .goToHistory();
    }

    /**
     * Method under test: {@link TranslationController#goToHistory()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToHistory3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.table_preferences.TableViewModel.getViewName()" because "this.tableViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.goToHistory(TranslationPresenter.java:38)
        //       at interface_adapter.translation.TranslationController.goToHistory(TranslationController.java:24)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                new SignupViewModel(), null);

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .goToHistory();
    }

    /**
     * Method under test: {@link TranslationController#handleCancel()}
     */
    @Test
    void testHandleCancel() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TranslationController.translateUseCaseInteractor
        //     TranslationController.translationPresenter
        //     TranslationController.translationViewModel

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .handleCancel();
    }

    /**
     * Method under test: {@link TranslationController#handleCancel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleCancel2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.getState()" because "this.translationViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareCancelView(TranslationPresenter.java:44)
        //       at interface_adapter.translation.TranslationController.handleCancel(TranslationController.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, null, signupViewModel,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .handleCancel();
    }

    /**
     * Method under test: {@link TranslationController#handleCancel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleCancel3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationState.clearState()" because "translationState" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareCancelView(TranslationPresenter.java:45)
        //       at interface_adapter.translation.TranslationController.handleCancel(TranslationController.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.setState(null);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .handleCancel();
    }

    /**
     * Method under test: {@link TranslationController#execute(String)}
     */
    @Test
    void testExecute() {
        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        doNothing().when(translateUseCaseInteractor).execute(Mockito.<TranslateInputData>any());
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .execute("Phrase");
        verify(translateUseCaseInteractor).execute(Mockito.<TranslateInputData>any());
    }

    /**
     * Method under test: {@link TranslationController#execute(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.getState()" because "this.translationViewModel" is null
        //       at interface_adapter.translation.TranslationController.execute(TranslationController.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        doNothing().when(translateUseCaseInteractor).execute(Mockito.<TranslateInputData>any());
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationController(translateUseCaseInteractor,
                new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()), null))
                .execute("Phrase");
    }
}
