package interface_adapter.translation;
import interface_adapter.ViewManagerModel;
import interface_adapter.clear.ClearState;
import interface_adapter.clear.ClearViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationState;
import interface_adapter.translation.TranslationViewModel;
import interface_adapter.translation.TranslationState;
import interface_adapter.translation.TranslationViewModel;
import use_case.clear.ClearOutputData;
import use_case.translate.TranslateOutputBoundary;
import use_case.translate.TranslateOutputData;

public class TranslationPresenter implements TranslateOutputBoundary{
    private final TranslationViewModel translationViewModel;
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public TranslationPresenter(ViewManagerModel viewManagerModel,
                          TranslationViewModel translationViewModel,
                                SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.translationViewModel = translationViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(TranslateOutputData response) {
        TranslationState translationInState = translationViewModel.getState();
        this.viewManagerModel.setActiveView(translationViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    // need to enable option to return to signup
    public void backToSignup() {
        this.viewManagerModel.setActiveView(signupViewModel.getViewName()); // Use the correct view name for SignupView
        this.viewManagerModel.firePropertyChanged();
    }

    public void prepareCancelView() {
        // Logic to clear the state
        TranslationState translationState = translationViewModel.getState();
        translationState.clearState();
        translationViewModel.setState(translationState);
        translationViewModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        TranslationState translationState = translationViewModel.getState();
        translationState.setTranslatedError(error);
        translationViewModel.firePropertyChanged();
    }
}
