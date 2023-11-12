package use_case.table_preferences;

public class TableOutputData {
    private final String tableType;
    private String[] languages;

    private String sortType;

    public TableOutputData(String tableType, String[] languages, String sortType) {
        this.tableType = tableType;
        this.languages = languages;
        this.sortType = sortType;
    }

    public String getTableType() {
        return tableType;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String getSortType() {
        return sortType;
    }
}
