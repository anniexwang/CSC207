package interface_adapter.select_languages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SelectLanguagesViewModelDiffblueTest {
    /**
     * Method under test: {@link SelectLanguagesViewModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged() {
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        selectLanguagesViewModel.firePropertyChanged();
        assertEquals("Select Languages View", selectLanguagesViewModel.getViewName());
    }

    /**
     * Method under test: {@link SelectLanguagesViewModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged2() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        selectLanguagesViewModel.addPropertyChangeListener(listener);
        selectLanguagesViewModel.firePropertyChanged();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
        assertEquals("Select Languages View", selectLanguagesViewModel.getViewName());
    }
}
