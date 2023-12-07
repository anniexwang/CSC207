package interface_adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViewManagerModelDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ViewManagerModel#setActiveView(String)}
     *   <li>{@link ViewManagerModel#getActiveView()}
     * </ul>
     */
    @Test
    void testSetActiveView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.setActiveView("Active View");
        assertEquals("Active View", viewManagerModel.getActiveView());
    }

    /**
     * Method under test: {@link ViewManagerModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.firePropertyChanged();
        assertNull(viewManagerModel.getActiveView());
    }

    /**
     * Method under test: {@link ViewManagerModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged2() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(listener);
        viewManagerModel.firePropertyChanged();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
    }

    /**
     * Method under test:
     * {@link ViewManagerModel#addPropertyChangeListener(PropertyChangeListener)}
     */
    @Test
    void testAddPropertyChangeListener() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertNull(viewManagerModel.getActiveView());
    }
}
