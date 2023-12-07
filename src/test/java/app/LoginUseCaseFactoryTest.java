package app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import interface_adapter.Audio.AudioController;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationViewModel;
import org.junit.jupiter.api.Test;
import use_case.login.LoginUserDataAccessInterface;

class LoginUseCaseFactoryTest {

    @Test
    void testCreate() {
        // Arrange
        ViewManagerModel viewManagerModel = mock(ViewManagerModel.class);
        LoginViewModel loginViewModel = mock(LoginViewModel.class);
        TranslationViewModel translationViewModel = mock(TranslationViewModel.class);
        SignupViewModel signupViewModel = mock(SignupViewModel.class);
        LoginUserDataAccessInterface userDataAccessObject = mock(LoginUserDataAccessInterface.class);
        AudioController audioController = mock(AudioController.class);
        interface_adapter.history.HistoryViewModel historyViewModel = mock(interface_adapter.history.HistoryViewModel.class);

        // Act
        var result = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, translationViewModel, signupViewModel,
                userDataAccessObject, audioController, historyViewModel);

        // Assert
        assertNotNull(result);
    }
}