package use_case.translate;

import java.util.List;
import java.util.Date;
import java.io.IOException;

// Interface for TranslationHistory
public interface ITranslationHistory {
    void addTranslation(String in, String inLanguage, String translation, String outLanguage, Date time);
    String getTranslation(String in);
    List<String> getAllTranslations();
    List<String> getFullTranslationHistory();
    void write(String username, String filePath) throws IOException;
}

