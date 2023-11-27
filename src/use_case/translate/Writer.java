package use_case.translate;

// todo update pom.xml
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.List;

public class Writer {

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static void writeTranslationMap(String username, Map<String, TranslationEntry> translationHistory, BufferedWriter writer) throws IOException {
        for (Map.Entry<String, TranslationEntry> entry : translationHistory.entrySet()){
            TranslationEntry translationEntry = entry.getValue();
            String key = entry.getKey();
            String value = translationEntry.getTranslation();
            String time = dateFormat.format(translationEntry.getTime());

            writer.write(String.format("%s,%s,%s\n", key, value, time));
        }
    }

    private static int indexOf(String[] row, String targetColumn) {
        for (int i = 0; i < row.length; i++) {
            if (row[i].equals(targetColumn)) {
                return i;
            }
        }
        return -1;
    }

    public static void insertTranslationHistoryToFile(String username, String filePath, List<String> translationHistory) {
        String columnNameToUpdate = "Translations History";

        try {
            // Read csv file
            CSVReader reader = new CSVReader(new FileReader(filePAth));
            List<String[]> lines = reader.readAll();
            reader.close();

            // Find row of username
            for (String[] line : lines) {
                if (line.length > 0 && line[0].equals(username)) {
                    // Insert the TranslationHistory list
                    int columnIndex = indexOf(line, columnNameToUpdate);
                    if (columnIndex != -1) {
                        line[columnIndex] = translationHistory.toString();
                    }
                }
                break;
            }
            // Rewrite all lines with updated row
            CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath));
            writer.writeAll(lines);
            writer.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}



