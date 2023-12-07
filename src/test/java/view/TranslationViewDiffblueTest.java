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
     * Method under test:
     * {@link TranslationView#TranslationView(TranslationController, TranslationViewModel)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.translation.TranslationViewModel.addPropertyChangeListener(java.beans.PropertyChangeListener)" because "translationViewModel" is null
        //       at view.TranslationView.<init>(TranslationView.java:42)
        //   See https://diff.blue/R013 to resolve this issue.

        TranslateInputBoundary translateUseCaseInteractor = mock(TranslateInputBoundary.class);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        TranslationPresenter translationPresenter = new TranslationPresenter(viewManagerModel, translationViewModel,
                signupViewModel, new TableViewModel());

        new TranslationView(
                new TranslationController(translateUseCaseInteractor, translationPresenter, new TranslationViewModel()), null);

    }

    /**
     * Method under test: {@link TranslationView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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

    /**
     * Method under test:
     * {@link TranslationView#propertyChange(PropertyChangeEvent)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPropertyChange() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class java.lang.String cannot be cast to class interface_adapter.translation.TranslationState (java.lang.String is in module java.base of loader 'bootstrap'; interface_adapter.translation.TranslationState is in unnamed module of loader com.diffblue.cover.g.g @1de6cbc3)
        //       at view.TranslationView.propertyChange(TranslationView.java:142)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        TranslationView translationView = null;
        PropertyChangeEvent evt = null;

        // Act
        translationView.propertyChange(evt);

        // Assert
        // TODO: Add assertions on result
    }
}
