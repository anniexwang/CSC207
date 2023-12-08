package interface_adapter.translation;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.table_preferences.TableViewModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.translate.TranslateInputBoundary;
import use_case.translate.TranslateInputData;

class TranslationControllerDiffblueTest {
    /**
     * Method under test:
     * {@link TranslationController#TranslationController(TranslateInputBoundary, TranslationPresenter, TranslationViewModel)}
     */
    @Test
    void testConstructor() {

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel());

    }

    /**
     * Method under test: {@link TranslationController#backToSignup()}
     */
    @Test
    void testBackToSignup() {

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .backToSignup();
    }

    /**
     * Method under test: {@link TranslationController#backToSignup()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBackToSignup2() {

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(null, translationViewModel, signupViewModel,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .backToSignup();
    }

    /**
     * Method under test: {@link TranslationController#backToSignup()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBackToSignup3() {


        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel, null,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .backToSignup();
    }

    /**
     * Method under test: {@link TranslationController#goToHistory()}
     */
    @Test
    void testGoToHistory() {

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .goToHistory();
    }

    /**
     * Method under test: {@link TranslationController#goToHistory()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToHistory2() {


        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(null, translationViewModel, signupViewModel,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .goToHistory();
    }

    /**
     * Method under test: {@link TranslationController#goToHistory()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGoToHistory3() {


        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                new SignupViewModel(), null);

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .goToHistory();
    }

    /**
     * Method under test: {@link TranslationController#handleCancel()}
     */
    @Test
    void testHandleCancel() {


        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .handleCancel();
    }

    /**
     * Method under test: {@link TranslationController#handleCancel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleCancel2() {


        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, null, signupViewModel,
                new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .handleCancel();
    }

    /**
     * Method under test: {@link TranslationController#handleCancel()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandleCancel3() {


        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.setState(null);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .handleCancel();
    }

    /**
     * Method under test: {@link TranslationController#execute(String)}
     */
    @Test
    void testExecute() {
        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        doNothing().when(translateUseCaseInteractor).execute(Mockito.<TranslateInputData>any());
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        (new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()))
                .execute("Phrase");
        verify(translateUseCaseInteractor).execute(Mockito.<TranslateInputData>any());
    }

    /**
     * Method under test: {@link TranslationController#execute(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExecute2() {


        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        doNothing().when(translateUseCaseInteractor).execute(Mockito.<TranslateInputData>any());
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        (new TranslationController(translateUseCaseInteractor,
                new TranslationPresenter(viewManagerModel, translationViewModel, signupViewModel, new TableViewModel()), null))
                .execute("Phrase");
    }
}
