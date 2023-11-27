package app;

import data_access.FileTranslationHistoryDataAccessObject;
import entity.CommonUserFactory;
//import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.number_languages.NumberLanguagesViewModel;
import interface_adapter.select_languages.SelectLanguagesViewModel;
import interface_adapter.table_preferences.TableViewModel;
import view.*;

import javax.swing.*;
import javax.swing.text.TableView;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.
        JFrame application = new JFrame("Translayte");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

//        LoginViewModel loginViewModel = new LoginViewModel();
//
//        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel);
//        views.add(signupView, signupView.viewName);
//
//        LoginView loginView = new LoginView(loginViewModel);
//        views.add(loginView, loginView.viewName);

        TableViewModel tableViewModel = new TableViewModel();
        NumberLanguagesViewModel numberLanguagesViewModel = new NumberLanguagesViewModel();
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
//        HistoryController historyController = new HistoryController();

        FileTranslationHistoryDataAccessObject translationHistoryDataAccessObject;
        try {
            translationHistoryDataAccessObject = new FileTranslationHistoryDataAccessObject("./src/translations.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TablePreferenceView tablePreferenceView = TableUseCaseFactory.create(viewManagerModel, tableViewModel, numberLanguagesViewModel, historyViewModel, translationHistoryDataAccessObject);
        views.add(tablePreferenceView, tablePreferenceView.viewName);

        NumberLanguagesView numberLanguagesView = NumberLanguagesUseCaseFactory.create(viewManagerModel, numberLanguagesViewModel, selectLanguagesViewModel, historyViewModel, translationHistoryDataAccessObject);
        views.add(numberLanguagesView, numberLanguagesView.viewName);

        SelectLanguagesView selectLanguagesView = SelectLanguagesUseCaseFactory.create(viewManagerModel, selectLanguagesViewModel, historyViewModel, translationHistoryDataAccessObject);
        views.add(selectLanguagesView, selectLanguagesView.viewName);

//        HistoryView historyView = new HistoryView(historyViewModel);
//        views.add(historyView, historyView.viewName);
        HistoryView historyView = new HistoryView(historyViewModel);
        views.add(historyView, historyView.viewName);


//        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.setActiveView(tablePreferenceView.viewName); // test table view
//        viewManagerModel.setActiveView(numberLanguagesView.viewName); // test number languages view
//        viewManagerModel.setActiveView(selectLanguagesView.viewName); // test select languages view
//        viewManagerModel.setActiveView(historyView.viewName); // test history view
        cardLayout.show(views, viewManagerModel.getActiveView());
//        viewManagerModel.firePropertyChanged();
        application.pack();
        application.setVisible(true);
    }
}