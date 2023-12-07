package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.table_preferences.TableViewModel;
import interface_adapter.translation.TranslationViewModel;

import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TranslationUseCaseFactoryDiffblueTest {
    /**
     * Method under test:
     * {@link TranslationUseCaseFactory#create(ViewManagerModel, TranslationViewModel, SignupViewModel, TableViewModel)}
     */
    @Test
    void testCreate() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        assertEquals("translate", TranslationUseCaseFactory.create(viewManagerModel, translationViewModel, signupViewModel,
                new TableViewModel()).viewName);
    }

    /**
     * Method under test:
     * {@link TranslationUseCaseFactory#create(ViewManagerModel, TranslationViewModel, SignupViewModel, TableViewModel)}
     */
    @Test
    void testCreate2() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        TranslationViewModel translationViewModel = new TranslationViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        assertEquals("translate", TranslationUseCaseFactory.create(viewManagerModel, translationViewModel, signupViewModel,
                new TableViewModel()).viewName);
    }

    /**
     * Method under test:
     * {@link TranslationUseCaseFactory#create(ViewManagerModel, TranslationViewModel, SignupViewModel, TableViewModel)}
     */

}
