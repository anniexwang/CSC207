package use_case.table_preferences;

public class TableInputData {
    final private String tableType;
    final private String[] languages;
    final private String sortType;

    public TableInputData(String tableType, String[] languages, String sortType) {
        this.tableType = tableType;
        this.languages = languages;
        this.sortType = sortType;
    }

    String getTableType() {
        return tableType;
    }

    String[] getLanguages() {return languages;}

    String getSortType() {
        return sortType;
    }
}
