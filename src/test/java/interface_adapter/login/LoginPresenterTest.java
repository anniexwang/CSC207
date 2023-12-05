package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.login.LoginOutputData;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class LoginPresenterTest {
    /**
     * Method under test:
     * {@link LoginPresenter#LoginPresenter(ViewManagerModel, TranslationViewModel, SignupViewModel, LoginViewModel)}
     */

    /**
     * Method under test: {@link LoginPresenter#prepareSuccessView(LoginOutputData)}
     */
    @Test
    void testPrepareSuccessView() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel,
                new LoginViewModel());
        loginPresenter.prepareSuccessView(new LoginOutputData("janedoe", true));
    }



    /**
     * Method under test: {@link LoginPresenter#prepareSuccessView(LoginOutputData)}
     */
    @Test
    void testPrepareSuccessView3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel,
                new LoginViewModel());
        loginPresenter.prepareSuccessView(new LoginOutputData("janedoe", true));
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link LoginPresenter#goToSignUp()}
     */
    @Test
    void testGoToSignUp() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel())).goToSignUp();
    }

    /**
     * Method under test: {@link LoginPresenter#goToSignUp()}
     */
    @Test
    void testGoToSignUp3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel())).goToSignUp();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }


    /**
     * Method under test: {@link LoginPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link LoginPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView2() {


        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()))
                .prepareFailView("An error occurred");
    }


    @Test
    void testConstructor() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, loginViewModel);

        // Now you can assert the state of the fields
        assertEquals(viewManagerModel, loginPresenter.viewManagerModel);
        assertEquals(translationViewModel, loginPresenter.translationViewModel);
        assertEquals(signupViewModel, loginPresenter.signupViewModel);
        assertEquals(loginViewModel, loginPresenter.loginViewModel);
    }

}
