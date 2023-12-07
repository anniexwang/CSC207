package data_access;
import entity.User;
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
            headers = new String[]{"word", "language", "translation", "time created"};
            String row;
            while ((row = reader.readLine()) != null) {
                String[] parts = row.split(",", 3);
                if (parts.length < 3) {
                    continue;
                }

                String username = parts[0].trim();
                String restOfRow = parts[2].trim();

                int endIndex = restOfRow.indexOf("]],") + 2;
                String translationHistoryRaw = restOfRow.substring(0, endIndex);

                String[] translationHistoryRawSplit = translationHistoryRaw.split(",");
                for (int i = 0; i < translationHistoryRawSplit.length - 2; i += 3) {
                    List<String> translationHistoryList = new ArrayList<>();
                    translationHistoryList.add(username);
                    if (!translationHistoryRawSplit[i].replaceAll("^\\[\\[|\\]\\]$", "").equals("[Enter Your Text Here")) {
                        String translationRow = translationHistoryRawSplit[i].replaceAll("^\\[\\[|\\]\\]$", "") + "," + translationHistoryRawSplit[i + 1] + "," + translationHistoryRawSplit[i + 2].replaceAll("^\\[\\[|\\]\\]$", "");
                        translationHistoryList.add(translationRow);
                        data.add(translationHistoryList);
                    }
                }
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