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
import java.beans.PropertyChangeListener;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.Audio.AudioInputData;
import use_case.Audio.AudioInteractor;
import use_case.signup.SignupInputBoundary;

class SignupViewDiffblueTest {
    /**
     * Method under test:
     * {@link SignupView#SignupView(SignupController, SignupViewModel, AudioController)}
     */
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

    /**
     * Method under test:
     * {@link SignupView#SignupView(SignupController, SignupViewModel, AudioController)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.addPropertyChangeListener(java.beans.PropertyChangeListener)" because "signupViewModel" is null
        //       at view.SignupView.<init>(SignupView.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        new SignupView(controller, null,
                new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8")))));

    }

    /**
     * Method under test:
     * {@link SignupView#SignupView(SignupController, SignupViewModel, AudioController)}
     */
    @Test
    void testConstructor3() {
        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        assertEquals("sign up", (new SignupView(controller, signupViewModel2, new AudioController(
                new AudioInteractor(new AudioInputData(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}))))).viewName);
    }

    /**
     * Method under test:
     * {@link SignupView#SignupView(SignupController, SignupViewModel, AudioController)}
     */
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

    /**
     * Method under test:
     * {@link SignupView#SignupView(SignupController, SignupViewModel, AudioController)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.Audio.AudioInteractor.isMuted()" because "this.audioInteractor" is null
        //       at interface_adapter.Audio.AudioController.isMuted(AudioController.java:22)
        //       at view.SignupView.createMuteButton(SignupView.java:147)
        //       at view.SignupView.<init>(SignupView.java:84)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        new SignupView(controller, signupViewModel2, new AudioController(null));

    }

    /**
     * Method under test:
     * {@link SignupView#SignupView(SignupController, SignupViewModel, AudioController)}
     */
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

    /**
     * Method under test:
     * {@link SignupView#SignupView(SignupController, SignupViewModel, AudioController)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor7() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.addPropertyChangeListener(java.beans.PropertyChangeListener)" because "signupViewModel" is null
        //       at view.SignupView.<init>(SignupView.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        SignupViewModel signupViewModel = new SignupViewModel();
        signupViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        signupViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupController controller = new SignupController(mock(SignupInputBoundary.class),
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        new SignupView(controller, null,
                new AudioController(new AudioInteractor(new AudioInputData("AXAXAXAX".getBytes("UTF-8")))));

    }

    /**
     * Method under test: {@link SignupView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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

    /**
     * Method under test: {@link SignupView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed2() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        SignupInputBoundary userSignupUseCaseInteractor = mock(SignupInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupController controller = new SignupController(userSignupUseCaseInteractor,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()));

        SignupViewModel signupViewModel2 = new SignupViewModel();
        SignupView signupView = new SignupView(controller, signupViewModel2,
                new AudioController(new AudioInteractor(new AudioInputData("AXAXAAAX".getBytes("UTF-8")))));
        signupView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }

    /**
     * Method under test: {@link SignupView#propertyChange(PropertyChangeEvent)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPropertyChange() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class java.lang.String cannot be cast to class interface_adapter.signup.SignupState (java.lang.String is in module java.base of loader 'bootstrap'; interface_adapter.signup.SignupState is in unnamed module of loader com.diffblue.cover.g.g @1de6cbc3)
        //       at view.SignupView.propertyChange(SignupView.java:187)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        SignupView signupView = null;
        PropertyChangeEvent evt = null;

        // Act
        signupView.propertyChange(evt);

        // Assert
        // TODO: Add assertions on result
    }
}
