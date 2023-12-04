package app;

import interface_adapter.*;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.translation.TranslationController;
import interface_adapter.translation.TranslationPresenter;
import interface_adapter.translation.TranslationViewModel;
import interface_adapter.table_preferences.TableViewModel;
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
                                          TableViewModel tableViewModel
                                         ) {

        try {
            TranslationController translationController = createUserTranslationUseCase(viewManagerModel,
                    translationViewModel,signupViewModel,tableViewModel);
            return new TranslationView(translationController,
                    translationViewModel);
        }

        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Could not translate");
        }

        return null;
    }

    private static TranslationController createUserTranslationUseCase(ViewManagerModel viewManagerModel,
                                                                      TranslationViewModel translationViewModel,
                                                                      SignupViewModel signupViewModel,
                                                                      TableViewModel tableViewModel
                                                                      )
    throws IOException {

        TranslateOutputBoundary translateOutputBoundary = new TranslationPresenter(
                viewManagerModel, translationViewModel, signupViewModel, tableViewModel);
        TranslateInputBoundary translationInteractor = new TranslateInteractor(
                 translateOutputBoundary);



        return new TranslationController(translationInteractor, (TranslationPresenter) translateOutputBoundary);
    }



}

