package use_case.translate;

public interface TranslateOutputBoundary {
    void prepareSuccessView(String translateOutputData);
    void prepareFailView(String error);
}
