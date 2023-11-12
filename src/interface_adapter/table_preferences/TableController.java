package interface_adapter.table_preferences;

import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInputData;

public class TableController {
    final TableInputBoundary userTableUseCaseInteractor;
    public TableController(TableInputBoundary userTableUseCaseInteractor) {
        this.userTableUseCaseInteractor = userTableUseCaseInteractor;
    }

    public void execute(String tableType, String sortType) {
        TableInputData tableInputData = new TableInputData(
                tableType, sortType);

        userTableUseCaseInteractor.execute(tableInputData);
    }
}
