package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import interface_adapter.history.HistoryViewModel;
import interface_adapter.table_preferences.TableController;
import interface_adapter.table_preferences.TableViewModel;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.table_preferences.TableInputBoundary;

class TablePreferenceViewDiffblueTest {
    /**
     * Method under test:
     * {@link TablePreferenceView#TablePreferenceView(TableController, TableViewModel, HistoryViewModel)}
     */
    @Test
    void testConstructor() {
        TableController tableController = new TableController(mock(TableInputBoundary.class));
        TableViewModel tableViewModel = new TableViewModel();
        assertEquals("Table Preferences View",
                (new TablePreferenceView(tableController, tableViewModel, new HistoryViewModel())).viewName);
    }

    /**
     * Method under test:
     * {@link TablePreferenceView#TablePreferenceView(TableController, TableViewModel, HistoryViewModel)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.table_preferences.TableViewModel.addPropertyChangeListener(java.beans.PropertyChangeListener)" because "this.tableViewModel" is null
        //       at view.TablePreferenceView.<init>(TablePreferenceView.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        TableController tableController = new TableController(mock(TableInputBoundary.class));
        new TablePreferenceView(tableController, null, new HistoryViewModel());

    }

    /**
     * Method under test: {@link TablePreferenceView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        TableController tableController = new TableController(mock(TableInputBoundary.class));
        TableViewModel tableViewModel = new TableViewModel();
        TablePreferenceView tablePreferenceView = new TablePreferenceView(tableController, tableViewModel,
                new HistoryViewModel());
        tablePreferenceView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }

    /**
     * Method under test:
     * {@link TablePreferenceView#propertyChange(PropertyChangeEvent)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPropertyChange() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class java.lang.String cannot be cast to class interface_adapter.table_preferences.TableState (java.lang.String is in module java.base of loader 'bootstrap'; interface_adapter.table_preferences.TableState is in unnamed module of loader com.diffblue.cover.g.g @1de6cbc3)
        //       at view.TablePreferenceView.propertyChange(TablePreferenceView.java:142)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        TablePreferenceView tablePreferenceView = null;
        PropertyChangeEvent evt = null;

        // Act
        tablePreferenceView.propertyChange(evt);

        // Assert
        // TODO: Add assertions on result
    }
}
