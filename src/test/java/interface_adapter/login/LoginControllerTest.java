package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import static org.mockito.Mockito.*;

class LoginControllerTest {
    /**
     * Method under test:
     * {@link LoginController#LoginController(LoginInputBoundary, LoginPresenter)}
     */
    @Test
    void testConstructor() {

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

        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel())))
                .goToSignUp();
    }


}
