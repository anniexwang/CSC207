package use_case.table_preferences;

public interface TableOutputBoundary {
    void prepareSuccessView(TableOutputData response);

    void prepareFailView(String error);
}
