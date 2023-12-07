package interface_adapter.history;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HistoryViewModelDiffblueTest {
    /**
     * Method under test: default or parameterless constructor of
     * {@link HistoryViewModel}
     */
    @Test
    void testConstructor() {
        HistoryViewModel actualHistoryViewModel = new HistoryViewModel();
        HistoryState state = actualHistoryViewModel.getState();
        assertEquals("", state.getCurrentUsername());
        assertEquals("", state.getSortType());
        assertEquals("", state.getTableType());
        assertEquals("History View", actualHistoryViewModel.getViewName());
        assertEquals("History View", actualHistoryViewModel.TITLE_LABEL);
        assertTrue(actualHistoryViewModel.getData().isEmpty());
    }

    /**
     * Method under test: {@link HistoryViewModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.firePropertyChanged();
        assertEquals("History View", historyViewModel.getViewName());
        assertTrue(historyViewModel.getData().isEmpty());
    }

    /**
     * Method under test: {@link HistoryViewModel#firePropertyChanged()}
     */
    @Test
    void testFirePropertyChanged2() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        doNothing().when(listener).propertyChange(Mockito.<PropertyChangeEvent>any());

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(listener);
        historyViewModel.firePropertyChanged();
        verify(listener).propertyChange(Mockito.<PropertyChangeEvent>any());
        assertEquals("History View", historyViewModel.getViewName());
        assertTrue(historyViewModel.getData().isEmpty());
    }

    /**
     * Method under test:
     * {@link HistoryViewModel#addPropertyChangeListener(PropertyChangeListener)}
     */
    @Test
    void testAddPropertyChangeListener() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertEquals("History View", historyViewModel.getViewName());
        assertTrue(historyViewModel.getData().isEmpty());
    }

    /**
     * Method under test: {@link HistoryViewModel#getData()}
     */
    @Test
    void testGetData() {
        assertTrue((new HistoryViewModel()).getData().isEmpty());
    }

    /**
     * Method under test: {@link HistoryViewModel#getData()}
     */
    @Test
    void testGetData2() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertTrue(historyViewModel.getData().isEmpty());
    }

    /**
     * Method under test: {@link HistoryViewModel#getData()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetData3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.history.HistoryState.getCurrentUsername()" because "this.state" is null
        //       at interface_adapter.history.HistoryViewModel.getData(HistoryViewModel.java:53)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(null);
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        historyViewModel.getData();
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link HistoryViewModel#setData(ArrayList)}
     *   <li>{@link HistoryViewModel#setState(HistoryState)}
     *   <li>{@link HistoryViewModel#getState()}
     * </ul>
     */
    @Test
    void testSetData() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setData(new ArrayList<>());
        HistoryState state = new HistoryState();
        historyViewModel.setState(state);
        assertSame(state, historyViewModel.getState());
    }

    /**
     * Method under test: {@link HistoryViewModel#separateToColumns(String[])}
     */
    @Test
    void testSeparateToColumns() {
        assertArrayEquals(new String[]{"String List"},
                (new HistoryViewModel()).separateToColumns(new String[]{"String List"}));
        assertArrayEquals(new String[]{"{", "}"}, (new HistoryViewModel()).separateToColumns(new String[]{"{", "}"}));
    }

    /**
     * Method under test: {@link HistoryViewModel#separateToColumns(String[])}
     */
    @Test
    void testSeparateToColumns2() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertArrayEquals(new String[]{"String List"}, historyViewModel.separateToColumns(new String[]{"String List"}));
    }

    /**
     * Method under test: {@link HistoryViewModel#separateToColumns(String[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSeparateToColumns3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at interface_adapter.history.HistoryViewModel.separateToColumns(HistoryViewModel.java:144)
        //   See https://diff.blue/R013 to resolve this issue.

        (new HistoryViewModel()).separateToColumns(new String[]{});
    }

    /**
     * Method under test: {@link HistoryViewModel#maxColumnLength(String[][])}
     */
    @Test
    void testMaxColumnLength() {
        assertEquals(1, (new HistoryViewModel()).maxColumnLength(new String[][]{new String[]{"Data"}}));
        assertEquals(0, (new HistoryViewModel()).maxColumnLength(new String[][]{}));
    }

    /**
     * Method under test: {@link HistoryViewModel#maxColumnLength(String[][])}
     */
    @Test
    void testMaxColumnLength2() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertEquals(1, historyViewModel.maxColumnLength(new String[][]{new String[]{"Data"}}));
    }

    /**
     * Method under test: {@link HistoryViewModel#getTitles()}
     */
    @Test
    void testGetTitles() {
        assertEquals(0, (new HistoryViewModel()).getTitles().length);
    }

    /**
     * Method under test: {@link HistoryViewModel#getTitles()}
     */
    @Test
    void testGetTitles2() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertEquals(0, historyViewModel.getTitles().length);
    }

    /**
     * Method under test: {@link HistoryViewModel#getTitles()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTitles3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.history.HistoryState.getTableType()" because "this.state" is null
        //       at interface_adapter.history.HistoryViewModel.getTitles(HistoryViewModel.java:184)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(null);
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        historyViewModel.getTitles();
    }

    /**
     * Method under test: {@link HistoryViewModel#convertToStringArray(ArrayList)}
     */
    @Test
    void testConvertToStringArray() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        assertEquals(0, historyViewModel.convertToStringArray(new ArrayList<>()).length);
    }

    /**
     * Method under test: {@link HistoryViewModel#convertToStringArray(ArrayList)}
     */
    @Test
    void testConvertToStringArray2() {
        HistoryViewModel historyViewModel = new HistoryViewModel();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");

        ArrayList<String> stringList2 = new ArrayList<>();
        stringList2.add("foo");

        ArrayList<String> stringList3 = new ArrayList<>();
        stringList3.add("foo");

        ArrayList<String> stringList4 = new ArrayList<>();
        stringList4.add("foo");

        ArrayList<String> stringList5 = new ArrayList<>();
        stringList5.add("foo");

        ArrayList<String> stringList6 = new ArrayList<>();
        stringList6.add("foo");

        ArrayList<String> stringList7 = new ArrayList<>();
        stringList7.add("foo");

        ArrayList<String> stringList8 = new ArrayList<>();
        stringList8.add("foo");

        ArrayList<String> stringList9 = new ArrayList<>();
        stringList9.add("foo");

        ArrayList<String> stringList10 = new ArrayList<>();
        stringList10.add("foo");

        ArrayList<String> stringList11 = new ArrayList<>();
        stringList11.add("foo");

        ArrayList<String> stringList12 = new ArrayList<>();
        stringList12.add("foo");

        ArrayList<String> stringList13 = new ArrayList<>();
        stringList13.add("foo");

        ArrayList<String> stringList14 = new ArrayList<>();
        stringList14.add("foo");

        ArrayList<String> stringList15 = new ArrayList<>();
        stringList15.add("foo");

        ArrayList<String> stringList16 = new ArrayList<>();
        stringList16.add("foo");

        ArrayList<String> stringList17 = new ArrayList<>();
        stringList17.add("foo");

        ArrayList<String> stringList18 = new ArrayList<>();
        stringList18.add("foo");

        ArrayList<List<String>> data = new ArrayList<>();
        data.add(stringList);
        data.add(stringList2);
        data.add(stringList3);
        data.add(stringList4);
        data.add(stringList5);
        data.add(stringList6);
        data.add(stringList7);
        data.add(stringList8);
        data.add(stringList9);
        data.add(stringList10);
        data.add(stringList11);
        data.add(stringList12);
        data.add(stringList13);
        data.add(stringList14);
        data.add(stringList15);
        data.add(stringList16);
        data.add(stringList17);
        data.add(stringList18);
        String[][] actualConvertToStringArrayResult = historyViewModel.convertToStringArray(data);
        assertEquals(1, (actualConvertToStringArrayResult[0]).length);
        assertEquals(1, (actualConvertToStringArrayResult[1]).length);
        assertEquals(1, (actualConvertToStringArrayResult[10]).length);
        assertEquals(1, (actualConvertToStringArrayResult[11]).length);
        assertEquals(1, (actualConvertToStringArrayResult[12]).length);
        assertEquals(1, (actualConvertToStringArrayResult[13]).length);
        assertEquals(1, (actualConvertToStringArrayResult[14]).length);
        assertEquals(1, (actualConvertToStringArrayResult[15]).length);
        assertEquals(1, (actualConvertToStringArrayResult[2]).length);
        assertEquals(1, (actualConvertToStringArrayResult[3]).length);
        assertEquals(1, (actualConvertToStringArrayResult[4]).length);
        assertEquals(1, (actualConvertToStringArrayResult[5]).length);
        assertEquals(1, (actualConvertToStringArrayResult[6]).length);
        assertEquals(1, (actualConvertToStringArrayResult[7]).length);
        assertEquals(1, (actualConvertToStringArrayResult[8]).length);
        assertEquals(1, (actualConvertToStringArrayResult[9]).length);
        assertEquals(1, (actualConvertToStringArrayResult[Short.SIZE]).length);
        assertEquals(18, actualConvertToStringArrayResult.length);
        assertArrayEquals(new String[]{"foo"}, actualConvertToStringArrayResult[17]);
    }

    /**
     * Method under test: {@link HistoryViewModel#convertToStringArray(ArrayList)}
     */
    @Test
    void testConvertToStringArray3() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        assertEquals(0, historyViewModel.convertToStringArray(new ArrayList<>()).length);
    }

    /**
     * Method under test: {@link HistoryViewModel#convertToStringArray(ArrayList)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertToStringArray4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at interface_adapter.history.HistoryViewModel.separateToColumns(HistoryViewModel.java:144)
        //       at interface_adapter.history.HistoryViewModel.convertToStringArray(HistoryViewModel.java:226)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryViewModel historyViewModel = new HistoryViewModel();

        ArrayList<List<String>> data = new ArrayList<>();
        data.add(new ArrayList<>());
        historyViewModel.convertToStringArray(data);
    }

    /**
     * Method under test: {@link HistoryViewModel#convertToStringArray(ArrayList)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertToStringArray5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at interface_adapter.history.HistoryViewModel.separateToColumns(HistoryViewModel.java:144)
        //       at interface_adapter.history.HistoryViewModel.convertToStringArray(HistoryViewModel.java:226)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryViewModel historyViewModel = new HistoryViewModel();

        ArrayList<List<String>> data = new ArrayList<>();
        data.add(new ArrayList<>());
        data.add(new ArrayList<>());
        historyViewModel.convertToStringArray(data);
    }

    /**
     * Method under test: {@link HistoryViewModel#convertToStringArray(ArrayList)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertToStringArray6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
        //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
        //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
        //       at java.base/java.util.Objects.checkIndex(Objects.java:385)
        //       at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //       at interface_adapter.history.HistoryViewModel.convertToStringArray(HistoryViewModel.java:224)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryViewModel historyViewModel = new HistoryViewModel();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");

        ArrayList<List<String>> data = new ArrayList<>();
        data.add(stringList);
        data.add(new ArrayList<>());
        historyViewModel.convertToStringArray(data);
    }

    /**
     * Method under test: {@link HistoryViewModel#convertToStringArray(ArrayList)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConvertToStringArray7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
        //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
        //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
        //       at java.base/java.util.Objects.checkIndex(Objects.java:385)
        //       at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //       at interface_adapter.history.HistoryViewModel.convertToStringArray(HistoryViewModel.java:224)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryViewModel historyViewModel = new HistoryViewModel();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("}");
        stringList.add("foo");

        ArrayList<List<String>> data = new ArrayList<>();
        data.add(stringList);
        data.add(new ArrayList<>());
        historyViewModel.convertToStringArray(data);
    }

    /**
     * Method under test: {@link HistoryViewModel#languageHistory(String[][])}
     */
    @Test
    void testLanguageHistory() {
        String[] actualLanguageHistoryResult = (new HistoryViewModel())
                .languageHistory(new String[][]{new String[]{"Data"}});
        assertNull(actualLanguageHistoryResult[0]);
        assertNull(actualLanguageHistoryResult[1]);
        assertNull(actualLanguageHistoryResult[10]);
        assertNull(actualLanguageHistoryResult[11]);
        assertNull(actualLanguageHistoryResult[12]);
        assertNull(actualLanguageHistoryResult[13]);
        assertNull(actualLanguageHistoryResult[14]);
        assertNull(actualLanguageHistoryResult[15]);
        assertNull(actualLanguageHistoryResult[17]);
        assertNull(actualLanguageHistoryResult[18]);
        assertNull(actualLanguageHistoryResult[19]);
        assertNull(actualLanguageHistoryResult[2]);
        assertNull(actualLanguageHistoryResult[20]);
        assertNull(actualLanguageHistoryResult[21]);
        assertNull(actualLanguageHistoryResult[22]);
        assertNull(actualLanguageHistoryResult[23]);
        assertNull(actualLanguageHistoryResult[3]);
        assertNull(actualLanguageHistoryResult[4]);
        assertNull(actualLanguageHistoryResult[5]);
        assertNull(actualLanguageHistoryResult[6]);
        assertNull(actualLanguageHistoryResult[7]);
        assertNull(actualLanguageHistoryResult[75]);
        assertNull(actualLanguageHistoryResult[76]);
        assertNull(actualLanguageHistoryResult[77]);
        assertNull(actualLanguageHistoryResult[78]);
        assertNull(actualLanguageHistoryResult[79]);
        assertNull(actualLanguageHistoryResult[8]);
        assertNull(actualLanguageHistoryResult[80]);
        assertNull(actualLanguageHistoryResult[81]);
        assertNull(actualLanguageHistoryResult[82]);
        assertNull(actualLanguageHistoryResult[83]);
        assertNull(actualLanguageHistoryResult[84]);
        assertNull(actualLanguageHistoryResult[85]);
        assertNull(actualLanguageHistoryResult[86]);
        assertNull(actualLanguageHistoryResult[87]);
        assertNull(actualLanguageHistoryResult[88]);
        assertNull(actualLanguageHistoryResult[89]);
        assertNull(actualLanguageHistoryResult[9]);
        assertNull(actualLanguageHistoryResult[90]);
        assertNull(actualLanguageHistoryResult[91]);
        assertNull(actualLanguageHistoryResult[92]);
        assertNull(actualLanguageHistoryResult[93]);
        assertNull(actualLanguageHistoryResult[94]);
        assertNull(actualLanguageHistoryResult[95]);
        assertNull(actualLanguageHistoryResult[96]);
        assertNull(actualLanguageHistoryResult[97]);
        assertNull(actualLanguageHistoryResult[98]);
        assertNull(actualLanguageHistoryResult[99]);
        assertNull(actualLanguageHistoryResult[Float.PRECISION]);
        assertNull(actualLanguageHistoryResult[Short.SIZE]);
        assertEquals(100, actualLanguageHistoryResult.length);
    }

    /**
     * Method under test: {@link HistoryViewModel#languageHistory(String[][])}
     */
    @Test
    void testLanguageHistory2() {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        String[] actualLanguageHistoryResult = historyViewModel.languageHistory(new String[][]{new String[]{"Data"}});
        assertNull(actualLanguageHistoryResult[0]);
        assertNull(actualLanguageHistoryResult[1]);
        assertNull(actualLanguageHistoryResult[10]);
        assertNull(actualLanguageHistoryResult[11]);
        assertNull(actualLanguageHistoryResult[12]);
        assertNull(actualLanguageHistoryResult[13]);
        assertNull(actualLanguageHistoryResult[14]);
        assertNull(actualLanguageHistoryResult[15]);
        assertNull(actualLanguageHistoryResult[17]);
        assertNull(actualLanguageHistoryResult[18]);
        assertNull(actualLanguageHistoryResult[19]);
        assertNull(actualLanguageHistoryResult[2]);
        assertNull(actualLanguageHistoryResult[20]);
        assertNull(actualLanguageHistoryResult[21]);
        assertNull(actualLanguageHistoryResult[22]);
        assertNull(actualLanguageHistoryResult[23]);
        assertNull(actualLanguageHistoryResult[3]);
        assertNull(actualLanguageHistoryResult[4]);
        assertNull(actualLanguageHistoryResult[5]);
        assertNull(actualLanguageHistoryResult[6]);
        assertNull(actualLanguageHistoryResult[7]);
        assertNull(actualLanguageHistoryResult[75]);
        assertNull(actualLanguageHistoryResult[76]);
        assertNull(actualLanguageHistoryResult[77]);
        assertNull(actualLanguageHistoryResult[78]);
        assertNull(actualLanguageHistoryResult[79]);
        assertNull(actualLanguageHistoryResult[8]);
        assertNull(actualLanguageHistoryResult[80]);
        assertNull(actualLanguageHistoryResult[81]);
        assertNull(actualLanguageHistoryResult[82]);
        assertNull(actualLanguageHistoryResult[83]);
        assertNull(actualLanguageHistoryResult[84]);
        assertNull(actualLanguageHistoryResult[85]);
        assertNull(actualLanguageHistoryResult[86]);
        assertNull(actualLanguageHistoryResult[87]);
        assertNull(actualLanguageHistoryResult[88]);
        assertNull(actualLanguageHistoryResult[89]);
        assertNull(actualLanguageHistoryResult[9]);
        assertNull(actualLanguageHistoryResult[90]);
        assertNull(actualLanguageHistoryResult[91]);
        assertNull(actualLanguageHistoryResult[92]);
        assertNull(actualLanguageHistoryResult[93]);
        assertNull(actualLanguageHistoryResult[94]);
        assertNull(actualLanguageHistoryResult[95]);
        assertNull(actualLanguageHistoryResult[96]);
        assertNull(actualLanguageHistoryResult[97]);
        assertNull(actualLanguageHistoryResult[98]);
        assertNull(actualLanguageHistoryResult[99]);
        assertNull(actualLanguageHistoryResult[Float.PRECISION]);
        assertNull(actualLanguageHistoryResult[Short.SIZE]);
        assertEquals(100, actualLanguageHistoryResult.length);
    }

    /**
     * Method under test: {@link HistoryViewModel#languageHistory(String[][])}
     */
    @Test
    void testLanguageHistory3() {
        String[] actualLanguageHistoryResult = (new HistoryViewModel())
                .languageHistory(new String[][]{new String[]{"Data", "All", "Data"}});
        assertEquals("All", actualLanguageHistoryResult[0]);
        assertNull(actualLanguageHistoryResult[1]);
        assertNull(actualLanguageHistoryResult[10]);
        assertNull(actualLanguageHistoryResult[11]);
        assertNull(actualLanguageHistoryResult[12]);
        assertNull(actualLanguageHistoryResult[13]);
        assertNull(actualLanguageHistoryResult[14]);
        assertNull(actualLanguageHistoryResult[15]);
        assertNull(actualLanguageHistoryResult[17]);
        assertNull(actualLanguageHistoryResult[18]);
        assertNull(actualLanguageHistoryResult[19]);
        assertNull(actualLanguageHistoryResult[2]);
        assertNull(actualLanguageHistoryResult[20]);
        assertNull(actualLanguageHistoryResult[21]);
        assertNull(actualLanguageHistoryResult[22]);
        assertNull(actualLanguageHistoryResult[23]);
        assertNull(actualLanguageHistoryResult[3]);
        assertNull(actualLanguageHistoryResult[4]);
        assertNull(actualLanguageHistoryResult[5]);
        assertNull(actualLanguageHistoryResult[6]);
        assertNull(actualLanguageHistoryResult[7]);
        assertNull(actualLanguageHistoryResult[75]);
        assertNull(actualLanguageHistoryResult[76]);
        assertNull(actualLanguageHistoryResult[77]);
        assertNull(actualLanguageHistoryResult[78]);
        assertNull(actualLanguageHistoryResult[79]);
        assertNull(actualLanguageHistoryResult[8]);
        assertNull(actualLanguageHistoryResult[80]);
        assertNull(actualLanguageHistoryResult[81]);
        assertNull(actualLanguageHistoryResult[82]);
        assertNull(actualLanguageHistoryResult[83]);
        assertNull(actualLanguageHistoryResult[84]);
        assertNull(actualLanguageHistoryResult[85]);
        assertNull(actualLanguageHistoryResult[86]);
        assertNull(actualLanguageHistoryResult[87]);
        assertNull(actualLanguageHistoryResult[88]);
        assertNull(actualLanguageHistoryResult[89]);
        assertNull(actualLanguageHistoryResult[9]);
        assertNull(actualLanguageHistoryResult[90]);
        assertNull(actualLanguageHistoryResult[91]);
        assertNull(actualLanguageHistoryResult[92]);
        assertNull(actualLanguageHistoryResult[93]);
        assertNull(actualLanguageHistoryResult[94]);
        assertNull(actualLanguageHistoryResult[95]);
        assertNull(actualLanguageHistoryResult[96]);
        assertNull(actualLanguageHistoryResult[97]);
        assertNull(actualLanguageHistoryResult[98]);
        assertNull(actualLanguageHistoryResult[99]);
        assertNull(actualLanguageHistoryResult[Float.PRECISION]);
        assertNull(actualLanguageHistoryResult[Short.SIZE]);
        assertEquals(100, actualLanguageHistoryResult.length);
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    void testSort() throws ParseException {
        String[][] actualSortResult = (new HistoryViewModel()).sort(new String[][]{new String[]{"Data"}});
        assertEquals(1, actualSortResult.length);
        assertArrayEquals(new String[]{"Data"}, actualSortResult[0]);
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    void testSort2() throws ParseException {
        HistoryState state = new HistoryState();
        state.setHistorySortType((String) "None");

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(state);
        String[][] actualSortResult = historyViewModel.sort(new String[][]{new String[]{"foo"}});
        assertEquals(1, actualSortResult.length);
        assertArrayEquals(new String[]{"foo"}, actualSortResult[0]);
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    void testSort3() throws ParseException {
        HistoryState state = new HistoryState();
        state.setHistorySortType((String) "Alphabetical");

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(state);
        String[][] actualSortResult = historyViewModel.sort(new String[][]{new String[]{"foo"}});
        assertEquals(1, actualSortResult.length);
        assertArrayEquals(new String[]{"foo"}, actualSortResult[0]);
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSort4() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.text.ParseException: Unparseable date: "foo"
        //       at java.base/java.text.DateFormat.parse(DateFormat.java:399)
        //       at interface_adapter.history.HistoryViewModel.sort(HistoryViewModel.java:288)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryState state = new HistoryState();
        state.setHistorySortType((String) "Time Created");

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(state);
        historyViewModel.sort(new String[][]{new String[]{"foo"}});
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    void testSort5() throws ParseException {
        HistoryState state = new HistoryState();
        state.setHistorySortType((String) "Word Size");

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(state);
        String[][] actualSortResult = historyViewModel.sort(new String[][]{new String[]{"foo"}});
        assertEquals(1, actualSortResult.length);
        assertArrayEquals(new String[]{"foo"}, actualSortResult[0]);
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    void testSort6() throws ParseException {
        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        String[][] actualSortResult = historyViewModel.sort(new String[][]{new String[]{"Data"}});
        assertEquals(1, actualSortResult.length);
        assertArrayEquals(new String[]{"Data"}, actualSortResult[0]);
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSort7() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at interface_adapter.history.HistoryViewModel.sort(HistoryViewModel.java:263)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryState state = new HistoryState();
        state.setHistorySortType((String) "Alphabetical");

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(state);
        historyViewModel.sort(new String[][]{new String[]{}});
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSort8() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 0
        //       at interface_adapter.history.HistoryViewModel.sort(HistoryViewModel.java:288)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryState state = new HistoryState();
        state.setHistorySortType((String) "Time Created");

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(state);
        historyViewModel.sort(new String[][]{new String[]{}});
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSort9() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at interface_adapter.history.HistoryViewModel.sort(HistoryViewModel.java:315)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryState state = new HistoryState();
        state.setHistorySortType((String) "Word Size");

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(state);
        historyViewModel.sort(new String[][]{new String[]{}});
    }

    /**
     * Method under test: {@link HistoryViewModel#sort(String[][])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSort10() throws ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.history.HistoryState.getSortType()" because "this.state" is null
        //       at interface_adapter.history.HistoryViewModel.sort(HistoryViewModel.java:249)
        //   See https://diff.blue/R013 to resolve this issue.

        HistoryViewModel historyViewModel = new HistoryViewModel();
        historyViewModel.setState(null);
        historyViewModel.addPropertyChangeListener(mock(PropertyChangeListener.class));
        historyViewModel.sort(new String[][]{new String[]{"Data"}});
    }
}
