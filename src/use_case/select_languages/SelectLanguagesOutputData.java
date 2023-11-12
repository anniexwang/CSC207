package use_case.select_languages;

public class SelectLanguagesOutputData {
    private String[] languages;
    public SelectLanguagesOutputData(String[] languages) {
        this.languages = languages;
    }

    public String[] getLanguages() {
        return languages;
    }

}
