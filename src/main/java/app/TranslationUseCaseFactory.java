package app;

import interface_adapter.*;
import interface_adapter.clear.ClearController;
import interface_adapter.clear.ClearPresenter;
import interface_adapter.clear.ClearViewModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationController;
import interface_adapter.translation.TranslationPresenter;
import interface_adapter.translation.TranslationViewModel;
import use_case.clear.ClearInputBoundary;
import use_case.clear.ClearInteractor;
import use_case.clear.ClearOutputBoundary;
import use_case.clear.ClearUserDataAccessInterface;
import use_case.translate.TranslateOutputBoundary;
import use_case.translate.TranslateInputBoundary;
import use_case.translate.TranslateInteractor;
import use_case.translate.TranslateUserDataAccessInterface;
import view.TranslationView;

import javax.swing.*;
import java.io.IOException;
public class TranslationUseCaseFactory {

    private TranslationUseCaseFactory(){};

    public static TranslationView create( ViewManagerModel viewManagerModel,
                                         TranslationViewModel translationViewModel,
                                         SignupViewModel signupViewModel,
                                         TranslateUserDataAccessInterface userDataAccessObject) {
        // need to add ViewModel for selection input/output translation languages

        try {
            TranslationController translationController = createUserTranslationUseCase(viewManagerModel,
                    translationViewModel,signupViewModel,userDataAccessObject);
            return new TranslationView(translationController,
                    translationViewModel);
        }

        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Could not translate");
        }

        return null;
    }

    public TranslationController createUserTranslationUseCase(ViewManagerModel viewManagerModel,
                                                                      TranslationViewModel translationViewModel,
                                                                      SignupViewModel signupViewModel,
                                                                      TranslateUserDataAccessInterface userDataAccessObject)
    throws IOException {

        TranslateOutputBoundary translateOutputBoundary = new TranslationPresenter(
                viewManagerModel, translationViewModel, signupViewModel);
        TranslateInputBoundary translationInteractor = new TranslateInteractor(
                userDataAccessObject, translateOutputBoundary);



        return new TranslationController(translationInteractor, (TranslationPresenter) translateOutputBoundary);
    }



}

