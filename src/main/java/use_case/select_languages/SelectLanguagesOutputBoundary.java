package use_case.select_languages;

public interface SelectLanguagesOutputBoundary {
    void prepareSuccessView(SelectLanguagesOutputData response);

    void prepareFailView(String error);
}
