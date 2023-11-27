package use_case.table_preferences;

public class TableInputData {
    final private String tableType;
    final private String sortType;

    public TableInputData(String tableType, String sortType) {
        this.tableType = tableType;
        this.sortType = sortType;
    }

    String getTableType() {
        return tableType;
    }

    String getSortType() {
        return sortType;
    }
}
