package use_case.translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translate;

public class TranslateInputData {
    final private String original;
    // the autodetected language of the String to be translated
    final private String originalLang;
    // the username of the user who made the request
    final private String username;
    // API Key required for the Google Translate API to function.
    private final String api = "AIzaSyAORNlqu0L0NZBzt-ddgWsSYWYTwEOut-A";
    // Set up API key
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

    public String getUsername()
    {
        return username;
    }
}
