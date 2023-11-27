package app;

import data_access.FileUserDataAccessObject;
import data_access.UserNumberLanguagesDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.*;
import interface_adapter.number_languages.NumberLanguagesController;
import interface_adapter.number_languages.NumberLanguagesPresenter;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import use_case.number_languages.NumberLanguagesInputBoundary;
import use_case.number_languages.NumberLanguagesInteractor;
import use_case.number_languages.NumberLanguagesOutputBoundary;
import view.NumberLanguagesView;

import javax.swing.*;
import java.io.IOException;

public class NumberLanguagesUseCaseFactory {

    /** Prevent instantiation. */
    private NumberLanguagesUseCaseFactory() {}

    public static NumberLanguagesView create(ViewManagerModel viewManagerModel, SelectLanguagesViewModel selectLanguagesViewModel) {
        // The data for the views, such as username and password. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.

        try {
            NumberLanguagesViewModel numberLanguagesViewModel = new NumberLanguagesViewModel();
            NumberLanguagesController numberLanguagesController = createUserNumberLanguagesUseCase(viewManagerModel, numberLanguagesViewModel, selectLanguagesViewModel);
            return new NumberLanguagesView(numberLanguagesController, numberLanguagesViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static NumberLanguagesController createUserNumberLanguagesUseCase(ViewManagerModel viewManagerModel, NumberLanguagesViewModel numberLanguagesViewModel, SelectLanguagesViewModel selectLanguagesViewModel) throws IOException {
        UserNumberLanguagesDataAccessInterface userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        NumberLanguagesOutputBoundary numberLanguagesOutputBoundary = new NumberLanguagesPresenter(viewManagerModel, numberLanguagesViewModel, selectLanguagesViewModel);
        UserFactory userFactory = new CommonUserFactory();
//        NumberLanguagesInputBoundary userNumberLanguagesInteractor = new NumberLanguagesInteractor(
//                userDataAccessObject, numberLanguagesOutputBoundary, userFactory);
        NumberLanguagesInputBoundary userNumberLanguagesInteractor = new NumberLanguagesInteractor(
                userDataAccessObject, numberLanguagesOutputBoundary);

        return new NumberLanguagesController(userNumberLanguagesInteractor);
    }
}
