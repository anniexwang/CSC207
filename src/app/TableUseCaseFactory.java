package app;

import data_access.FileUserDataAccessObject;
import data_access.UserTableDataAccessInterface;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.*;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import interface_adapter.table_preferences.TableController;
import interface_adapter.table_preferences.TablePresenter;
import interface_adapter.table_preferences.TableViewModel;
import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInteractor;
import use_case.table_preferences.TableOutputBoundary;
import view.SignupView;
import view.TablePreferenceView;

import javax.swing.*;
import java.io.IOException;

public class TableUseCaseFactory {

    /** Prevent instantiation. */
    private TableUseCaseFactory() {}

    public static TablePreferenceView create(ViewManagerModel viewManagerModel, NumberLanguagesViewModel numberLanguagesViewModel) {
        // The data for the views, such as username and password. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.

        try {
            TableViewModel tableViewModel = new TableViewModel();
            TableController tableController = createUserTableUseCase(viewManagerModel, tableViewModel, numberLanguagesViewModel);
            return new TablePreferenceView(tableController, tableViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static TableController createUserTableUseCase(ViewManagerModel viewManagerModel, TableViewModel tableViewModel, NumberLanguagesViewModel numberLanguagesViewModel) throws IOException {
        UserTableDataAccessInterface userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
//        UserTableDataAccessInterface userDataAccessObject = new FileUserDataAccessObject();

        TableOutputBoundary tableOutputBoundary = new TablePresenter(viewManagerModel, tableViewModel, numberLanguagesViewModel);
//        UserFactory userFactory = new CommonUserFactory();
//        TableInputBoundary userTableInteractor = new TableInteractor(
//                userDataAccessObject, tableOutputBoundary, userFactory);
        TableInputBoundary userTableInteractor = new TableInteractor(
                userDataAccessObject, tableOutputBoundary);

        return new TableController(userTableInteractor);
    }
}