package use_case.translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translate;

public class TranslateInputData {
    final private String original;
    final private String originalLang;
    private final String api = "AIzaSyAORNlqu0L0NZBzt-ddgWsSYWYTwEOut-A";
    Translate translate = TranslateOptions.getDefaultInstance().getService();
    public TranslateInputData(String original, String username) {

        this.original = original;
        this.originalLang = translate.detect(original).getLanguage();
    }
    String getOriginal() {
        return original;
    }

    String getOriginalLang(){
        return originalLang;
    }
}
