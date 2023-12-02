package use_case.translate;

import use_case.translate.TranslateOutputData;

public interface TranslateOutputBoundary {
    void prepareSuccessView(TranslateOutputData translated);
    void prepareFailView(String error);
}
