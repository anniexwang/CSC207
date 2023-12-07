package interface_adapter.signup;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.signup.SignupOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class SignupPresenterTest {
    @Test
    void testPrepareSuccessView() {
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        SignupViewModel signupViewModel = Mockito.mock(SignupViewModel.class);
        LoginViewModel loginViewModel = Mockito.mock(LoginViewModel.class);
        LoginState loginState = new LoginState();
        Mockito.when(loginViewModel.getState()).thenReturn(loginState);
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        SignupOutputData signupOutputData = new SignupOutputData("testUsername", true);
        signupPresenter.prepareSuccessView(signupOutputData);
        assertEquals("testUsername", loginState.getUsername());
        verify(viewManagerModel).setActiveView(loginViewModel.getViewName());
    }

    @Test
    void testPrepareCancelView() {
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        SignupViewModel signupViewModel = Mockito.mock(SignupViewModel.class);
        SignupState signupState = new SignupState();
        Mockito.when(signupViewModel.getState()).thenReturn(signupState);
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, Mockito.mock(LoginViewModel.class));
        signupPresenter.prepareCancelView();
        assertEquals("", signupState.getUsername());
        assertEquals("", signupState.getPassword());
        assertEquals("", signupState.getRepeatPassword());
    }

    @Test
    void testGoToLogin() {
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        LoginViewModel loginViewModel = Mockito.mock(LoginViewModel.class);
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, Mockito.mock(SignupViewModel.class), loginViewModel);
        signupPresenter.goToLogin();
        verify(viewManagerModel).setActiveView(loginViewModel.getViewName());
    }

    @Test
    void testPrepareFailView() {
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        SignupViewModel signupViewModel = Mockito.mock(SignupViewModel.class);
        SignupState signupState = new SignupState();
        Mockito.when(signupViewModel.getState()).thenReturn(signupState);
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, Mockito.mock(LoginViewModel.class));
        signupPresenter.prepareFailView("An error occurred");
        assertEquals("An error occurred", signupState.getUsernameError());
    }
}