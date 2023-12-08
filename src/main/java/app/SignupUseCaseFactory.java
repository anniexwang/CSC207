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

/**
 * Factory class for creating an instance of SignupView.
 * This class encapsulates the creation logic of SignupView,
 * isolating the client classes from the implementation details.
 */
public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    /**
     * Creates an instance of SignupView.
     *
     * @param viewManagerModel The ViewManagerModel instance.
     * @param loginViewModel The LoginViewModel instance.
     * @param signupViewModel The SignupViewModel instance.
     * @param userDataAccessObject The SignupUserDataAccessInterface instance.
     * @param audioController The AudioController instance.
     * @return An instance of SignupView.
     */
    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
            SignupViewModel signupViewModel, SignupUserDataAccessInterface userDataAccessObject, AudioController audioController) {

        SignupController signupController = createUserSignupUseCase(
                viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);

        return new SignupView(signupController, signupViewModel, audioController);
    }

    /**
     * Creates an instance of SignupController.
     *
     * @param viewManagerModel The ViewManagerModel instance.
     * @param signupViewModel The SignupViewModel instance.
     * @param loginViewModel The LoginViewModel instance.
     * @param userDataAccessObject The SignupUserDataAccessInterface instance.
     * @return An instance of SignupController.
     */
    private static SignupController createUserSignupUseCase(
            ViewManagerModel viewManagerModel, SignupViewModel signupViewModel,
            LoginViewModel loginViewModel, SignupUserDataAccessInterface userDataAccessObject) {

        // Create an instance of SignupPresenter
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(
                viewManagerModel, signupViewModel, loginViewModel);

        // Create an instance of CommonUserFactory
        UserFactory userFactory = new CommonUserFactory();

        // Create an instance of SignupInteractor
        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        // Create and return an instance of SignupController
        return new SignupController(userSignupInteractor, (SignupPresenter) signupOutputBoundary);
    }
}