package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import data_access.FileUserDataAccessObject;
import entity.UserFactory;
import interface_adapter.Audio.AudioController;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;
import use_case.signup.SignupUserDataAccessInterface;

class SignupUseCaseFactoryDiffblueTest {
    /**
     * Method under test:
     * {@link SignupUseCaseFactory#create(ViewManagerModel, LoginViewModel, SignupViewModel, SignupUserDataAccessInterface, AudioController)}
     */
    @Test
    void testCreate() throws IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        FileUserDataAccessObject userDataAccessObject = new FileUserDataAccessObject("Csv Path", mock(UserFactory.class));

        assertEquals("sign up",
                SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject,
                        new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))))).viewName);
    }




    /**
     * Method under test:
     * {@link SignupUseCaseFactory#create(ViewManagerModel, LoginViewModel, SignupViewModel, SignupUserDataAccessInterface, AudioController)}
     */
    @Test
    void testCreate4() throws IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(null);
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        FileUserDataAccessObject userDataAccessObject = new FileUserDataAccessObject("Csv Path", mock(UserFactory.class));

        assertEquals("sign up",
                SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject,
                        new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8"))))).viewName);
    }
}
