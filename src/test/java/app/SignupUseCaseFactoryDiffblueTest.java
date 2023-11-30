package app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import data_access.FileUserDataAccessObject;
import entity.User;
import entity.UserFactory;
import interface_adapter.Audio.AudioController;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;
import use_case.signup.SignupUserDataAccessInterface;
import view.SignupView;

import javax.swing.*;

class SignupUseCaseFactoryDiffblueTest {
    /**
     * Method under test:
     * {@link SignupUseCaseFactory#create(ViewManagerModel, LoginViewModel, SignupViewModel, SignupUserDataAccessInterface, AudioController)}
     */
    @Test
    void testCreate() throws IOException {
        FileUserDataAccessObject userDataAccessObject = mock(FileUserDataAccessObject.class);

        // Other test setup
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        AudioController audioController = new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))));

        // Act and Assert
        assertNotNull(SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject, audioController),
                "Expected non-null SignupView");
    }

    /**
     * Method under test:
     * {@link SignupUseCaseFactory#create(ViewManagerModel, LoginViewModel, SignupViewModel, SignupUserDataAccessInterface, AudioController)}
     */
    @Test
    void testCreate2() throws UnsupportedEncodingException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        assertEquals("sign up", Objects.requireNonNull(SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, null,
                new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8")))))).viewName);
    }

    /**
     * Method under test:
     * {@link SignupUseCaseFactory#create(ViewManagerModel, LoginViewModel, SignupViewModel, SignupUserDataAccessInterface, AudioController)}
     */
    @Test
    void testCreate3() throws UnsupportedEncodingException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel(); // Non-null SignupViewModel
        AudioController audioController = new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))));

        assertNotNull(SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, null, audioController),
                "Expected non-null SignupView");
    }

    /**
     * Method under test:
     * {@link SignupUseCaseFactory#create(ViewManagerModel, LoginViewModel, SignupViewModel, SignupUserDataAccessInterface, AudioController)}
     */
    @Test
    void testCreate4() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        AudioInteractor audioInteractor = mock(AudioInteractor.class); // Mocked AudioInteractor
        AudioController audioController = new AudioController(audioInteractor);

        assertNotNull(SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, null, audioController),
                "Expected non-null SignupView");
    }
}

