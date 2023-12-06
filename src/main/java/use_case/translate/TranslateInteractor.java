package use_case.translate;
import use_case.retrieve_translation.RetrieveTranslationInteractor;
import com.google.cloud.translate.*;
import entity.UserFactory;
import use_case.login.LoginInputData;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupInputBoundary;
import use_case.translate.TranslateOutputBoundary;
import use_case.translate.TranslateUserDataAccessInterface;
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
        String original = translateInputData.getOriginal();

        if (original.isEmpty()) {
            translationPresenter.prepareFailView("Translation Field Empty");
            return;
        }

        // Call the translation service or library here
        String translated = translate(original);

        // Prepare the success view with the translated text
        translationPresenter.prepareSuccessView(translated);
    }

    private String translate(String original) {
        try {
            // Set the API Key
            String apiKey = "AIzaSyAORNlqu0L0NZBzt-ddgWsSYWYTwEOut-A";
            Translate translate = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();

            Translation translation = translate.translate(original, Translate.TranslateOption.targetLanguage("en"));
            return translation.getTranslatedText();
        } catch (Exception e) {
            e.printStackTrace();
            return original;
        }
    }}