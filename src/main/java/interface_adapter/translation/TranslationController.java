package interface_adapter.translation;

import interface_adapter.translation.TranslationPresenter;
import interface_adapter.translation.TranslationViewModel;
import use_case.translate.TranslateInputBoundary;
import use_case.translate.TranslateInputData;

public class TranslationController {
    private final TranslateInputBoundary translateUseCaseInteractor;
    private final TranslationPresenter translationPresenter;
    private final TranslationViewModel translationViewModel;

    public TranslationController(TranslateInputBoundary translateUseCaseInteractor,
                                 TranslationPresenter translationPresenter,
                                 TranslationViewModel translationViewModel) {
        this.translateUseCaseInteractor = translateUseCaseInteractor;
        this.translationPresenter = translationPresenter;
        this.translationViewModel = translationViewModel;
    }

    public void backToSignup() {
        translationPresenter.backToSignup();
    }
    public void goToHistory() {translationPresenter.goToHistory();}

    public void handleCancel() {
        // Clear any state or perform any action needed on cancel
        translationPresenter.prepareCancelView();
    }
    public void execute(String phrase) {
        TranslationState translationState = translationViewModel.getState();
        String username = translationState.getUsername();
        TranslateInputData translateInputData = new TranslateInputData(phrase, username);
        translateUseCaseInteractor.execute(translateInputData);
    }
}