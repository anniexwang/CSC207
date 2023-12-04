package interface_adapter.login;

import app.SignupUseCaseFactory;
import interface_adapter.translation.TranslationState;
import interface_adapter.translation.TranslationViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;
import view.SignupView;



public class LoginPresenter implements LoginOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final TranslationViewModel translationViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          TranslationViewModel translationViewModel,
                          SignupViewModel signupViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.translationViewModel = translationViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        TranslationState translationState = translationViewModel.getState();
        translationState.setUsername(response.getUsername());
        this.translationViewModel.setState(translationState);
        this.translationViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(translationViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void goToSignUp() {
        this.viewManagerModel.setActiveView(signupViewModel.getViewName()); // Use the correct view name for SignupView
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
