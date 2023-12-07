package use_case.translate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import data_access.FileUserDataAccessObject;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.table_preferences.TableViewModel;
import interface_adapter.translation.TranslationPresenter;
import interface_adapter.translation.TranslationViewModel;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TranslateInteractorDiffblueTest {
    /**
     * Method under test:
     * {@link TranslateInteractor#TranslateInteractor(TranslateOutputBoundary, TranslateUserDataAccessInterface)}
     */
    @Test
    void testConstructor() throws IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translateOutputBoundary = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        TranslateInteractor actualTranslateInteractor = new TranslateInteractor(translateOutputBoundary,
                new FileUserDataAccessObject("Csv Path", mock(UserFactory.class)));

        assertTrue(actualTranslateInteractor.userDataAccess instanceof FileUserDataAccessObject);
        assertTrue(actualTranslateInteractor.translationPresenter instanceof TranslationPresenter);
    }

    /**
     * Method under test: {@link TranslateInteractor#execute(TranslateInputData)}
     */
    @Test
    void testExecute() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject userDataAccess = new FileUserDataAccessObject("Csv Path", userFactory);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslateInteractor translateInteractor = new TranslateInteractor(
                new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()),
                userDataAccess);
        translateInteractor.execute(new TranslateInputData("Original", "janedoe"));
        verify(userFactory, atLeast(1)).create(Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<ArrayList<String>>any(), Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link TranslateInteractor#execute(TranslateInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.ViewManagerModel.setActiveView(String)" because "this.viewManagerModel" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareSuccessView(TranslationPresenter.java:29)
        //       at use_case.translate.TranslateInteractor.execute(TranslateInteractor.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject userDataAccess = new FileUserDataAccessObject("Csv Path", userFactory);

        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslateInteractor translateInteractor = new TranslateInteractor(
                new TranslationPresenter(null, translationViewModel, signupViewModel, new TableViewModel()), userDataAccess);
        translateInteractor.execute(new TranslateInputData("Original", "janedoe"));
    }

    /**
     * Method under test: {@link TranslateInteractor#execute(TranslateInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute3() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.translate.TranslateOutputBoundary.prepareSuccessView(String)" because "this.translationPresenter" is null
        //       at use_case.translate.TranslateInteractor.execute(TranslateInteractor.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        TranslateInteractor translateInteractor = new TranslateInteractor(null,
                new FileUserDataAccessObject("Csv Path", userFactory));
        translateInteractor.execute(new TranslateInputData("Original", "janedoe"));
    }

    /**
     * Method under test: {@link TranslateInteractor#execute(TranslateInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.translate.TranslateUserDataAccessInterface.updateAccounts()" because "this.userDataAccess" is null
        //       at use_case.translate.TranslateInteractor.execute(TranslateInteractor.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslateInteractor translateInteractor = new TranslateInteractor(
                new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()), null);
        translateInteractor.execute(new TranslateInputData("Original", "janedoe"));
    }

    /**
     * Method under test: {@link TranslateInteractor#execute(TranslateInputData)}
     */
    @Test
    void testExecute5() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject userDataAccess = new FileUserDataAccessObject("Csv Path", userFactory);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslateInteractor translateInteractor = new TranslateInteractor(
                new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()),
                userDataAccess);
        translateInteractor.execute(new TranslateInputData("", "janedoe"));
        verify(userFactory).create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link TranslateInteractor#execute(TranslateInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute6() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "use_case.translate.TranslateInputData.getOriginal()" because "translateInputData" is null
        //       at use_case.translate.TranslateInteractor.execute(TranslateInteractor.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject userDataAccess = new FileUserDataAccessObject("Csv Path", userFactory);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslateInteractor(
                new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()),
                userDataAccess)).execute(null);
    }

    /**
     * Method under test: {@link TranslateInteractor#execute(TranslateInputData)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute7() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.getState()" because "this.translationViewModel" is null
        //       at interface_adapter.translation.TranslationPresenter.prepareFailView(TranslationPresenter.java:51)
        //       at use_case.translate.TranslateInteractor.execute(TranslateInteractor.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        UserFactory userFactory = mock(UserFactory.class);
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(mock(User.class));
        FileUserDataAccessObject userDataAccess = new FileUserDataAccessObject("Csv Path", userFactory);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslateInteractor translateInteractor = new TranslateInteractor(
                new TranslationPresenter(viewManagerModel, null, signupViewModel, new TableViewModel()), userDataAccess);
        translateInteractor.execute(new TranslateInputData("", "janedoe"));
    }
}
