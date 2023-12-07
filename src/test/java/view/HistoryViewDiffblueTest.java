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
    @Disabled("TODO: Complete this test")
    void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.history.HistoryViewModel.addPropertyChangeListener(java.beans.PropertyChangeListener)" because "this.historyViewModel" is null
        //       at view.HistoryView.<init>(HistoryView.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        new HistoryView(null);
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
