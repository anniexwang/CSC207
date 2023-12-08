package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.table_preferences.TableViewModel;
import interface_adapter.translation.TranslationController;
import interface_adapter.translation.TranslationPresenter;
import interface_adapter.translation.TranslationViewModel;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.translate.TranslateInputBoundary;

class TranslationViewDiffblueTest {
    /**
     * Method under test:
     * {@link TranslationView#TranslationView(TranslationController, TranslationViewModel)}
     */
    @Test
    void testConstructor() {
        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        TranslationController translationController = new TranslationController(translateUseCaseInteractor,
                translationPresenter, new TranslationViewModel());

        assertEquals("translate", (new TranslationView(translationController, new TranslationViewModel())).viewName);
    }



    /**
     * Method under test: {@link TranslationView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed() {

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        TranslationController translationController = new TranslationController(translateUseCaseInteractor,
                translationPresenter, new TranslationViewModel());

        TranslationView translationView = new TranslationView(translationController, new TranslationViewModel());
        translationView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }

}
