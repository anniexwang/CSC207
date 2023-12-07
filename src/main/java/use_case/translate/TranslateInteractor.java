package use_case.translate;
import use_case.retrieve_translation.RetrieveTranslationInteractor;
import com.google.cloud.translate.*;
import entity.UserFactory;
import use_case.login.LoginInputData;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import use_case.retrieve_translation.RetrieveTranslationOutputData;
import use_case.signup.SignupInputBoundary;
import use_case.translate.TranslateOutputBoundary;
import use_case.translate.TranslateUserDataAccessInterface;
import use_case.translate.TranslateOutputBoundary;
import use_case.translate.TranslateUserDataAccessInterface;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslateInteractor implements TranslateInputBoundary {

    final TranslateOutputBoundary translationPresenter;
    final TranslateUserDataAccessInterface userDataAccess;

    public TranslateInteractor(
                           TranslateOutputBoundary translateOutputBoundary, TranslateUserDataAccessInterface userDataAccess) {

        this.translationPresenter = translateOutputBoundary;
        this.userDataAccess = userDataAccess;
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
//todo: change the "en" to the language detected
        // Create a translation object
        Map<String, String> translationMap = new HashMap<>();
        translationMap.put("en", translated);
        LocalDateTime timeCreated = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimeCreated = timeCreated.format(formatter);
        List<Object> translationObject = Arrays.asList(original, translationMap, formattedTimeCreated);

        // Add the translation to the user's history
        try {
            userDataAccess.updateAccounts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        userDataAccess.addTranslation(translateInputData.getUsername(), translationObject);

        try {
            userDataAccess.updateAccounts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        translationPresenter.prepareSuccessView(translated);
    }

    private String translate(String original) {
        try {
            // Set the API Key
            String apiKey = "AIzaSyAORNlqu0L0NZBzt-ddgWsSYWYTwEOut-A";
            Translate translate = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService();
            // Input's autodetected language
            String originalLang = translate.detect(original).getLanguage();
            Translation translation = translate.translate(original,
                    Translate.TranslateOption.targetLanguage("en"));
            String translationOutputData = translation.getTranslatedText();
            translationPresenter.prepareSuccessView(translationOutputData);
            return translationOutputData;
        } catch (Exception e) {
            e.printStackTrace();
            return original;
        }
    }
}