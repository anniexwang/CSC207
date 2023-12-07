package use_case.signup;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import data_access.FileUserDataAccessObject;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SignupInteractorDiffblueTest {
    /**
     * Method under test:
     * {@link SignupInteractor#SignupInteractor(SignupUserDataAccessInterface, SignupOutputBoundary, UserFactory)}
     */
    @Test
    void testConstructor() throws IOException {
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path",
                mock(UserFactory.class));

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor actualSignupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), mock(UserFactory.class));

        assertTrue(actualSignupInteractor.userDataAccessObject instanceof FileUserDataAccessObject);
        assertTrue(actualSignupInteractor.userPresenter instanceof SignupPresenter);
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    void testExecute() throws IOException {
        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        User user2 = mock(User.class);
        when(user2.getName()).thenReturn("Name");
        when(user2.getPassword()).thenReturn("iloveyou");
        when(user2.getFavorites()).thenReturn(new ArrayList<>());
        when(user2.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user2);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "iloveyou", "iloveyou"));
        verify(user2).getFavorites();
        verify(user2, atLeast(1)).getName();
        verify(user2).getPassword();
        verify(user2).getTranslationHistory();
        verify(userFactory).create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any());
        verify(userFactory2).create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.signup.SignupUserDataAccessInterface.existsByName(String)" because "this.userDataAccessObject" is null
        //       at use_case.signup.SignupInteractor.execute(SignupInteractor.java:40)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor signupInteractor = new SignupInteractor(null,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), userFactory);
        signupInteractor.execute(new SignupInputData("janedoe", "iloveyou", "iloveyou"));
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute3() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareSuccessView(SignupPresenter.java:35)
        //       at use_case.signup.SignupInteractor.execute(SignupInteractor.java:50)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        User user2 = mock(User.class);
        when(user2.getName()).thenReturn("Name");
        when(user2.getPassword()).thenReturn("iloveyou");
        when(user2.getFavorites()).thenReturn(new ArrayList<>());
        when(user2.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user2);
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(null, signupViewModel, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "iloveyou", "iloveyou"));
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    void testExecute4() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("", "iloveyou", "iloveyou"));
        verify(userFactory).create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    void testExecute5() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "Password", "iloveyou"));
        verify(userFactory).create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    void testExecute6() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "", "iloveyou"));
        verify(userFactory).create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    void testExecute7() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "iloveyou", ""));
        verify(userFactory).create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute8() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.signup.SignupInputData.getUsername()" because "signupInputData" is null
        //       at use_case.signup.SignupInteractor.execute(SignupInteractor.java:24)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        User user2 = mock(User.class);
        when(user2.getName()).thenReturn("Name");
        when(user2.getPassword()).thenReturn("iloveyou");
        when(user2.getFavorites()).thenReturn(new ArrayList<>());
        when(user2.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user2);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, signupViewModel, new LoginViewModel()), userFactory2)).execute(null);
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute9() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getState()" because "this.signupViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareFailView(SignupPresenter.java:53)
        //       at use_case.signup.SignupInteractor.execute(SignupInteractor.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        User user2 = mock(User.class);
        when(user2.getName()).thenReturn("Name");
        when(user2.getPassword()).thenReturn("iloveyou");
        when(user2.getFavorites()).thenReturn(new ArrayList<>());
        when(user2.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user2);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, null, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("", "iloveyou", "iloveyou"));
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute10() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getState()" because "this.signupViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareFailView(SignupPresenter.java:53)
        //       at use_case.signup.SignupInteractor.execute(SignupInteractor.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        User user2 = mock(User.class);
        when(user2.getName()).thenReturn("Name");
        when(user2.getPassword()).thenReturn("iloveyou");
        when(user2.getFavorites()).thenReturn(new ArrayList<>());
        when(user2.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user2);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, null, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "Password", "iloveyou"));
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute11() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getState()" because "this.signupViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareFailView(SignupPresenter.java:53)
        //       at use_case.signup.SignupInteractor.execute(SignupInteractor.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        User user2 = mock(User.class);
        when(user2.getName()).thenReturn("Name");
        when(user2.getPassword()).thenReturn("iloveyou");
        when(user2.getFavorites()).thenReturn(new ArrayList<>());
        when(user2.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user2);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, null, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "", "iloveyou"));
    }

    /**
     * Method under test: {@link SignupInteractor#execute(SignupInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute12() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.signup.SignupViewModel.getState()" because "this.signupViewModel" is null
        //       at interface_adapter.signup.SignupPresenter.prepareFailView(SignupPresenter.java:53)
        //       at use_case.signup.SignupInteractor.execute(SignupInteractor.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        User user = mock(User.class);
        when(user.getName()).thenReturn("Name");
        when(user.getPassword()).thenReturn("iloveyou");
        when(user.getFavorites()).thenReturn(new ArrayList<>());
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject signupDataAccessInterface = new FileUserDataAccessObject("Csv Path", userFactory);

        User user2 = mock(User.class);
        when(user2.getName()).thenReturn("Name");
        when(user2.getPassword()).thenReturn("iloveyou");
        when(user2.getFavorites()).thenReturn(new ArrayList<>());
        when(user2.getTranslationHistory()).thenReturn(new ArrayList<>());
        UserFactory userFactory2 = mock(UserFactory.class);
        when(userFactory2.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user2);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupInteractor signupInteractor = new SignupInteractor(signupDataAccessInterface,
                new SignupPresenter(viewManagerModel, null, new LoginViewModel()), userFactory2);
        signupInteractor.execute(new SignupInputData("janedoe", "iloveyou", ""));
    }
}
