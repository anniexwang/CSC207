package use_case.table_preferences;

import data_access.UserTableDataAccessInterface;

public class TableInteractor implements TableInputBoundary {
    final UserTableDataAccessInterface userDataAccessObject;
    final TableOutputBoundary userPresenter;

    public TableInteractor(UserTableDataAccessInterface userTableDataAccessInterface,
                            TableOutputBoundary tableOutputBoundary) {
        this.userDataAccessObject = userTableDataAccessInterface;
        this.userPresenter = tableOutputBoundary;
    }

    @Override
    public void execute(TableInputData tableInputData) {
        TableOutputData tableOutputData = new TableOutputData(tableInputData.getTableType(), tableInputData.getLanguages(), tableInputData.getSortType());
        userPresenter.prepareSuccessView(tableOutputData);
        }
    }

