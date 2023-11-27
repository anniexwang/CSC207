package use_case.number_languages;

public interface NumberLanguagesOutputBoundary {
    void prepareSuccessView(NumberLanguagesOutputData user);

    void prepareFailView(String error);
}
