package use_case.translate;

public class TranslateOutputData {
    private final String translated;
    private boolean useCaseFailed;
    public TranslateOutputData(String translated, boolean useCaseFailed) {
        this.translated = translated;

        this.useCaseFailed = useCaseFailed;
    }
    public String getTranslated() {
        return translated;
    }
}
