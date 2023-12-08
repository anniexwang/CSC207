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


}
