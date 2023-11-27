package interface_adapter.number_languages;

import use_case.number_languages.NumberLanguagesInputBoundary;
import use_case.number_languages.NumberLanguagesInputData;
import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInputData;

public class NumberLanguagesController {
    final NumberLanguagesInputBoundary userNumberLanguagesUseCaseInteractor;
    public NumberLanguagesController(NumberLanguagesInputBoundary userNumberLanguagesUseCaseInteractor) {
        this.userNumberLanguagesUseCaseInteractor = userNumberLanguagesUseCaseInteractor;
    }

    public void execute(String numberLanguages) {
        NumberLanguagesInputData numberLanguagesInputData = new NumberLanguagesInputData(
                numberLanguages);


        userNumberLanguagesUseCaseInteractor.execute(numberLanguagesInputData);
    }
}
