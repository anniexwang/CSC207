package interface_adapter.table_preferences;

import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInputData;
import interface_adapter.table_preferences.TablePresenter;
import interface_adapter.table_preferences.TableViewModel;

public class TableController {
    final TableInputBoundary tableUseCaseInteractor;
    private final TablePresenter tablePresenter;


    public TableController(TableInputBoundary tableUseCaseInteractor,
                           TablePresenter tablePresenter,
                           TableViewModel tableViewModel) {
        this.tableUseCaseInteractor = tableUseCaseInteractor;
        this.tablePresenter = tablePresenter;
    }

    public void backToTranslation() {
        tablePresenter.backToTranslation();
    }

    public void execute(String tableType, String sortType) {
        TableInputData tableInputData = new TableInputData(
                tableType, sortType);

        tableUseCaseInteractor.execute(tableInputData);
    }
}
