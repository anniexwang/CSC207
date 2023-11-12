package interface_adapter.select_languages;

import use_case.select_languages.SelectLanguagesInputBoundary;
import use_case.select_languages.SelectLanguagesInputData;

public class SelectLanguagesController {
    final SelectLanguagesInputBoundary userSelectLanguagesUseCaseInteractor;
    public SelectLanguagesController(SelectLanguagesInputBoundary userSelectLanguagesUseCaseInteractor) {
        this.userSelectLanguagesUseCaseInteractor = userSelectLanguagesUseCaseInteractor;
    }

    public void execute(String[] languages) {
        SelectLanguagesInputData selectLanguagesInputData = new SelectLanguagesInputData(languages);

        userSelectLanguagesUseCaseInteractor.execute(selectLanguagesInputData);
    }
}
