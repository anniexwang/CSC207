package use_case.login;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import data_access.FileUserDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationViewModel;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LoginInteractorDiffblueTest {
    /**
     * Method under test:
     * {@link LoginInteractor#LoginInteractor(LoginUserDataAccessInterface, LoginOutputBoundary)}
     */
    @Test
    void testConstructor() throws IOException {
        FileUserDataAccessObject userDataAccessInterface = new FileUserDataAccessObject("Csv Path",
                mock(UserFactory.class));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginInteractor actualLoginInteractor = new LoginInteractor(userDataAccessInterface,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));

        assertTrue(actualLoginInteractor.userDataAccessObject instanceof FileUserDataAccessObject);
        assertTrue(actualLoginInteractor.loginPresenter instanceof LoginPresenter);
    }

    /**
     * Method under test: {@link LoginInteractor#execute(LoginInputData)}
     */
    @Test
    void testExecute() throws IOException {


        FileUserDataAccessObject userDataAccessInterface = new FileUserDataAccessObject("Csv Path",
                mock(UserFactory.class));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginInteractor loginInteractor = new LoginInteractor(userDataAccessInterface,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));
        loginInteractor.execute(new LoginInputData("janedoe", "iloveyou"));
    }


    /**
     * Method under test: {@link LoginInteractor#execute(LoginInputData)}
     */
    @Test
    void testExecute4() throws IOException {

        FileUserDataAccessObject userDataAccessInterface = new FileUserDataAccessObject("Csv Path",
                mock(UserFactory.class));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginInteractor loginInteractor = new LoginInteractor(userDataAccessInterface,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));
        loginInteractor.execute(new LoginInputData(null, "iloveyou"));
    }

    /**
     * Method under test: {@link LoginInteractor#execute(LoginInputData)}
     */
    @Test
    void testExecute5() throws IOException {

        FileUserDataAccessObject userDataAccessInterface = new FileUserDataAccessObject("Csv Path",
                mock(UserFactory.class));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginInteractor loginInteractor = new LoginInteractor(userDataAccessInterface,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));
        loginInteractor.execute(new LoginInputData("", "iloveyou"));
    }

    /**
     * Method under test: {@link LoginInteractor#execute(LoginInputData)}
     */
    @Test
    void testExecute6() throws IOException {

        FileUserDataAccessObject userDataAccessInterface = new FileUserDataAccessObject("Csv Path",
                mock(UserFactory.class));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginInteractor loginInteractor = new LoginInteractor(userDataAccessInterface,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));
        loginInteractor.execute(new LoginInputData("janedoe", null));
    }

    /**
     * Method under test: {@link LoginInteractor#execute(LoginInputData)}
     */
    @Test
    void testExecute7() throws IOException {


        FileUserDataAccessObject userDataAccessInterface = new FileUserDataAccessObject("Csv Path",
                mock(UserFactory.class));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginInteractor loginInteractor = new LoginInteractor(userDataAccessInterface,
                new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()));
        loginInteractor.execute(new LoginInputData("janedoe", ""));
    }

}
