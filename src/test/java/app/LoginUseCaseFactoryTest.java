package app;

import static org.junit.Assert.*;

import interface_adapter.Audio.AudioController;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.Test;
import org.mockito.Mockito;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;

import java.io.IOException;

public class LoginUseCaseFactoryTest {

    @Test
    public void testCreate() {
        // Create mock objects for dependencies
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        LoginViewModel loginViewModel = Mockito.mock(LoginViewModel.class);
        LoggedInViewModel loggedInViewModel = Mockito.mock(LoggedInViewModel.class);
        SignupViewModel signupViewModel = Mockito.mock(SignupViewModel.class);
        LoginUserDataAccessInterface userDataAccessObject = Mockito.mock(LoginUserDataAccessInterface.class);
        AudioController audioController = Mockito.mock(AudioController.class);

        // Call the create method
        LoginView loginView = LoginUseCaseFactory.create(
                viewManagerModel, loginViewModel, loggedInViewModel, signupViewModel, userDataAccessObject, audioController
        );

        // Assert that the loginView is not null
        assertNotNull(loginView);

    }

    @Test
    public void testCreateLoginUseCase() throws IOException {
        // Create mock objects for dependencies
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        LoginViewModel loginViewModel = Mockito.mock(LoginViewModel.class);
        LoggedInViewModel loggedInViewModel = Mockito.mock(LoggedInViewModel.class);
        SignupViewModel signupViewModel = Mockito.mock(SignupViewModel.class);
        LoginUserDataAccessInterface userDataAccessObject = Mockito.mock(LoginUserDataAccessInterface.class);

        // Call the createLoginUseCase method
        LoginController loginController = LoginUseCaseFactory.createLoginUseCase(
                viewManagerModel, loginViewModel, loggedInViewModel, signupViewModel, userDataAccessObject
        );

        // Assert that the loginController is not null
        assertNotNull(loginController);

    }
}