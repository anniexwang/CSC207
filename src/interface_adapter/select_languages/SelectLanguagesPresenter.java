package interface_adapter.select_languages;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import use_case.select_languages.SelectLanguagesOutputBoundary;
import use_case.select_languages.SelectLanguagesOutputData;


public class SelectLanguagesPresenter implements SelectLanguagesOutputBoundary {
    private final SelectLanguagesViewModel selectLanguagesViewModel;
    private final HistoryViewModel historyViewModel;
    private ViewManagerModel viewManagerModel;

    public SelectLanguagesPresenter(ViewManagerModel viewManagerModel,
                                    SelectLanguagesViewModel selectLanguagesViewModel,
                                    HistoryViewModel historyViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.selectLanguagesViewModel = selectLanguagesViewModel;
        this.historyViewModel = historyViewModel;
    }

    @Override
    public void prepareSuccessView(SelectLanguagesOutputData response) {
        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        SelectLanguagesState selectLanguagesState = selectLanguagesViewModel.getState();
        HistoryState historyState = historyViewModel.getState();
        historyState.setLanguages(response.getLanguages());
//        tableState.setUsername(response.getUsername());
        this.historyViewModel.setState(historyState);
//        this.historyViewModel.getData();
        this.historyViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(historyViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SelectLanguagesState selectLanguagesState = selectLanguagesViewModel.getState();
//        tableState.setUsernameError(error);
        selectLanguagesViewModel.firePropertyChanged();
    }
}
