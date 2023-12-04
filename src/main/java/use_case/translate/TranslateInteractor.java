package use_case.translate;

import entity.UserFactory;
import use_case.login.LoginInputData;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupInputBoundary;
import use_case.translate.TranslateOutputBoundary;
import use_case.translate.TranslateUserDataAccessInterface;

public class TranslateInteractor implements TranslateInputBoundary {

    final TranslateOutputBoundary translationPresenter;

    public TranslateInteractor(
                           TranslateOutputBoundary translateOutputBoundary) {

        this.translationPresenter = translateOutputBoundary;
    }

    // execute method will process translation request
    @Override
    public void execute(TranslateInputData translateInputData) {
        // Extract original phrase to be translated
        String original = translateInputData.getOriginal();

        // error - no phrase to be translated
        if (translateInputData.getOriginal().isEmpty()) {
            translationPresenter.prepareFailView("Translation Field Empty");
            return;
        }

        // not sure if there's some missing logic here
    }
}
