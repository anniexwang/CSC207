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
     * Method under test: {@link TablePreferenceView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed() {

        TableController tableController = new TableController(mock(TableInputBoundary.class));
        TableViewModel tableViewModel = new TableViewModel();
        TablePreferenceView tablePreferenceView = new TablePreferenceView(tableController, tableViewModel,
                new HistoryViewModel());
        tablePreferenceView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }


}
