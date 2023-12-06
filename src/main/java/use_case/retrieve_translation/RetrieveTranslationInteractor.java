package use_case.retrieve_translation;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import data_access.UserRetrieveTranslationDataAccessInterface;
import com.google.cloud.translate.Translate;

public class RetrieveTranslationInteractor implements RetrieveTranslationInputBoundary
{
    final UserRetrieveTranslationDataAccessInterface userDataAccessObject;
    final RetrieveTranslationOutputBoundary userPresenter;

    private final String api = "AIzaSyAORNlqu0L0NZBzt-ddgWsSYWYTwEOut-A";
    Translate translate = TranslateOptions.getDefaultInstance().getService();

    public RetrieveTranslationInteractor(UserRetrieveTranslationDataAccessInterface userDataAccessObject,
                                         RetrieveTranslationOutputBoundary userPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
    }
    // set target language to autodetected language. It shouldn't change anything.
    @Override
    public void execute(RetrieveTranslationInputData retrieveTranslationInputData) {
        String text = retrieveTranslationInputData.gettext();
        Translate translate = TranslateOptions.newBuilder().setApiKey(api).build().getService();
        Translation translation = translate.translate(text,
                Translate.TranslateOption.targetLanguage("en"));
        String translatedText = translation.getTranslatedText();
        RetrieveTranslationOutputData retrieveTranslationOutputData = new RetrieveTranslationOutputData(translatedText);
        userPresenter.prepareSuccessView(retrieveTranslationOutputData);
    }
}