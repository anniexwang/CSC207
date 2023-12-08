package interface_adapter.signup;

import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * This class is responsible for presenting the signup functionality of the system.
 * It communicates with the SignupOutputBoundary to perform operations such as preparing the success and failure views.
 */
public class SignupPresenter implements SignupOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructor for the SignupPresenter class.
     *
     * @param viewManagerModel The ViewManagerModel instance.
     * @param signupViewModel The SignupViewModel instance.
     * @param loginViewModel The LoginViewModel instance.
     */
    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the success view after a successful signup.
     * It sets the username in the LoginState, sets the active view to the LoginViewModel's view, and fires a property change event.
     *
     * @param response The SignupOutputData instance containing the response data.
     */
    @Override
    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the login view.

        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the cancel view after a cancel action.
     * It clears the state of the SignupViewModel and fires a property change event.
     */
    public void prepareCancelView() {
        // Logic to clear the state
        SignupState signupState = signupViewModel.getState();
        signupState.clearState();
        signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
    }

    /**
     * Navigates to the login view.
     * It sets the active view to the LoginViewModel's view and fires a property change event.
     */
    public void goToLogin() {
        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view after a failed signup.
     * It sets the username error in the SignupState and fires a property change event.
     *
     * @param error The error message.
     */
    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}