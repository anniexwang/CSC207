package interface_adapter.history;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class HistoryViewModelTest {

    @Test
    void setState() {
    }

    @Test
    void getState() {
    }

    @Test
    void getData() {
    }

    @Test
    void setData() {
    }

    @Test
    void separateToColumns() {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        String[] test = new String[3];
        test[0] = "a";
        test[1] = "{d:x, e:y, f:z}";
        test[2] = "01-May-2013,12:31:34";

        String[] expected = new String[8];
        expected[0] = "b";
        expected[1] = "d";
        expected[2] = "s";
        expected[3] = "e";
        expected[4] = "y";
        expected[5] = "f";
        expected[6] = "z";
        expected[7] = "15-Nov-2021,01:12:09";


        String[] actual = historyViewModel.separateToColumns(test);

        assertEquals(expected, actual);
    }

    @Test
    void maxColumnLength() {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);

        String[][] test = new String[3][8];
        String[] row1 = new String[] {"a","a","a"};
        String[] row2 = new String[] {"a","a","a","a","a","a"};
        String[] row3 = new String[] {"a"};
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        int actual = historyViewModel.maxColumnLength(test);

        assertEquals(6, actual);
    }

    @Test
    void getTitles() {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        historyViewModel.getTitles();
    }


    @Test
    void convertToStringArray() {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);

        ArrayList<List<String>> test = new ArrayList<>();
        List<String> testRow1 = new ArrayList<>();
        List<String> testRow2 = new ArrayList<>();
        List<String> testRow3 = new ArrayList<>();
        Collections.addAll(testRow1, "a","a","a");
        Collections.addAll(testRow2, "a","a","a","a","a","a");
        Collections.addAll(testRow3, "a");
        Collections.addAll(test, testRow1, testRow2, testRow3);

        String[][] expected = new String[3][8];
        String[] row1 = new String[] {"a","a","a"};
        String[] row2 = new String[] {"a","a","a","a","a","a"};
        String[] row3 = new String[] {"a"};
        expected[0] = row1;
        expected[1] = row2;
        expected[2] = row3;

        String[][] actual = historyViewModel.convertToStringArray(test);

        assertEquals(expected, actual);
    }

    @Test
    void languageHistory() {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);

        String[][] test = new String[3][8];
        String[] row1 = new String[]{"a","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] row2 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] row3 = new String[]{"c","d","j","","","f","k","29-Apr-2010,13:00:14"};
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        String[] expected = new String[]{"d","e","f"};

        String[] actual = historyViewModel.languageHistory(test);

        assertEquals(expected, actual);
    }

    @Test
    void sortNone() throws ParseException {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        HistoryState historyState = mock(HistoryState.class);
        historyState.setHistorySortType("None");

        String[][] test = new String[3][8];
        String[] testRow1 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] testRow2 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] testRow3 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        test[0] = testRow1;
        test[1] = testRow2;
        test[2] = testRow3;

        String[][] expected = new String[3][8];
        String[] row1 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] row2 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] row3 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        String[][] actual = historyViewModel.sort(test);

        assertEquals(expected, actual);
    }

    @Test
    void sortAlphabetical() throws ParseException {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        HistoryState historyState = mock(HistoryState.class);
        historyState.setHistorySortType("Alphabetical");

        String[][] test = new String[3][8];
        String[] testRow1 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] testRow2 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] testRow3 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        test[0] = testRow1;
        test[1] = testRow2;
        test[2] = testRow3;

        String[][] expected = new String[3][8];
        String[] row1 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] row2 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] row3 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        String[][] actual = historyViewModel.sort(test);

        assertEquals(expected, actual);
    }

    @Test
    void sortTimeCreated() throws ParseException {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        HistoryState historyState = mock(HistoryState.class);
        historyState.setHistorySortType("Time Created");

        String[][] test = new String[3][8];
        String[] testRow1 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] testRow2 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] testRow3 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        test[0] = testRow1;
        test[1] = testRow2;
        test[2] = testRow3;

        String[][] expected = new String[3][8];
        String[] row1 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        String[] row2 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] row3 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        String[][] actual = historyViewModel.sort(test);

        assertEquals(expected, actual);
    }

    @Test
    void sortWordSize() throws ParseException {
        HistoryViewModel historyViewModel = mock(HistoryViewModel.class);
        HistoryState historyState = mock(HistoryState.class);
        historyState.setHistorySortType("Word Size");

        String[][] test = new String[3][8];
        String[] testRow1 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] testRow2 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};
        String[] testRow3 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        test[0] = testRow1;
        test[1] = testRow2;
        test[2] = testRow3;

        String[][] expected = new String[3][8];
        String[] row1 = new String[]{"b","d","s","","","","","15-Nov-2021,01:12:09"};
        String[] row2 = new String[]{"cc","d","j","","","f","k","29-Apr-2010,13:00:14"};
        String[] row3 = new String[]{"aaa","d","s","e","y","f","z","01-May-2013,12:31:34"};

        test[0] = row1;
        test[1] = row2;
        test[2] = row3;

        String[][] actual = historyViewModel.sort(test);

        assertEquals(expected, actual);
    }
}