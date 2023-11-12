package use_case.select_languages;

import data_access.UserSelectLanguagesDataAccessInterface;

public class SelectLanguagesInteractor implements SelectLanguagesInputBoundary {
    final UserSelectLanguagesDataAccessInterface userDataAccessObject;
    final SelectLanguagesOutputBoundary userPresenter;

    public SelectLanguagesInteractor(UserSelectLanguagesDataAccessInterface userSelectLanguagesDataAccessInterface,
                                     SelectLanguagesOutputBoundary selectLanguagesOutputBoundary) {
        this.userDataAccessObject = userSelectLanguagesDataAccessInterface;
        this.userPresenter = selectLanguagesOutputBoundary;
    }

    @Override
    public void execute(SelectLanguagesInputData selectLanguagesInputData) {
        SelectLanguagesOutputData selectLanguagesOutputData = new SelectLanguagesOutputData(selectLanguagesInputData.getLanguages());
        userPresenter.prepareSuccessView(selectLanguagesOutputData);
        }
    }

