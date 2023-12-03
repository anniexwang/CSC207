package data_access;
import use_case.select_languages.SelectLanguagesUserDataAccessInterface;
import use_case.table_preferences.TableUserDataAccessInterface;
import java.io.*;
import java.util.*;
public class FileTranslationHistoryDataAccessObject implements TableUserDataAccessInterface, SelectLanguagesUserDataAccessInterface {
    private final File csvFile;
    private static String[] headers = null;
    private static final ArrayList<List<String>> data = new ArrayList<>();
    public FileTranslationHistoryDataAccessObject(String csvPath) throws IOException {

        csvFile = new File(csvPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String header = reader.readLine();
            headers = header.split(",");
            String row;
            while ((row = reader.readLine()) != null) {
                List<String> cols = new ArrayList<>();
                cols.add(row);
                data.add(cols);
            }
        }
    }

    public static String[] getHeader() {
        return headers;
    }
    public static ArrayList<List<String>> getData() {
        return data;
    }
}