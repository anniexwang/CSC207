package interface_adapter.table_preferences;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.number_languages.NumberLanguagesState;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import interface_adapter.signup.SignupState;
import use_case.table_preferences.TableOutputBoundary;
import use_case.table_preferences.TableOutputData;

public class TablePresenter implements TableOutputBoundary {
    private final TableViewModel tableViewModel;
    private final NumberLanguagesViewModel numberLanguagesViewModel;

    private final HistoryViewModel historyViewModel;
    private ViewManagerModel viewManagerModel;

    public TablePresenter(ViewManagerModel viewManagerModel,
                          TableViewModel tableViewModel,
                          NumberLanguagesViewModel numberLanguagesViewModel,
                          HistoryViewModel historyViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.tableViewModel = tableViewModel;
        this.numberLanguagesViewModel = numberLanguagesViewModel;
        this.historyViewModel = historyViewModel;
    }

    @Override
    public void prepareSuccessView(TableOutputData response) {
        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

//        TableState tableState = tableViewModel.getState();

        NumberLanguagesState numberLanguagesState = numberLanguagesViewModel.getState();
        HistoryState historyState = historyViewModel.getState();
//        HistoryState historyState = historyViewModel.getState();
//        historyState.setHistoryTableType(response.getTableType());
//        System.out.println("TablePresenter response.getTableType()" + response.getTableType());
//        historyViewModel.setTableType(response.getTableType());
//        historyState.setSortType(response.getSortType());
//        HistoryState historyState = historyViewModel.getState();

//        tableState.setTableType(response.getTableType());
//        tableState.setSortType(response.getSortType());
        //TODO: maybe add History state and set table type and sort type?
        if (response.getTableType().equals("By Language")) {
            this.numberLanguagesViewModel.setState(numberLanguagesState);
            this.numberLanguagesViewModel.firePropertyChanged();
//        System.out.println("reached view manager model" + numberLanguagesViewModel.getViewName());
            this.viewManagerModel.setActiveView(numberLanguagesViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }
        else {
            this.historyViewModel.setState(historyState);
//            this.historyViewModel.getData();
            this.historyViewModel.firePropertyChanged();
//        System.out.println("reached view manager model" + numberLanguagesViewModel.getViewName());
            this.viewManagerModel.setActiveView(historyViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }
    }

    @Override
    public void prepareFailView(String error) {
        TableState tableState = tableViewModel.getState();
        tableState.setTableTypeError(error);
        tableViewModel.firePropertyChanged();

    }
}
