package interface_adapter.translation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TranslationViewModelDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TranslationViewModel#setState(TranslationState)}
     *   <li>{@link TranslationViewModel#getState()}
     * </ul>
     */
    @Test
    void testSetState() {
        TranslationViewModel translationViewModel = new TranslationViewModel();
        TranslationState state = new TranslationState();
        translationViewModel.setState(state);
        assertSame(state, translationViewModel.getState());
    }

    /**
     * Method under test: default or parameterless constructor of
     * {@link TranslationViewModel}
     */
    @Test
    void testConstructor() {
        TranslationViewModel actualTranslationViewModel = new TranslationViewModel();
        assertEquals("translate", actualTranslationViewModel.getViewName());
        TranslationState state = actualTranslationViewModel.getState();
        assertNull(state.getOriginalError());
        assertNull(state.getTranslatedError());
        assertNull(state.getUsernameError());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, state.getOriginal());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, state.getTranslated());
        assertEquals(TranslationViewModel.TRANSLATE_OUTPUT, state.getUsername());
    }

    /**
     * Method under test: {@link TranslationViewModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged() {
        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.firePropertyChanged();
        assertEquals("translate", translationViewModel.getViewName());
    }

    /**
     * Method under test: {@link TranslationViewModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged2() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.addPropertyChangeListener(listener);
        translationViewModel.firePropertyChanged();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
        assertEquals("translate", translationViewModel.getViewName());
    }

    /**
     * Method under test:
     * {@link TranslationViewModel#addPropertyChangeListener(PropertyChangeListener)}
     */
    @Test
    void testAddPropertyChangeListener() {
        TranslationViewModel translationViewModel = new TranslationViewModel();
        translationViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertEquals("translate", translationViewModel.getViewName());
    }
}
