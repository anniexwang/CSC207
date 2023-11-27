package use_case.retrieve_translation;

public interface RetrieveTranslationOutputBoundary {
    void prepareSuccessView(RetrieveTranslationOutputData retrieveTranslationOutputData);

    void prepareFailView(String error);
}
