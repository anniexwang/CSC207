package use_case.number_languages;

public class NumberLanguagesInteractor implements NumberLanguagesInputBoundary {
    final NumberLanguagesUserDataAccessInterface userDataAccessObject;
    final NumberLanguagesOutputBoundary userPresenter;

    public NumberLanguagesInteractor(NumberLanguagesUserDataAccessInterface userNumberLanguagesDataAccessInterface,
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

