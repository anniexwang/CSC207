package use_case.clear;

public interface ClearOutputBoundary {
    void prepareSuccessView(ClearOutputData clearOutputData);

    void prepareFailView(String error);
}
