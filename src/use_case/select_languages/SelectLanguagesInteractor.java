package use_case.select_languages;

public class SelectLanguagesInteractor implements SelectLanguagesInputBoundary {
    final SelectLanguagesUserDataAccessInterface userDataAccessObject;
    final SelectLanguagesOutputBoundary userPresenter;

    public SelectLanguagesInteractor(SelectLanguagesUserDataAccessInterface userSelectLanguagesDataAccessInterface,
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

