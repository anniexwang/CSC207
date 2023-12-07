package use_case.table_preferences;

import java.io.IOException;

public class TableInteractor implements TableInputBoundary {
    final TableUserDataAccessInterface userDataAccessObject;
    final TableOutputBoundary tablePresenter;

    public TableInteractor(TableUserDataAccessInterface userTableDataAccessInterface,
                           TableOutputBoundary tableOutputBoundary) {
        this.userDataAccessObject = userTableDataAccessInterface;
        this.tablePresenter = tableOutputBoundary;
    }

    @Override
    public void execute(TableInputData tableInputData) {
        try {
            userDataAccessObject.updateData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // errors for when table type dropdown or sort type drop down are not selected
        if (tableInputData.getTableType().equals("Select")) {
            tablePresenter.prepareFailView("Table Type not selected");
        } else if (tableInputData.getSortType().equals("Select")) {
            tablePresenter.prepareFailView("Sort Type not selected");
        }
        else {
            TableOutputData tableOutputData = new TableOutputData(tableInputData.getTableType(), tableInputData.getSortType(), false);
            tablePresenter.prepareSuccessView(tableOutputData);
        }
    }
}

