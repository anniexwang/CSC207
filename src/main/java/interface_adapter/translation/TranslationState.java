package interface_adapter.translation;

import interface_adapter.login.LoginState;

public class TranslationState {
    private String original = "";
    private String originalError = null;
    private String translated = "";
    private String translatedError = null;

    public TranslationState() {}
    public String getOriginal() {
        return original;
    }
    public String getOriginalError() {
        return originalError;
    }
    public String getTranslated() {
        return translated;
    }
    public String getTranslatedError() {
        return translatedError;
    }
    public void setOriginal(String original) {
        this.original = original;
    }
    public void setOriginalError(String originalError) {
        this.originalError = originalError;
    }
    public void setTranslated(String translated) {
        this.translated = translated;
    }
    public void setTranslatedError(String translatedError) {
        this.translatedError = translatedError;
    }
}
