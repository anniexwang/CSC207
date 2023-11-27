package use_case.table_preferences;

import data_access.UserTableDataAccessInterface;

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
        if (tableInputData.getTableType().equals("Select")) {
            tablePresenter.prepareFailView("Table Type not selected");
        } else if (tableInputData.getSortType().equals("Select")) {
            tablePresenter.prepareFailView("Sort Type not selected");
        }
        else {
            TableOutputData tableOutputData = new TableOutputData(tableInputData.getTableType(), tableInputData.getSortType(), false);
//            System.out.println("TableInteractor tableOutputData: " + tableOutputData);
            tablePresenter.prepareSuccessView(tableOutputData);
        }
    }
}

