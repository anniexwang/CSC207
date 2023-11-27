package use_case.table_preferences;

public interface TableOutputBoundary {
    void prepareSuccessView(TableOutputData user); //TODO: change names for all outputboundary

    void prepareFailView(String error);
}
