package use_case.table_preferences;

public class TableOutputData {
    private final String tableType;
//    private String[] languages;

    private String sortType;

    //    public TableOutputData(String tableType, String sortType) {
//        this.tableType = tableType;
//        this.sortType = sortType;
//    }
    private boolean useCaseFailed;

    public TableOutputData(String tableType, String sortType, boolean useCaseFailed) {
        this.tableType = tableType;
        this.sortType = sortType;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTableType() {
        return tableType;
    } // TODO: use these in history view

    public String getSortType() {
        return sortType;
    }
}
