package interface_adapter.table_preferences;

import interface_adapter.ViewManagerModel;
import interface_adapter.number_languages.NumberLanguagesState;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import use_case.table_preferences.TableOutputBoundary;
import use_case.table_preferences.TableOutputData;

public class TablePresenter implements TableOutputBoundary {
    private final TableViewModel tableViewModel;
    private final NumberLanguagesViewModel numberLanguagesViewModel;
    private ViewManagerModel viewManagerModel;

    public TablePresenter(ViewManagerModel viewManagerModel,
                           TableViewModel tableViewModel,
                           NumberLanguagesViewModel numberLanguagesViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.tableViewModel = tableViewModel;
        this.numberLanguagesViewModel = numberLanguagesViewModel;
    }

    @Override
    public void prepareSuccessView(TableOutputData response) {
        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        TableState tableState = tableViewModel.getState();
        NumberLanguagesState numberLanguagesState = numberLanguagesViewModel.getState();
//        tableState.setTableType(response.getTableType());
//        tableState.setSortType(response.getSortType());
        this.numberLanguagesViewModel.setState(numberLanguagesState);
        numberLanguagesViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(numberLanguagesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TableState tableState = tableViewModel.getState();
        tableState.setTableTypeError(error);
        tableViewModel.firePropertyChanged();
    }
}
