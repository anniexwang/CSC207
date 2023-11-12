package interface_adapter.table_preferences;

import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInputData;

public class TableController {
    final TableInputBoundary userTableUseCaseInteractor;
    public TableController(TableInputBoundary userTableUseCaseInteractor) {
        this.userTableUseCaseInteractor = userTableUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        TableInputData tableInputData = new TableInputData(
                username, password1, password2);

        userTableUseCaseInteractor.execute(tableInputData);
    }
}
