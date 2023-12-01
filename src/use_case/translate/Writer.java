//package use_case.translate;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Map;
//
////TODO fix this class
//public class Writer {
//
//    // Call username
//    // Find username in already created csv
//    // Write TranslationHistory into correct index
//    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    private static void writeTranslationMap(Map<String, TranslationEntry> translationHistory, BufferedWriter writer) throws IOException {
//        for (Map.Entry<String, TranslationEntry> entry : translationHistory.entrySet()){
//            TranslationEntry translationEntry = entry.getValue();
//            String key = entry.getKey();
//            String value = translationEntry.getValue();
//            String time = dateFormat.format(translationEntry.getTime());
//
//            writer.write(String.format("%s,%s,%s\n", key, value, time));
//        }
//    }
//    static void writeNewFile(String filePath, Map<String, TranslationEntry> translationHistory) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
//            // Write header
//            writer.write("Original, Translation, Date & Time\n"); //Write header
//            writeTranslationMap(translationHistory, writer);
//        }
//    }
//
//    static void appendToFile(String filePath, Map<String, TranslationEntry> translationHistory) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
//            writeTranslationMap(translationHistory, writer);
//        }
//    }
//}
