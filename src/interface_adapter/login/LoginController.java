package interface_adapter.login;

import use_case.login.LoginInputData;
import use_case.login.LoginInputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

public class LoginController {
    private final LoginInputBoundary loginUseCaseInteractor;
    private final LoginPresenter loginPresenter;

    public LoginController(LoginInputBoundary loginUseCaseInteractor, LoginPresenter loginPresenter) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
        this.loginPresenter = loginPresenter;
    }

    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(username, password);
        loginUseCaseInteractor.execute(loginInputData);
    }

    public void goToSignUp() {
        loginPresenter.goToSignUp();
    }
}