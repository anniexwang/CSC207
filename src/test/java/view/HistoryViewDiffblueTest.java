package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import interface_adapter.history.HistoryViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HistoryViewDiffblueTest {
    /**
     * Method under test: {@link HistoryView#HistoryView(HistoryViewModel)}
     */
    @Test
    void testConstructor() {
        HistoryView actualHistoryView = new HistoryView(new HistoryViewModel());
        assertEquals("History View", actualHistoryView.viewName);
        assertNull(actualHistoryView.data[0][0]);
        assertEquals(0, actualHistoryView.columnTitles.length);
    }


    /**
     * Method under test: {@link HistoryView#HistoryView(HistoryViewModel)}
     */
    @Test
    void testConstructor3() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        HistoryView actualHistoryView = new HistoryView(historyViewModel);
        assertEquals("History View", actualHistoryView.viewName);
        assertNull(actualHistoryView.data[0][0]);
        assertEquals(0, actualHistoryView.columnTitles.length);
    }

    /**
     * Method under test: {@link HistoryView#propertyChange(PropertyChangeEvent)}
     */
    @Test
    void testPropertyChange() {
        HistoryView historyView = new HistoryView(new HistoryViewModel());
        historyView.propertyChange(new PropertyChangeEvent("42", "foo", "42", "42"));
        assertEquals(0, historyView.columnTitles.length);
    }

    /**
     * Method under test: {@link HistoryView#propertyChange(PropertyChangeEvent)}
     */
    @Test
    void testPropertyChange2() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        HistoryView historyView = new HistoryView(historyViewModel);
        historyView.propertyChange(new PropertyChangeEvent("42", "foo", "42", "42"));
        assertEquals(0, historyView.columnTitles.length);
    }
}
