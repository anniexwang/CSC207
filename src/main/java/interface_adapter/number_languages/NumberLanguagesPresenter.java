package interface_adapter.number_languages;

import interface_adapter.ViewManagerModel;
import interface_adapter.select_languages.SelectLanguagesState;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import interface_adapter.number_languages.NumberLanguagesState;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import use_case.number_languages.NumberLanguagesOutputBoundary;
import use_case.number_languages.NumberLanguagesOutputData;
import use_case.table_preferences.TableOutputBoundary;
import use_case.table_preferences.TableOutputData;

public class NumberLanguagesPresenter implements NumberLanguagesOutputBoundary {
    private final NumberLanguagesViewModel numberLanguagesViewModel;
    private final SelectLanguagesViewModel selectLanguagesViewModel;
    private ViewManagerModel viewManagerModel;

    public NumberLanguagesPresenter(ViewManagerModel viewManagerModel,
                                    NumberLanguagesViewModel numberLanguagesViewModel,
                                    SelectLanguagesViewModel selectLanguagesViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.numberLanguagesViewModel = numberLanguagesViewModel;
        this.selectLanguagesViewModel = selectLanguagesViewModel;
    }

    @Override
    public void prepareSuccessView(NumberLanguagesOutputData response) {
        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        NumberLanguagesState numberLanguagesState = numberLanguagesViewModel.getState();
        SelectLanguagesState selectLanguagesState = selectLanguagesViewModel.getState();
        this.selectLanguagesViewModel.setState(selectLanguagesState);
        selectLanguagesViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(selectLanguagesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        NumberLanguagesState numberLanguagesState = numberLanguagesViewModel.getState();
//        tableState.setUsernameError(error);
        numberLanguagesViewModel.firePropertyChanged();
    }
}
