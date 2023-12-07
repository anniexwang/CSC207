package interface_adapter.history;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class t3 {
    @Test
    void testSetState() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        HistoryState historyState = new HistoryState();
        historyViewModel.setState(historyState);
        assertEquals(historyState, historyViewModel.getState());
    }

    @Test
    void testGetState() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        HistoryState historyState = new HistoryState();
        historyViewModel.setState(historyState);
        assertEquals(historyState, historyViewModel.getState());
    }

    // Add more tests for other methods...
}