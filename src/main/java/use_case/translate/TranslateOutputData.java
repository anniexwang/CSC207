package use_case.translate;

public class TranslateOutputData {
    // The translated String
    private final String translated;
    // Whether or not Google Translate was able to translate the String.
    private boolean useCaseFailed;
    public TranslateOutputData(String translated, boolean useCaseFailed) {
        this.translated = translated;

        this.useCaseFailed = useCaseFailed;
    }
    public String getTranslated() {
        return translated;
    }
}
