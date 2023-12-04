package app;

import interface_adapter.*;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;
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
                                             SelectLanguagesViewModel selectLanguagesViewModel,
                                             HistoryViewModel historyViewModel,
                                             TableUserDataAccessInterface userDataAccessObject) {

        try {
            TableController tableController = createTableUseCase(viewManagerModel, tableViewModel, selectLanguagesViewModel, historyViewModel, userDataAccessObject);

            return new TablePreferenceView(tableController, tableViewModel, historyViewModel);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static TableController createTableUseCase(ViewManagerModel viewManagerModel,
                                                      TableViewModel tableViewModel,
                                                      SelectLanguagesViewModel selectLanguagesViewModel,
                                                      HistoryViewModel historyViewModel,
                                                      TableUserDataAccessInterface userDataAccessObject) throws IOException {

        TableOutputBoundary tableOutputBoundary = new TablePresenter(viewManagerModel, tableViewModel, selectLanguagesViewModel, historyViewModel);

        TableInputBoundary tableInteractor = new TableInteractor(
                userDataAccessObject, tableOutputBoundary);

        return new TableController(tableInteractor);
    }
}