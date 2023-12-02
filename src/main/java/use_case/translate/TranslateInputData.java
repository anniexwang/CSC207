package use_case.translate;

public class TranslateInputData {
    final private String original;
    public TranslateInputData(String original) {
        this.original = original;
    }
    String getOriginal() {
        return original;
    }
}
