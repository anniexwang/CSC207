package use_case.translate;

public interface TranslateOutputBoundary {
    void prepareSuccessView(String translated);
    void prepareFailView(String error);
}
