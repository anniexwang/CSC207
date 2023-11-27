package app;

import interface_adapter.*;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import interface_adapter.translation.TranslationController;
import interface_adapter.translation.TranslationPresenter;
import interface_adapter.translation.TranslationViewModel;
import use_case.retrieve_translation.*;
import view.TranslationView;

import javax.swing.*;
import java.io.IOException;
public class TranslationUseCaseFactory {

    private TranslationUseCaseFactory(){};

    public static TranslationView create(ViewManagerModel viewManagerModel) {
        // need to add ViewModel for selection input/output translation languages

        try {
            TranslationViewModel translationViewModel = new TranslationViewModel();
            TranslationController translationController = createUserTranslationUseCase(viewManagerModel);
            return new TranslationView(translationController, translationViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Could not translate");
        }

        return null;
    }

    private static TranslationController createUserTranslationUseCase(ViewManagerModel viewManagerModel) throws IOException {
        //TranslationPresenter, RetrieveTranslationInteractor not implemented
        RetrieveTranslationOutputBoundary translationOutputBoundary = new TranslationPresenter();
        RetrieveTranslationInputBoundary translationInteractor = new RetrieveTranslationInteractor();



        return new TranslationController(translationInteractor);
    }

}