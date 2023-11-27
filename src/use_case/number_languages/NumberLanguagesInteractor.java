package use_case.number_languages;

import data_access.UserNumberLanguagesDataAccessInterface;

public class NumberLanguagesInteractor implements NumberLanguagesInputBoundary {
    final UserNumberLanguagesDataAccessInterface userDataAccessObject;
    final NumberLanguagesOutputBoundary userPresenter;

    public NumberLanguagesInteractor(UserNumberLanguagesDataAccessInterface userNumberLanguagesDataAccessInterface,
                                     NumberLanguagesOutputBoundary tableOutputBoundary) {
        this.userDataAccessObject = userNumberLanguagesDataAccessInterface;
        this.userPresenter = tableOutputBoundary;
    }

    @Override
    public void execute(NumberLanguagesInputData numberLanguagesInputData) {
        NumberLanguagesOutputData numberLanguagesOutputData = new NumberLanguagesOutputData(numberLanguagesInputData.getNumberLanguages());
        userPresenter.prepareSuccessView(numberLanguagesOutputData);
        }
    }

