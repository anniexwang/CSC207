package interface_adapter.table_preferences;

import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInputData;

public class TableController {
    final TableInputBoundary tableUseCaseInteractor;
    public TableController(TableInputBoundary tableUseCaseInteractor) {
        this.tableUseCaseInteractor = tableUseCaseInteractor;
    }

    public void execute(String tableType, String sortType) {
        TableInputData tableInputData = new TableInputData(
                tableType, sortType);

        tableUseCaseInteractor.execute(tableInputData);
    }
}
