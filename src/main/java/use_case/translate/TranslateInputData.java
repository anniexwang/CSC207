package use_case.translate;

public class TranslateInputData {
    private String original;
    private String username;

    public TranslateInputData(String original, String username) {
        this.original = original;
        this.username = username;
    }

    public String getOriginal() {
        return original;
    }

    public String getUsername() {
        return username;
    }
}