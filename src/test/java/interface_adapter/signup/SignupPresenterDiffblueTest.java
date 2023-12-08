package interface_adapter.signup;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.signup.SignupOutputData;

class SignupPresenterDiffblueTest {
    /**
     * Method under test:
     * {@link SignupPresenter#SignupPresenter(ViewManagerModel, SignupViewModel, LoginViewModel)}
     */
    @Test
    void testConstructor() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel());

    }

    /**
     * Method under test:
     * {@link SignupPresenter#prepareSuccessView(SignupOutputData)}
     */
    @Test
    void testPrepareSuccessView() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel());
        signupPresenter.prepareSuccessView(new SignupOutputData("janedoe", true));
    }

    /**
     * Method under test:
     * {@link SignupPresenter#prepareSuccessView(SignupOutputData)}
     */
    @Test
    void testPrepareSuccessView3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel());
        signupPresenter.prepareSuccessView(new SignupOutputData("janedoe", true));
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link SignupPresenter#prepareCancelView()}
     */
    @Test
    void testPrepareCancelView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareCancelView();
    }

    /**
     * Method under test: {@link SignupPresenter#prepareCancelView()}
     */
    @Test
    void testPrepareCancelView2() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareCancelView();
    }

    /**
     * Method under test: {@link SignupPresenter#goToLogin()}
     */
    @Test
    void testGoToLogin() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).goToLogin();
    }

    /**
     * Method under test: {@link SignupPresenter#goToLogin()}
     */
    @Test
    void testGoToLogin3() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).goToLogin();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test: {@link SignupPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link SignupPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView2() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareFailView("An error occurred");
    }
}
