package interface_adapter.table_preferences;

public class TableState {
    private String tableType = "";
    private String tableTypeError = null;
    private String sortType = "";
//    private String repeatPasswordError = null;

    public TableState(TableState copy) {
        tableType = copy.tableType;
//        usernameError = copy.usernameError;
        sortType = copy.sortType;
//        repeatPasswordError = copy.repeatPasswordError;
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

//    public String getRepeatPasswordError() {
//        return repeatPasswordError;
//    }

    public void setTableType(String username) {
        this.tableType = tableType;
    }

    public void setTableTypeError(String tableTypeError) {
        this.tableTypeError = tableTypeError;
    }
    public void setSortType(String repeatPassword) {
        this.sortType = sortType;
    }

//    public void setRepeatPasswordError(String repeatPasswordError) {
//        this.repeatPasswordError = repeatPasswordError;
//    }
}

