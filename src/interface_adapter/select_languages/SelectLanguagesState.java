package interface_adapter.select_languages;

public class SelectLanguagesState {
    private String[] languages = {};
    private String languagesError = null;

    public SelectLanguagesState(SelectLanguagesState copy) {
        languages = copy.languages;
        languagesError = copy.languagesError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SelectLanguagesState() {}

    public String[] getLanguages() {
        return languages;
    }

    public String getLanguagesError() {
        return languagesError;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setLanguagesError(String languagesError) {
        this.languagesError = languagesError;
    }
}

