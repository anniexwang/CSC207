package use_case.select_languages;

import data_access.FileTranslationHistoryDataAccessObject;

import data_access.FileUserDataAccessObject;
import interface_adapter.history.HistoryViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectLanguagesInteractor implements SelectLanguagesInputBoundary {
    final SelectLanguagesUserDataAccessInterface userDataAccessObject;
    final SelectLanguagesOutputBoundary languagesPresenter;

    final HistoryViewModel historyViewModel;

    private final ArrayList<List<String>> fileData = FileTranslationHistoryDataAccessObject.getData();

    public SelectLanguagesInteractor(SelectLanguagesUserDataAccessInterface userSelectLanguagesDataAccessInterface,
                                     SelectLanguagesOutputBoundary selectLanguagesOutputBoundary,
                                     HistoryViewModel historyViewModel) {
        this.userDataAccessObject = userSelectLanguagesDataAccessInterface;
        this.languagesPresenter = selectLanguagesOutputBoundary;
        this.historyViewModel = historyViewModel;
    }

    @Override
    public void execute(SelectLanguagesInputData selectLanguagesInputData) {
        if (checkInputLanguages(selectLanguagesInputData.getLanguages())){
            SelectLanguagesOutputData selectLanguagesOutputData = new SelectLanguagesOutputData(selectLanguagesInputData.getLanguages());
            languagesPresenter.prepareSuccessView(selectLanguagesOutputData);
        }
        else {
            languagesPresenter.prepareFailView("language(s) not valid");
        }

    }

    public boolean checkInputLanguages(String[] languages){
        boolean validLanguages = true;
        String[] languageHistory = historyViewModel.languageHistory(historyViewModel.convertToStringArray(fileData));
        for (String language : languages){
            if (!Arrays.asList(languageHistory).contains(language.toLowerCase())){
                validLanguages = false;
                return validLanguages;
            }
        }
        return validLanguages;
    }
}