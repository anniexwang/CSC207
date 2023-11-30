package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignupUserDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import interface_adapter.Audio.AudioController;
import view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
            SignupViewModel signupViewModel, SignupUserDataAccessInterface userDataAccessObject, AudioController audioController) {


            SignupController signupController = createUserSignupUseCase(
                    viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);

            return new SignupView(signupController, signupViewModel, audioController);

    }

    static SignupController createUserSignupUseCase(
            ViewManagerModel viewManagerModel, SignupViewModel signupViewModel,
            LoginViewModel loginViewModel, SignupUserDataAccessInterface userDataAccessObject) {

        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(
                viewManagerModel, signupViewModel, loginViewModel);
        UserFactory userFactory = new CommonUserFactory();
        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor, (SignupPresenter) signupOutputBoundary);
    }
}
