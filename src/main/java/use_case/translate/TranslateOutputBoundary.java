package use_case.translate;

// Interface for TranslateOutputBoundary
public interface TranslateOutputBoundary {
    void prepareSuccessView(String translateOutputData);
    void prepareFailView(String error);
}
