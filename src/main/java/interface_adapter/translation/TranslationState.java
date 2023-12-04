package interface_adapter.translation;

import interface_adapter.login.LoginState;
import interface_adapter.signup.SignupState;

public class TranslationState {
    private String original = "";
    private String originalError = null;
    private String translated = "";
    private String translatedError = null;
    private String username = "";
    private String usernameError = null;

    public TranslationState(TranslationState copy) {
        original = copy.original;
        originalError = copy.originalError;
        translated = copy.translated;
        translatedError = copy.translatedError;
        username = copy.username;
        usernameError = copy.usernameError;
    }

    public TranslationState() {}

    public String getOriginal() {
        return original;
    }
    public String getUsername() {return username;}
    public String getUsernameError(){return usernameError;}
    public void setUsernameError(){this.username = username;}
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
    public void setUsername(String username){this.username = username;}
    public void setTranslatedError(String translatedError) {
        this.translatedError = translatedError;
    }

    public void clearState() {
        original = "";
        originalError = null;
        translated = "";
        translatedError = null;
    }
}
