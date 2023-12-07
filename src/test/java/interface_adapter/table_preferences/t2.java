// Test for TableViewModel
package interface_adapter.table_preferences;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class TableViewModelTest {
    @Test
    void testSetState() {
        TableViewModel tableViewModel = new TableViewModel();
        TableState tableState = new TableState();
        tableViewModel.setState(tableState);
        assertEquals(tableState, tableViewModel.getState());
    }

    @Test
    void testGetState() {
        TableViewModel tableViewModel = new TableViewModel();
        TableState tableState = new TableState();
        tableViewModel.setState(tableState);
        assertEquals(tableState, tableViewModel.getState());
    }

    @Test
    void testFirePropertyChanged() {
        TableViewModel tableViewModel = new TableViewModel();
        PropertyChangeListener listener = Mockito.mock(PropertyChangeListener.class);
        tableViewModel.addPropertyChangeListener(listener);
        tableViewModel.firePropertyChanged();
        verify(listener).propertyChange(Mockito.any());
    }
}