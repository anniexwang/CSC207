//package use_case.translate;
//
//import java.io.IOException;
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Date;
//
//
//public class TranslationHistory implements ITranslationHistory{
//    private final Map<String, TranslationEntry> translationHistory;
//
//    public TranslationHistory() {
//        this.translationHistory = new HashMap<>();
//    }
//
//    @Override
//    public void addTranslation(String key, String inLanguage, String translation, String outLanguage, Date time) {
//        translationHistory.put(key, new TranslationEntry(inLanguage, translation, outLanguage, time));
//    }
//
//    @Override
//    public String getTranslation(String key) {
//        TranslationEntry entry = translationHistory.get(key);
//        if (entry != null){
//            return entry.getTranslation();}
//        return null;
//    }
//
//    @Override
//    public List<String> getAllTranslations() {
//        List<String> allTranslations = new ArrayList<>();
//        for (TranslationEntry entry : translationHistory.values()){
//            allTranslations.add(entry.getTranslation());
//            allTranslations.add(entry.getOutLanguage());
//        }
//        return allTranslations;
//    }
//
//    @Override
//    public List<String> getFullTranslationHistory() {
//        List<String> fullTranslationHistory = new ArrayList<>();
//        for (TranslationEntry entry : translationHistory.values()){
//            List<String> translationInfo = new ArrayList<>();
//
//            fullTranslationHistory.add(String.valueOf(entry));
//            fullTranslationHistory.add(entry.getInLanguage());
//            fullTranslationHistory.add(entry.getTranslation());
//            fullTranslationHistory.add(entry.getOutLanguage());
//            fullTranslationHistory.add(entry.getTime());
//        }
//        return fullTranslationHistory;
//    }
//
//    @Override
//    public void write(String filePath) throws IOException {
//        File file = new File(filePath);
//        if (file.exists()) {
//            Writer.appendToFile(filePath, translationHistory);
//        } else {
//            Writer.writeNewFile(filePath, translationHistory);
//        }
//    }
//}
