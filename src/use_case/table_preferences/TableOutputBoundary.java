package use_case.table_preferences;

public interface TableOutputBoundary {
    void prepareSuccessView(TableOutputData user);

    void prepareFailView(String error);
}
