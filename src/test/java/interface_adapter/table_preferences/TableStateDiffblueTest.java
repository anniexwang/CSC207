package interface_adapter.table_preferences;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TableStateDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TableState#TableState()}
     *   <li>{@link TableState#setSortType(String)}
     *   <li>{@link TableState#setSortTypeError(String)}
     *   <li>{@link TableState#setTableType(String)}
     *   <li>{@link TableState#setTableTypeError(String)}
     *   <li>{@link TableState#getSortType()}
     *   <li>{@link TableState#getSortTypeError()}
     *   <li>{@link TableState#getTableType()}
     *   <li>{@link TableState#getTableTypeError()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TableState actualTableState = new TableState();
        actualTableState.setSortType("Sort Type");
        actualTableState.setSortTypeError("An error occurred");
        actualTableState.setTableType("Table Type");
        actualTableState.setTableTypeError("An error occurred");
        String actualSortType = actualTableState.getSortType();
        String actualSortTypeError = actualTableState.getSortTypeError();
        String actualTableType = actualTableState.getTableType();
        assertEquals("An error occurred", actualTableState.getTableTypeError());
        assertEquals("Sort Type", actualSortType);
        assertEquals("Sort Type", actualSortTypeError);
        assertEquals("Table Type", actualTableType);
    }

    /**
     * Method under test: {@link TableState#TableState(TableState)}
     */
    @Test
    void testConstructor2() {
        TableState actualTableState = new TableState(new TableState());
        assertEquals("", actualTableState.getSortType());
        assertEquals("", actualTableState.getTableType());
        assertNull(actualTableState.getTableTypeError());
    }

    /**
     * Method under test: {@link TableState#TableState(TableState)}
     */

}
