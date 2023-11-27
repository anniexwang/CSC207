package use_case.select_languages;

public class SelectLanguagesInputData {
    final private String[] languages;

    public SelectLanguagesInputData(String[] languages) {
        this.languages = languages;
    }

    String[] getLanguages() {return languages;}
}
