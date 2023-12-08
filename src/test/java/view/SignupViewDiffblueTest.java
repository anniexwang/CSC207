package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import interface_adapter.Audio.AudioController;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;
import use_case.signup.SignupInputBoundary;

class SignupViewDiffblueTest {
    @Test
    void testConstructor() throws UnsupportedEncodingException {
        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        assertEquals("sign up", (new SignupView(controller, signupViewModel2,
                new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8")))))).viewName);
    }

    @Test
    void testConstructor3() {
        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        assertEquals("sign up", (new SignupView(controller, signupViewModel2, new AudioController(
                new AudioInteractor(new AudioInputData(new byte[]{-1, 'X', 'A', 20, 'A', 'X', 'A', 'X'}))))).viewName);
    }

    @Test
    void testConstructor4() throws UnsupportedEncodingException {
        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        assertEquals("sign up", (new SignupView(controller, signupViewModel2,
                new AudioController(new AudioInteractor(new AudioInputData("AAAXAXAX".getBytes("UTF-8")))))).viewName);
    }

    @Test
    void testConstructor6() {
        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        assertEquals("sign up", (new SignupView(controller, signupViewModel2, new AudioController(
                new AudioInteractor(new AudioInputData(new byte[]{-1, 'X', 'A', 20, 'A', 'X', 'A', 'X'}))))).viewName);
    }

    @Test
    void testActionPerformed() throws UnsupportedEncodingException {
        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        SignupView signupView = new SignupView(controller, signupViewModel2,
                new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8")))));
        signupView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }
}