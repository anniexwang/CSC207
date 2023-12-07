package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.translation.TranslationViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginUserDataAccessInterface;
import view.HistoryView;
import view.LoginView;
import interface_adapter.Audio.AudioController;

import javax.swing.*;
import java.io.IOException;

public class LoginUseCaseFactory {

    private LoginUseCaseFactory() {}

    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            TranslationViewModel translationViewModel,
            SignupViewModel signupViewModel,
            LoginUserDataAccessInterface userDataAccessObject,
            AudioController audioController,
            HistoryViewModel historyViewModel) { // Add AudioManager as a parameter


            LoginController loginController = createLoginUseCase(
                    viewManagerModel, loginViewModel, translationViewModel, signupViewModel, userDataAccessObject);
            return new LoginView(loginViewModel, loginController, audioController, historyViewModel); // Pass AudioManager to LoginView

    }

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            TranslationViewModel translationViewModel,
            SignupViewModel signupViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(
                viewManagerModel, translationViewModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        return new LoginController(loginInteractor, (LoginPresenter) loginOutputBoundary);
    }
}