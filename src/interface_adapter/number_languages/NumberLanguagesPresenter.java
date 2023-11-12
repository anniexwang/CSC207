package interface_adapter.table_preferences;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import use_case.table_preferences.TableOutputBoundary;
import use_case.table_preferences.TableOutputData;

public class TablePresenter implements TableOutputBoundary {
    private final TableViewModel tableViewModel;
    private final HistoryViewModel historyViewModel;
    private ViewManagerModel viewManagerModel;

    public TablePresenter(ViewManagerModel viewManagerModel,
                           TableViewModel tableViewModel,
                           HistoryViewModel historyViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.tableViewModel = tableViewModel;
        this.historyViewModel = historyViewModel;
    }

    @Override
    public void prepareSuccessView(TableOutputData response) {
        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        TableState tableState = tableViewModel.getState();
        HistoryState historyState = historyViewModel.getState();
//        tableState.setUsername(response.getUsername());
        this.historyViewModel.setState(historyState);
        historyViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(historyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TableState tableState = tableViewModel.getState();
//        tableState.setUsernameError(error);
        tableViewModel.firePropertyChanged();
    }
}
