package use_case.retrieve_translation;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import data_access.UserRetrieveTranslationDataAccessInterface;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.Translate;
import use_case.retrieve_favourites.RetrieveFavouritesInputData;

public class RetrieveTranslationInteractor implements RetrieveTranslationInputBoundary
{
    final UserRetrieveTranslationDataAccessInterface userDataAccessObject;
    final RetrieveTranslationOutputBoundary userPresenter;

    private String api = "AIzaSyAORNlqu0L0NZBzt-ddgWsSYWYTwEOut-A";

    public RetrieveTranslationInteractor(UserRetrieveTranslationDataAccessInterface userDataAccessObject,
                                         RetrieveTranslationOutputBoundary userPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(RetrieveTranslationInputData retrieveTranslationInputData) {
        String text = retrieveTranslationInputData.gettext();
        Translate translate = TranslateOptions.newBuilder().setApiKey(api).build().getService();
        Translation translation = translate.translate(retrieveTranslationInputData.gettext(),
                Translate.TranslateOption.targetLanguage(retrieveTranslationInputData.gettargetlanguage()));
        String translatedText = translation.getTranslatedText();
        RetrieveTranslationOutputData retrieveTranslationOutputData = new RetrieveTranslationOutputData(translatedText);
        userPresenter.prepareSuccessView(retrieveTranslationOutputData);
    }
}
