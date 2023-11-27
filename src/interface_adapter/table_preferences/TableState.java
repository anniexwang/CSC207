package interface_adapter.table_preferences;

import interface_adapter.history.HistoryState;

public class TableState {
    private String tableType = "";
    private String tableTypeError = null;
    private String sortType = "";
    private String sortTypeError = null;

    public TableState(TableState copy) {
        tableType = copy.tableType;
        tableTypeError = copy.tableTypeError;
        sortType = copy.sortType;
        sortTypeError = copy.sortTypeError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public TableState() {}

    public String getTableType() {
        return tableType;
    }

    public String getTableTypeError() {
        return tableTypeError;
    }

    public String getSortType() {
        return sortType;
    }

    public String getSortTypeError() {
        return sortType;
    }

    public void setTableType(String tableType) {

        System.out.println("TableState: setTableType successful");
        this.tableType = tableType;
    }

    public void setTableTypeError(String tableTypeError) {
        this.tableTypeError = tableTypeError;
    }
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public void setSortTypeError(String sortTypeError) {
        this.sortTypeError = sortTypeError;
    }
}

