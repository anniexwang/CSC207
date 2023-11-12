package app;

import data_access.FileUserDataAccessObject;
import data_access.UserSelectLanguagesDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.*;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesController;
import interface_adapter.select_languages.SelectLanguagesPresenter;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import use_case.select_languages.SelectLanguagesInputBoundary;
import use_case.select_languages.SelectLanguagesInteractor;
import use_case.select_languages.SelectLanguagesOutputBoundary;
import view.SelectLanguagesView;

import javax.swing.*;
import java.io.IOException;

public class SelectLanguagesUseCaseFactory {

    /** Prevent instantiation. */
    private SelectLanguagesUseCaseFactory() {}

    public static SelectLanguagesView create(ViewManagerModel viewManagerModel, HistoryViewModel historyViewModel) {
        // The data for the views, such as username and password. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.

        try {
            SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
            SelectLanguagesController selectLanguagesController = createUserSelectLanguagesUseCase(viewManagerModel, selectLanguagesViewModel, historyViewModel);
            return new SelectLanguagesView(selectLanguagesController, selectLanguagesViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SelectLanguagesController createUserSelectLanguagesUseCase(ViewManagerModel viewManagerModel, SelectLanguagesViewModel selectLanguagesViewModel, HistoryViewModel historyViewModel) throws IOException {
        UserSelectLanguagesDataAccessInterface userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        SelectLanguagesOutputBoundary selectLanguagesOutputBoundary = new SelectLanguagesPresenter(viewManagerModel, selectLanguagesViewModel, historyViewModel);
//        UserFactory userFactory = new CommonUserFactory();
//        SelectLanguagesInputBoundary userSelectLanguagesInteractor = new SelectLanguagesInteractor(
//                userDataAccessObject, selectLanguagesOutputBoundary, userFactory);
        SelectLanguagesInputBoundary userSelectLanguagesInteractor = new SelectLanguagesInteractor(
                userDataAccessObject, selectLanguagesOutputBoundary);

        return new SelectLanguagesController(userSelectLanguagesInteractor);
    }
}
