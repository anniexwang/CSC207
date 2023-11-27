package use_case.retrieve_translation;

public class RetrieveTranslationOutputData {

    private String text;
    public RetrieveTranslationOutputData(String text) {this.text = text; }

    public String getTranslation() {
        return text;
    }
}
