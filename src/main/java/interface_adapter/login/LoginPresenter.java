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

/**
 * This class is responsible for presenting the login functionality of the system.
 * It communicates with the LoginOutputBoundary to perform operations such as preparing the success and failure views.
 */
public class LoginPresenter implements LoginOutputBoundary {

    final SignupViewModel signupViewModel;
    final LoginViewModel loginViewModel;
    final TranslationViewModel translationViewModel;
    ViewManagerModel viewManagerModel;

    /**
     * Constructor for the LoginPresenter class.
     *
     * @param viewManagerModel The ViewManagerModel instance.
     * @param translationViewModel The TranslationViewModel instance.
     * @param signupViewModel The SignupViewModel instance.
     * @param loginViewModel The LoginViewModel instance.
     */
    public LoginPresenter(ViewManagerModel viewManagerModel,
                          TranslationViewModel translationViewModel,
                          SignupViewModel signupViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.translationViewModel = translationViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    /**
     * Prepares the success view after a successful login.
     * It sets the username in the TranslationState, sets the active view to the TranslationViewModel's view, and fires a property change event.
     *
     * @param response The LoginOutputData instance containing the response data.
     */
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

    /**
     * Navigates to the sign-up view.
     * It sets the active view to the SignupViewModel's view and fires a property change event.
     */
    public void goToSignUp() {
        this.viewManagerModel.setActiveView(signupViewModel.getViewName()); // Use the correct view name for SignupView
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view after a failed login.
     * It sets the username error in the LoginState and fires a property change event.
     *
     * @param error The error message.
     */
    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}