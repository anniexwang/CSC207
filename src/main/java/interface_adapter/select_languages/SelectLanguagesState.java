package interface_adapter.select_languages;

import interface_adapter.history.HistoryState;

public class SelectLanguagesState extends HistoryState {
    private String[] languages;
    private String languagesError = null;

    public SelectLanguagesState(SelectLanguagesState copy) {
        languages = copy.languages;
        languagesError = copy.languagesError;
    }

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

