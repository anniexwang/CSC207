package use_case.table_preferences;

import data_access.FileTranslationHistoryDataAccessObject;
import interface_adapter.history.HistoryViewModel;
import org.junit.jupiter.api.Test;
import use_case.select_languages.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TableInteractorTest {

    @Test
    void successTest() throws IOException {
        TableInputData tableInputData = new TableInputData("All","Alphabetical");

        TableOutputBoundary tableOutputBoundary = new TableOutputBoundary() {

            @Override
            public void prepareSuccessView(TableOutputData response) {
                assertEquals("All", response.getTableType());
                assertEquals("Alphabetical", response.getSortType());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected");

            }
        };

        TableUserDataAccessInterface tableUserDataAccessInterface = new FileTranslationHistoryDataAccessObject("src/main/java/translations.csv");
        TableInputBoundary tableInputBoundary = new TableInteractor(tableUserDataAccessInterface, tableOutputBoundary);
        tableInputBoundary.execute(tableInputData);
    }

    @Test
    void failureTest1() throws IOException {
        TableInputData tableInputData = new TableInputData("Select","Alphabetical");

        TableOutputBoundary tableOutputBoundary = new TableOutputBoundary() {

            @Override
            public void prepareSuccessView(TableOutputData response) {
                fail("Use case failure is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Table Type not selected", error);
            }
        };

        TableUserDataAccessInterface tableUserDataAccessInterface = new FileTranslationHistoryDataAccessObject("src/main/java/translations.csv");
        TableInputBoundary tableInputBoundary = new TableInteractor(tableUserDataAccessInterface, tableOutputBoundary);
        tableInputBoundary.execute(tableInputData);
    }

    @Test
    void failureTest2() throws IOException {
        TableInputData tableInputData = new TableInputData("All","Select");

        TableOutputBoundary tableOutputBoundary = new TableOutputBoundary() {

            @Override
            public void prepareSuccessView(TableOutputData response) {
                fail("Use case failure is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Sort Type not selected", error);
            }
        };

        TableUserDataAccessInterface tableUserDataAccessInterface = new FileTranslationHistoryDataAccessObject("src/main/java/translations.csv");
        TableInputBoundary tableInputBoundary = new TableInteractor(tableUserDataAccessInterface, tableOutputBoundary);
        tableInputBoundary.execute(tableInputData);
    }
}