package use_case.select_languages;

public interface SelectLanguagesOutputBoundary {
    void prepareSuccessView(SelectLanguagesOutputData user);

    void prepareFailView(String error);
}
