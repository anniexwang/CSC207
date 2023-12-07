// Test for TableController
package interface_adapter.table_preferences;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInputData;

import static org.mockito.Mockito.verify;

class TableControllerTest {
    @Test
    void testExecute() {
        TableInputBoundary tableInputBoundary = Mockito.mock(TableInputBoundary.class);
        TableController tableController = new TableController(tableInputBoundary);
        tableController.execute("testTableType", "testSortType");
        verify(tableInputBoundary).execute(Mockito.any(TableInputData.class));
    }
}