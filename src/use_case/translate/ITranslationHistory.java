package use_case.translate;

import java.util.List;
import java.util.Date;
import java.io.IOException;


public interface ITranslationHistory {
    void addTranslation(String in, String out, Date time);
    String getTranslation(String in);
    List<String> getAllTranslations();
    void write(String filePath) throws IOException;
}
