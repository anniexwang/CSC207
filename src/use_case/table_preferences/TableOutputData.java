package use_case.table_preferences;

public class TableOutputData {
    private final String tableType;
    private String[] languages;

    private String sortType;

    public TableOutputData(String tableType, String sortType) {
        this.tableType = tableType;
        this.sortType = sortType;
    }

    public String getTableType() {
        return tableType;
    }

    public String getSortType() {
        return sortType;
    }
}
