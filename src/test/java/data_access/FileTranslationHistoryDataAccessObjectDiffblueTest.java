package data_access;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FileTranslationHistoryDataAccessObjectDiffblueTest {
    @Test
    void testConstructor() throws IOException {
        FileTranslationHistoryDataAccessObject fileTranslationHistoryDataAccessObject = new FileTranslationHistoryDataAccessObject("src/test/resources/users.csv");
        assertNotNull(fileTranslationHistoryDataAccessObject);
        assertArrayEquals(new String[]{"word", "language", "translation", "time created"}, fileTranslationHistoryDataAccessObject.getHeader());
    }

    @Test
    void testConstructor2() {
        assertThrows(IOException.class, () -> new FileTranslationHistoryDataAccessObject("foo"));
    }

    @Test
    void testConstructor3() {
        assertThrows(NullPointerException.class, () -> new FileTranslationHistoryDataAccessObject(null));
    }

    @Test
    void testGetData() throws IOException {
        FileTranslationHistoryDataAccessObject fileTranslationHistoryDataAccessObject = new FileTranslationHistoryDataAccessObject("src/test/resources/test.csv");
        ArrayList<List<String>> actualData = fileTranslationHistoryDataAccessObject.getData();
        String[] actualHeader = fileTranslationHistoryDataAccessObject.getHeader();
        assertTrue(actualData.isEmpty());
        assertArrayEquals(new String[]{"word", "language", "translation", "time created"}, actualHeader);
    }
}