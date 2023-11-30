package interface_adapter.history;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class HistoryViewReader {
    //Helper class for HistoryViewModel
    public static String[][] readData(HistoryViewModel historyViewModel, String filePath) {
        String[][] data;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> csvData = reader.readAll();
            // TODO implement what data we want to read
            int rows = csvData.size();
            int allColumns = csvData.get(0).length;
            data = new String[rows][allColumns];
            //String data[][] = {{"a","b"},{"c","d"},{"e","f"},{"g","h"},{"i","j"},{"k","l"},{"m","n"},{"o","p"},{"q","r"},{"s","t"},{"u","v"},{"w","x"},{"y","z"},
            //{"a","b"},{"c","d"},{"e","f"},{"g","h"},{"i","j"},{"k","l"},{"m","n"},{"o","p"},{"q","r"},{"s","t"},{"u","v"},{"w","x"},{"y","z"}};

            return data
        } catch (IOException | CsvException e) {
            throw new RuntimeException(String.valueOf(e));
        }}

    public static String[] readTitles(HistoryViewModel historyViewModel, String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> csvData = reader.readAll();
            // TODO what index is title at? vv
            String[] titles = csvData.get(0);

            return titles;
        } catch (IOException | CsvException e) {
            throw new RuntimeException(String.valueOf(e));
        }
    }
}

