package interface_adapter.history;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryStateTest {
    @Test
    void testGetTableType() {
        HistoryState historyState = new HistoryState();
        historyState.setHistoryTableType("testTableType");
        assertEquals("testTableType", historyState.getTableType());
    }

    @Test
    void testGetSortType() {
        HistoryState historyState = new HistoryState();
        historyState.setHistorySortType("testSortType");
        assertEquals("testSortType", historyState.getSortType());
    }

    @Test
    void testGetLanguages() {
        HistoryState historyState = new HistoryState();
        String[] languages = {"English", "Spanish"};
        historyState.setHistoryLanguages(languages);
        assertArrayEquals(languages, historyState.getLanguages());
    }

    @Test
    void testGetCurrentUsername() {
        HistoryState historyState = new HistoryState();
        historyState.setCurrentUsername("testUsername");
        assertEquals("testUsername", historyState.getCurrentUsername());
    }

    @Test
    void testSetHistoryTableType() {
        HistoryState historyState = new HistoryState();
        historyState.setHistoryTableType("testTableType");
        assertEquals("testTableType", historyState.getTableType());
    }

    @Test
    void testSetHistorySortType() {
        HistoryState historyState = new HistoryState();
        historyState.setHistorySortType("testSortType");
        assertEquals("testSortType", historyState.getSortType());
    }

    @Test
    void testSetHistoryLanguages() {
        HistoryState historyState = new HistoryState();
        String[] languages = {"English", "Spanish"};
        historyState.setHistoryLanguages(languages);
        assertArrayEquals(languages, historyState.getLanguages());
    }

    @Test
    void testSetCurrentUsername() {
        HistoryState historyState = new HistoryState();
        historyState.setCurrentUsername("testUsername");
        assertEquals("testUsername", historyState.getCurrentUsername());
    }
}