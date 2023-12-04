package use_case.table_preferences;

public class TableOutputData {
    private final String tableType;
    private String sortType;
    private boolean useCaseFailed;

    public TableOutputData(String tableType, String sortType, boolean useCaseFailed) {
        this.tableType = tableType;
        this.sortType = sortType;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTableType() {
        return tableType;
    }

    public String getSortType() {
        return sortType;
    }
}
