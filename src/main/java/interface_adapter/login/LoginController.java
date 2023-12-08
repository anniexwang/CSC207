package interface_adapter.login;

import use_case.login.LoginInputData;
import use_case.login.LoginInputBoundary;

/**
 * This class is responsible for controlling the login functionality of the system.
 * It communicates with the LoginInputBoundary to perform operations such as executing a login request.
 */
public class LoginController {
    private final LoginInputBoundary loginUseCaseInteractor;
    private final LoginPresenter loginPresenter;

    /**
     * Constructor for the LoginController class.
     *
     * @param loginUseCaseInteractor The LoginInputBoundary instance.
     * @param loginPresenter The LoginPresenter instance.
     */
    public LoginController(LoginInputBoundary loginUseCaseInteractor, LoginPresenter loginPresenter) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
        this.loginPresenter = loginPresenter;
    }

    /**
     * Executes a login request.
     * It calls the execute method of the LoginInputBoundary with the provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(username, password);
        loginUseCaseInteractor.execute(loginInputData);
    }

    /**
     * Navigates to the sign-up view.
     * It calls the goToSignUp method of the LoginPresenter.
     */
    public void goToSignUp() {
        loginPresenter.goToSignUp();
    }
}