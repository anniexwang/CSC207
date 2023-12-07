package interface_adapter.table_preferences;

import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.translation.TranslationViewModel;
import interface_adapter.select_languages.SelectLanguagesState;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import use_case.table_preferences.TableOutputBoundary;
import use_case.table_preferences.TableOutputData;

public class TablePresenter implements TableOutputBoundary {
    private final TableViewModel tableViewModel;

    private final SelectLanguagesViewModel selectLanguagesViewModel;

    private final HistoryViewModel historyViewModel;
    private ViewManagerModel viewManagerModel;
    private final TranslationViewModel translationViewModel;

    public TablePresenter(ViewManagerModel viewManagerModel,
                          TableViewModel tableViewModel,
                          SelectLanguagesViewModel selectLanguagesViewModel,
                          HistoryViewModel historyViewModel,
                          TranslationViewModel translationViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.tableViewModel = tableViewModel;
        this.selectLanguagesViewModel = selectLanguagesViewModel;
        this.historyViewModel = historyViewModel;
        this.translationViewModel = translationViewModel;
    }

    @Override
    public void prepareSuccessView(TableOutputData response) {
        SelectLanguagesState selectLanguagesState = selectLanguagesViewModel.getState();

        HistoryState historyState = historyViewModel.getState();
        if (response.getTableType().equals("By Language")) {
            this.selectLanguagesViewModel.setState(selectLanguagesState);
            this.selectLanguagesViewModel.firePropertyChanged();
            this.viewManagerModel.setActiveView(selectLanguagesViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }
        else {
            this.historyViewModel.setState(historyState);
            this.historyViewModel.firePropertyChanged();
            this.viewManagerModel.setActiveView(historyViewModel.getViewName());
            this.viewManagerModel.firePropertyChanged();
        }
    }

    public void backToTranslation() {
        this.viewManagerModel.setActiveView(translationViewModel.getViewName()); // Use the correct view name for SignupView
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TableState tableState = tableViewModel.getState();
        tableState.setTableTypeError(error);
        tableViewModel.firePropertyChanged();
    }
}
