package use_case.translate;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;


public class TranslationHistory implements ITranslationHistory{
    private Map<String, TranslationEntry> translationHistory;

    public TranslationHistory() {
        this.translationHistory = new HashMap<>();
    }

    @Override
    public void addTranslation(String key, String value, Date time) {
        translationHistory.put(key, new TranslationEntry(value, time));
    }

    @Override
    public String getTranslation(String key) {
        TranslationEntry entry = translationHistory.get(key);
        if (entry != null){
            return entry.getValue();}
        return null;
    }


    @Override
    public List<String> getAllTranslations() {
        List<String> allTranslations = new ArrayList<>();
        for (TranslationEntry entry : translationHistory.values()){
            allTranslations.add(entry.getValue());
        }
        return allTranslations;
    }

    @Override
    public void write(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            Writer.appendToFile(filePath, translationHistory);
        } else {
            Writer.writeNewFile(filePath, translationHistory);
        }
    }

}
