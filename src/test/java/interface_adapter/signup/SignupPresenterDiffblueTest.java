package interface_adapter.signup;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Disabled;
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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupPresenter.loginViewModel
        //     SignupPresenter.signupViewModel
        //     SignupPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupPresenter.loginViewModel
        //     SignupPresenter.signupViewModel
        //     SignupPresenter.viewManagerModel

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
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareSuccessView(SignupPresenter.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupViewModel signupViewModel = new SignupViewModel();
        SignupPresenter signupPresenter = new SignupPresenter(null, signupViewModel, new LoginViewModel());
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
     * Method under test:
     * {@link SignupPresenter#prepareSuccessView(SignupOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.login.LoginViewModel.getState()" because "this.loginViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareSuccessView(SignupPresenter.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, new SignupViewModel(), null);
        signupPresenter.prepareSuccessView(new SignupOutputData("janedoe", true));
    }

    /**
     * Method under test:
     * {@link SignupPresenter#prepareSuccessView(SignupOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.signup.SignupOutputData.getUsername()" because "response" is null
        //       at interface_adapter.signup.SignupPresenter.prepareSuccessView(SignupPresenter.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareSuccessView(null);
    }

    /**
     * Method under test:
     * {@link SignupPresenter#prepareSuccessView(SignupOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.login.LoginState.setUsername(String)" because "loginState" is null
        //       at interface_adapter.signup.SignupPresenter.prepareSuccessView(SignupPresenter.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);

        LoginViewModel loginViewModel = new LoginViewModel();
        loginViewModel.setState(null);
        SignupPresenter signupPresenter = new SignupPresenter(viewManagerModel, new SignupViewModel(), loginViewModel);
        signupPresenter.prepareSuccessView(new SignupOutputData("janedoe", true));
    }

    /**
     * Method under test: {@link SignupPresenter#prepareCancelView()}
     */
    @Test
    void testPrepareCancelView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupPresenter.loginViewModel
        //     SignupPresenter.signupViewModel
        //     SignupPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareCancelView();
    }

    /**
     * Method under test: {@link SignupPresenter#prepareCancelView()}
     */
    @Test
    void testPrepareCancelView2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupPresenter.loginViewModel
        //     SignupPresenter.signupViewModel
        //     SignupPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareCancelView();
    }

    /**
     * Method under test: {@link SignupPresenter#prepareCancelView()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareCancelView3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getState()" because "this.signupViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareCancelView(SignupPresenter.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        (new SignupPresenter(viewManagerModel, null, new LoginViewModel())).prepareCancelView();
    }

    /**
     * Method under test: {@link SignupPresenter#goToLogin()}
     */
    @Test
    void testGoToLogin() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupPresenter.loginViewModel
        //     SignupPresenter.signupViewModel
        //     SignupPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).goToLogin();
    }

    /**
     * Method under test: {@link SignupPresenter#goToLogin()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToLogin2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.signup.SignupPresenter.goToLogin(SignupPresenter.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(null, signupViewModel, new LoginViewModel())).goToLogin();
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
     * Method under test: {@link SignupPresenter#goToLogin()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToLogin4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.login.LoginViewModel.getViewName()" because "this.loginViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.goToLogin(SignupPresenter.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        (new SignupPresenter(viewManagerModel, new SignupViewModel(), null)).goToLogin();
    }

    /**
     * Method under test: {@link SignupPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupPresenter.loginViewModel
        //     SignupPresenter.signupViewModel
        //     SignupPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link SignupPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView2() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SignupPresenter.loginViewModel
        //     SignupPresenter.signupViewModel
        //     SignupPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel())).prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link SignupPresenter#prepareFailView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareFailView3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getState()" because "this.signupViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareFailView(SignupPresenter.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        (new SignupPresenter(viewManagerModel, null, new LoginViewModel())).prepareFailView("An error occurred");
    }
}
