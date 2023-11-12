package interface_adapter.number_languages;

public class NumberLanguagesState {
    private String numberLanguages;
    private String numberLanguagesError = null;

    public NumberLanguagesState(NumberLanguagesState copy) {
        numberLanguages = copy.numberLanguages;
        numberLanguagesError = copy.numberLanguagesError;

    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public NumberLanguagesState() {}


    public String getNumberLanguages() {
        return numberLanguages;
    }

    public String getNumberLanguagesError() {
        return numberLanguagesError;
    }

    public void setNumberLanguages(String numberLanguages) {
        this.numberLanguages = numberLanguages;
    }

    public void setNumberLanguagesError(String numberLanguagesError) {
        this.numberLanguagesError = numberLanguagesError;
    }
}

