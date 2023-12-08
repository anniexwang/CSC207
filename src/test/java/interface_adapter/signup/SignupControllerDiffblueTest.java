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


        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()))).handleCancel();
    }


    /**
     * Method under test: {@link SignupController#goToLogin()}
     */
    @Test
    void testGoToLogin() {

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


        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(null, signupViewModel, new LoginViewModel()))).goToLogin();
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
