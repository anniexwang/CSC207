package use_case.translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import data_access.UserRetrieveTranslationDataAccessInterface;
import com.google.cloud.translate.Translate;

public class TranslateInputData {
    final private String original;
    final private String originalLang;
    private final String api = "AIzaSyAORNlqu0L0NZBzt-ddgWsSYWYTwEOut-A";
    private String username;
    Translate translate = TranslateOptions.newBuilder().setApiKey(api).build().getService();
    public TranslateInputData(String original, String username) {

        this.original = original;
        this.username = username;
        this.originalLang = translate.detect(original).getLanguage();
    }
    String getOriginal() {
        return original;
    }

    String getOriginalLang(){
        return originalLang;
    }
    public String getUsername() {
        return username;
    }
}
