package app;

import interface_adapter.*;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesController;
import interface_adapter.select_languages.SelectLanguagesPresenter;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import use_case.select_languages.SelectLanguagesInputBoundary;
import use_case.select_languages.SelectLanguagesInteractor;
import use_case.select_languages.SelectLanguagesOutputBoundary;
import use_case.select_languages.SelectLanguagesUserDataAccessInterface;
import view.SelectLanguagesView;

import javax.swing.*;
import java.io.IOException;

public class SelectLanguagesUseCaseFactory {

    /** Prevent instantiation. */
    private SelectLanguagesUseCaseFactory() {}
    public static SelectLanguagesView create(ViewManagerModel viewManagerModel,
                                             SelectLanguagesViewModel selectLanguagesViewModel,
                                             HistoryViewModel historyViewModel,
                                             SelectLanguagesUserDataAccessInterface userDataAccessObject) {
        try {
            SelectLanguagesController selectLanguagesController = createSelectLanguagesUseCase(viewManagerModel, selectLanguagesViewModel, historyViewModel, userDataAccessObject);
            return new SelectLanguagesView(selectLanguagesController, selectLanguagesViewModel, historyViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SelectLanguagesController createSelectLanguagesUseCase(ViewManagerModel viewManagerModel,
                                                                          SelectLanguagesViewModel selectLanguagesViewModel,
                                                                          HistoryViewModel historyViewModel,
                                                                          SelectLanguagesUserDataAccessInterface userDataAccessObject) throws IOException {
        SelectLanguagesOutputBoundary selectLanguagesOutputBoundary = new SelectLanguagesPresenter(viewManagerModel, selectLanguagesViewModel, historyViewModel);
        SelectLanguagesInputBoundary selectLanguagesInteractor = new SelectLanguagesInteractor(
                userDataAccessObject, selectLanguagesOutputBoundary, historyViewModel);

        return new SelectLanguagesController(selectLanguagesInteractor);
    }
}
