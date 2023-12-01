package interface_adapter.translation;
import interface_adapter.translation.TranslationPresenter;
import use_case.clear.ClearInputBoundary;
import use_case.translate.TranslateInputBoundary;
import use_case.translate.TranslateInputData;
public class TranslationController {
    private final TranslateInputBoundary translateUseCaseInteractor;
    private final TranslationPresenter translationPresenter;

    public TranslationController(TranslateInputBoundary translateUseCaseInteractor, TranslationPresenter translationPresenter) {
        this.translateUseCaseInteractor = translateUseCaseInteractor;
        this.translationPresenter = translationPresenter;
    }

    public void execute(String phrase) {
        TranslateInputData translateInputData = new TranslateInputData(phrase);
        translateUseCaseInteractor.execute(translateInputData);
    }
}
