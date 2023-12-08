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

/**
 * Factory class for creating an instance of LoginView.
 * This class encapsulates the creation logic of LoginView,
 * isolating the client classes from the implementation details.
 */
public class LoginUseCaseFactory {

    // Private constructor to prevent instantiation
    private LoginUseCaseFactory() {}

    /**
     * Creates an instance of LoginView.
     *
     * @param viewManagerModel The ViewManagerModel instance.
     * @param loginViewModel The LoginViewModel instance.
     * @param translationViewModel The TranslationViewModel instance.
     * @param signupViewModel The SignupViewModel instance.
     * @param userDataAccessObject The LoginUserDataAccessInterface instance.
     * @param audioController The AudioController instance.
     * @param historyViewModel The HistoryViewModel instance.
     * @return An instance of LoginView.
     */
    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            TranslationViewModel translationViewModel,
            SignupViewModel signupViewModel,
            LoginUserDataAccessInterface userDataAccessObject,
            AudioController audioController,
            HistoryViewModel historyViewModel) {

        // Create an instance of LoginController
        LoginController loginController = createLoginUseCase(
                viewManagerModel, loginViewModel, translationViewModel, signupViewModel, userDataAccessObject);

        // Create and return an instance of LoginView
        return new LoginView(loginViewModel, loginController, audioController, historyViewModel);
    }

    /**
     * Creates an instance of LoginController.
     *
     * @param viewManagerModel The ViewManagerModel instance.
     * @param loginViewModel The LoginViewModel instance.
     * @param translationViewModel The TranslationViewModel instance.
     * @param signupViewModel The SignupViewModel instance.
     * @param userDataAccessObject The LoginUserDataAccessInterface instance.
     * @return An instance of LoginController.
     */
    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            TranslationViewModel translationViewModel,
            SignupViewModel signupViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        // Create an instance of LoginPresenter
        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(
                viewManagerModel, translationViewModel, signupViewModel, loginViewModel);

        // Create an instance of CommonUserFactory
        UserFactory userFactory = new CommonUserFactory();

        // Create an instance of LoginInteractor
        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        // Create and return an instance of LoginController
        return new LoginController(loginInteractor, (LoginPresenter) loginOutputBoundary);
    }
}