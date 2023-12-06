package interface_adapter.translation;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.table_preferences.TableViewModel;
import use_case.translate.TranslateOutputBoundary;

public class TranslationPresenter implements TranslateOutputBoundary{
    private final TranslationViewModel translationViewModel;
    private final SignupViewModel signupViewModel;
    private final TableViewModel tableViewModel;
    private ViewManagerModel viewManagerModel;

    public TranslationPresenter(ViewManagerModel viewManagerModel,
                          TranslationViewModel translationViewModel,
                                SignupViewModel signupViewModel,
                                TableViewModel tableViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.translationViewModel = translationViewModel;
        this.signupViewModel = signupViewModel;
        this.tableViewModel = tableViewModel;
    }

    @Override
    public void prepareSuccessView(String response) {
        TranslationState translationState = translationViewModel.getState();
        translationState.setTranslated(response); // Set the translated text
        translationViewModel.setState(translationState); // Update the state in the view model
        translationViewModel.firePropertyChanged(); // Notify the view to update itself
        this.viewManagerModel.setActiveView(translationViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void backToSignup() {
        this.viewManagerModel.setActiveView(signupViewModel.getViewName()); // Use the correct view name for SignupView
        this.viewManagerModel.firePropertyChanged();
    }

    public void goToHistory(){
        this.viewManagerModel.setActiveView((tableViewModel.getViewName()));
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
