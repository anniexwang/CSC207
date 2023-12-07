package interface_adapter.signup;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

class SignupControllerDiffblueTest {
    /**
     * Method under test:
     * {@link SignupController#SignupController(SignupInputBoundary, SignupPresenter)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupController.signupPresenter
        //     SignupController.userSignupUseCaseInteractor

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

    }

    /**
     * Method under test: {@link SignupController#handleCancel()}
     */
    @Test
    void testHandleCancel() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()))).handleCancel();
    }

    /**
     * Method under test: {@link SignupController#handleCancel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleCancel2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getState()" because "this.signupViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareCancelView(SignupPresenter.java:40)
        //       at interface_adapter.signup.SignupController.handleCancel(SignupController.java:18)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, null, new LoginViewModel()))).handleCancel();
    }

    /**
     * Method under test: {@link SignupController#handleCancel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleCancel3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupState.clearState()" because "signupState" is null
        //       at interface_adapter.signup.SignupPresenter.prepareCancelView(SignupPresenter.java:41)
        //       at interface_adapter.signup.SignupController.handleCancel(SignupController.java:18)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupViewModel signupViewModel = new SignupViewModel();
        signupViewModel.setState(null);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        (new SignupController(mock(SignupInputBoundary.class),
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()))).handleCancel();
    }

    /**
     * Method under test: {@link SignupController#goToLogin()}
     */
    @Test
    void testGoToLogin() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()))).goToLogin();
    }

    /**
     * Method under test: {@link SignupController#goToLogin()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToLogin2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.signup.SignupPresenter.goToLogin(SignupPresenter.java:47)
        //       at interface_adapter.signup.SignupController.goToLogin(SignupController.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(null, signupViewModel, new LoginViewModel()))).goToLogin();
    }

    /**
     * Method under test: {@link SignupController#goToLogin()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToLogin3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.login.LoginViewModel.getViewName()" because "this.loginViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.goToLogin(SignupPresenter.java:47)
        //       at interface_adapter.signup.SignupController.goToLogin(SignupController.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, new SignupViewModel(), null))).goToLogin();
    }

    /**
     * Method under test: {@link SignupController#execute(String, String, String)}
     */
    @Test
    void testExecute() {
        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        doNothing().when(userSignupUseCaseInteractor).execute(Mockito.<SignupInputData>any());
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()))).execute("janedoe", "Password1",
                "Password2");
        verify(userSignupUseCaseInteractor).execute(Mockito.<SignupInputData>any());
    }
}
