package interface_adapter.login;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.login.LoginOutputData;

class LoginPresenterDiffblueTest {
    /**
     * Method under test:
     * {@link LoginPresenter#LoginPresenter(ViewManagerModel, TranslationViewModel, SignupViewModel, LoginViewModel)}
     */
    @Test
    void testConstructor() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LoginPresenter.loginViewModel
        //     LoginPresenter.signupViewModel
        //     LoginPresenter.translationViewModel
        //     LoginPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel());

    }

    /**
     * Method under test: {@link LoginPresenter#prepareSuccessView(LoginOutputData)}
     */
    @Test
    void testPrepareSuccessView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LoginPresenter.loginViewModel
        //     LoginPresenter.signupViewModel
        //     LoginPresenter.translationViewModel
        //     LoginPresenter.viewManagerModel

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
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.login.LoginPresenter.prepareSuccessView(LoginPresenter.java:45)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(null, translationViewModel, signupViewModel,
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
     * Method under test: {@link LoginPresenter#prepareSuccessView(LoginOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.getState()" because "this.translationViewModel" is null
        //       at interface_adapter.login.LoginPresenter.prepareSuccessView(LoginPresenter.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, null, signupViewModel, new LoginViewModel());
        loginPresenter.prepareSuccessView(new LoginOutputData("janedoe", true));
    }

    /**
     * Method under test: {@link LoginPresenter#prepareSuccessView(LoginOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.login.LoginOutputData.getUsername()" because "response" is null
        //       at interface_adapter.login.LoginPresenter.prepareSuccessView(LoginPresenter.java:41)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()))
                .prepareSuccessView(null);
    }

    /**
     * Method under test: {@link LoginPresenter#prepareSuccessView(LoginOutputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareSuccessView6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationState.setUsername(String)" because "translationState" is null
        //       at interface_adapter.login.LoginPresenter.prepareSuccessView(LoginPresenter.java:41)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);

        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.setState(null);
        SignupViewModel signupViewModel = new SignupViewModel();
        LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel,
                new LoginViewModel());
        loginPresenter.prepareSuccessView(new LoginOutputData("janedoe", true));
    }

    /**
     * Method under test: {@link LoginPresenter#goToSignUp()}
     */
    @Test
    void testGoToSignUp() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LoginPresenter.loginViewModel
        //     LoginPresenter.signupViewModel
        //     LoginPresenter.translationViewModel
        //     LoginPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel())).goToSignUp();
    }

    /**
     * Method under test: {@link LoginPresenter#goToSignUp()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToSignUp2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.login.LoginPresenter.goToSignUp(LoginPresenter.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(null, translationViewModel, signupViewModel, new LoginViewModel())).goToSignUp();
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
     * Method under test: {@link LoginPresenter#goToSignUp()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToSignUp4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getViewName()" because "this.signupViewModel" is null
        //       at interface_adapter.login.LoginPresenter.goToSignUp(LoginPresenter.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, null, new LoginViewModel())).goToSignUp();
    }

    /**
     * Method under test: {@link LoginPresenter#prepareFailView(String)}
     */
    @Test
    void testPrepareFailView() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LoginPresenter.loginViewModel
        //     LoginPresenter.signupViewModel
        //     LoginPresenter.translationViewModel
        //     LoginPresenter.viewManagerModel

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
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     LoginPresenter.loginViewModel
        //     LoginPresenter.signupViewModel
        //     LoginPresenter.translationViewModel
        //     LoginPresenter.viewManagerModel

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, signupViewModel, new LoginViewModel()))
                .prepareFailView("An error occurred");
    }

    /**
     * Method under test: {@link LoginPresenter#prepareFailView(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPrepareFailView3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.login.LoginViewModel.getState()" because "this.loginViewModel" is null
        //       at interface_adapter.login.LoginPresenter.prepareFailView(LoginPresenter.java:56)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        (new LoginPresenter(viewManagerModel, translationViewModel, new SignupViewModel(), null))
                .prepareFailView("An error occurred");
    }
}
