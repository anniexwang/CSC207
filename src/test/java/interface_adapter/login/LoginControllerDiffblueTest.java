package interface_adapter.login;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationViewModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

class LoginControllerDiffblueTest {
    /**
     * Method under test:
     * {@link LoginController#LoginController(LoginInputBoundary, LoginPresenter)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LoginController.loginPresenter
        //     LoginController.loginUseCaseInteractor

        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));

    }

    /**
     * Method under test: {@link LoginController#execute(String, String)}
     */
    @Test
    void testExecute() {
        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        doNothing().when(loginUseCaseInteractor).execute(Mockito.<LoginInputData>any());
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel())))
                .execute("janedoe", "iloveyou");
        verify(loginUseCaseInteractor).execute(Mockito.<LoginInputData>any());
    }

    /**
     * Method under test: {@link LoginController#goToSignUp()}
     */
    @Test
    void testGoToSignUp() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LoginController.loginPresenter
        //     LoginController.loginUseCaseInteractor

        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel())))
                .goToSignUp();
    }

    /**
     * Method under test: {@link LoginController#goToSignUp()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToSignUp2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.login.LoginPresenter.goToSignUp(LoginPresenter.java:50)
        //       at interface_adapter.login.LoginController.goToSignUp(LoginController.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginController(loginUseCaseInteractor,
                new LoginPresenter(null, translationViewModel, signupViewModel, new LoginViewModel()))).goToSignUp();
    }

    /**
     * Method under test: {@link LoginController#goToSignUp()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToSignUp3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getViewName()" because "this.signupViewModel" is null
        //       at interface_adapter.login.LoginPresenter.goToSignUp(LoginPresenter.java:50)
        //       at interface_adapter.login.LoginController.goToSignUp(LoginController.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        (new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, null, new LoginViewModel()))).goToSignUp();
    }
}
