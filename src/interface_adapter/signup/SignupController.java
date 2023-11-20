package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;
import interface_adapter.signup.SignupPresenter;

public class SignupController {


    final SignupInputBoundary userSignupUseCaseInteractor;
    private final SignupPresenter signupPresenter;
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor, SignupPresenter signupPresenter) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
        this.signupPresenter = signupPresenter;
    }

    public void goToLogin() {
        signupPresenter.goToLogin();
    }
    public void execute(String username, String password1, String password2) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }


}
