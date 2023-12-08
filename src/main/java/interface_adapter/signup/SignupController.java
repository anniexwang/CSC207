package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * This class is responsible for controlling the signup functionality of the system.
 * It communicates with the SignupInputBoundary to perform operations such as executing a signup request.
 */
public class SignupController {

    // The SignupInputBoundary instance used to execute signup requests
    final SignupInputBoundary userSignupUseCaseInteractor;

    // The SignupPresenter instance used to prepare the view
    private final SignupPresenter signupPresenter;

    /**
     * Constructor for the SignupController class.
     *
     * @param userSignupUseCaseInteractor The SignupInputBoundary instance.
     * @param signupPresenter The SignupPresenter instance.
     */
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor, SignupPresenter signupPresenter) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
        this.signupPresenter = signupPresenter;
    }

    /**
     * Handles the cancel action.
     * It calls the prepareCancelView method of the SignupPresenter.
     */
    public void handleCancel() {
        // Clear any state or perform any action needed on cancel
        signupPresenter.prepareCancelView();
    }

    /**
     * Navigates to the login view.
     * It calls the goToLogin method of the SignupPresenter.
     */
    public void goToLogin() {
        signupPresenter.goToLogin();
    }

    /**
     * Executes a signup request.
     * It calls the execute method of the SignupInputBoundary with the provided username and passwords.
     *
     * @param username The username of the user.
     * @param password1 The first password of the user.
     * @param password2 The second password of the user.
     */
    public void execute(String username, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}