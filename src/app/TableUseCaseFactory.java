package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.*;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import interface_adapter.table_preferences.TableController;
import interface_adapter.table_preferences.TablePresenter;
import interface_adapter.table_preferences.TableViewModel;
import use_case.table_preferences.TableInputBoundary;
import use_case.table_preferences.TableInteractor;
import use_case.table_preferences.TableOutputBoundary;
import use_case.table_preferences.TableUserDataAccessInterface;
import view.TablePreferenceView;

import javax.swing.*;
import java.io.IOException;

public class TableUseCaseFactory {

    /** Prevent instantiation. */
    private TableUseCaseFactory() {}

    public static TablePreferenceView create(ViewManagerModel viewManagerModel,
                                             TableViewModel tableViewModel,
                                             NumberLanguagesViewModel numberLanguagesViewModel,
                                             HistoryViewModel historyViewModel,
                                             TableUserDataAccessInterface userDataAccessObject) {
//public static TablePreferenceView create(ViewManagerModel viewManagerModel,
//                                         NumberLanguagesViewModel numberLanguagesViewModel) {
        // The data for the views, such as username and password. This
        // will be changed by a presenter object that is reporting the
        // results from the use case. This is an observable, and will
        // be observed by the layout manager.

        try {
//            TableViewModel tableViewModel = new TableViewModel();
//            TableController tableController = createTableUseCase(viewManagerModel, tableViewModel, numberLanguagesViewModel);
//            return new TablePreferenceView(tableController, tableViewModel);
            TableController tableController = createTableUseCase(viewManagerModel, tableViewModel, numberLanguagesViewModel, historyViewModel, userDataAccessObject);
            return new TablePreferenceView(tableController, tableViewModel, historyViewModel);
//            return new TablePreferenceView(tableController, tableViewModel);


        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static TableController createTableUseCase(ViewManagerModel viewManagerModel,
                                                      TableViewModel tableViewModel,
                                                      NumberLanguagesViewModel numberLanguagesViewModel,
                                                      HistoryViewModel historyViewModel,
                                                      TableUserDataAccessInterface userDataAccessObject) throws IOException {
//private static TableController createTableUseCase(ViewManagerModel viewManagerModel,
//                                                  TableViewModel tableViewModel,
//                                                  NumberLanguagesViewModel numberLanguagesViewModel) throws IOException {

//        UserTableDataAccessInterface userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
//        UserTableDataAccessInterface userDataAccessObject = new FileUserDataAccessObject();

        TableOutputBoundary tableOutputBoundary = new TablePresenter(viewManagerModel, tableViewModel, numberLanguagesViewModel, historyViewModel);
//        UserFactory userFactory = new CommonUserFactory();
//        TableInputBoundary userTableInteractor = new TableInteractor(
//                userDataAccessObject, tableOutputBoundary, userFactory);
        TableInputBoundary tableInteractor = new TableInteractor(
                userDataAccessObject, tableOutputBoundary);

        return new TableController(tableInteractor);
    }
}