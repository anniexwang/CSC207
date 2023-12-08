package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import interface_adapter.Audio.AudioController;
import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationViewModel;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;
import use_case.login.LoginInputBoundary;

class LoginViewDiffblueTest {
    /**
     * Method under test:
     * {@link LoginView#LoginView(LoginViewModel, LoginController, AudioController, HistoryViewModel)}
     */
    @Test
    void testConstructor() throws UnsupportedEncodingException {
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginController loginController = new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));

        AudioController audioController = new AudioController(
                new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))));
        assertEquals("log in",
                (new LoginView(loginViewModel, loginController, audioController, new HistoryViewModel())).viewName);
    }



    /**
     * Method under test:
     * {@link LoginView#LoginView(LoginViewModel, LoginController, AudioController, HistoryViewModel)}
     */
    @Test
    void testConstructor3() {
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginController loginController = new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));

        AudioController audioController = new AudioController(
                new AudioInteractor(new AudioInputData(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE})));
        assertEquals("log in",
                (new LoginView(loginViewModel, loginController, audioController, new HistoryViewModel())).viewName);
    }



    /**
     * Method under test:
     * {@link LoginView#LoginView(LoginViewModel, LoginController, AudioController, HistoryViewModel)}
     */
    @Test
    void testConstructor5() {
        LoginViewModel loginViewModel = new LoginViewModel();

        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        translationViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginController loginController = new LoginController(mock(LoginInputBoundary.class),
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));

        AudioController audioController = new AudioController(
                new AudioInteractor(new AudioInputData(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', Byte.MAX_VALUE})));
        assertEquals("log in",
                (new LoginView(loginViewModel, loginController, audioController, new HistoryViewModel())).viewName);
    }

    /**
     * Method under test: {@link LoginView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed() throws UnsupportedEncodingException {

        LoginViewModel loginViewModel = new LoginViewModel();
        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginController loginController = new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));

        AudioController audioController = new AudioController(
                new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))));
        LoginView loginView = new LoginView(loginViewModel, loginController, audioController, new HistoryViewModel());
        loginView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }

    /**
     * Method under test: {@link LoginView#propertyChange(PropertyChangeEvent)}
     */
    @Test
    void testPropertyChange() throws UnsupportedEncodingException {

        LoginViewModel loginViewModel = new LoginViewModel();
        LoginInputBoundary loginUseCaseInteractor = mock(LoginInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginController loginController = new LoginController(loginUseCaseInteractor,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));

        AudioController audioController = new AudioController(
                new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))));
        LoginView loginView = new LoginView(loginViewModel, loginController, audioController, new HistoryViewModel());
        loginView.propertyChange(new PropertyChangeEvent("42", "foo", "42", "42"));
    }
}
