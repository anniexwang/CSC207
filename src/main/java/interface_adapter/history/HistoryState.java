package interface_adapter.history;

public class HistoryState {
    private String tableType = "";
    private String tableTypeError = null;
    private String sortType = "";
    private String numberLanguages = "";
    private String[] languages;

    private String currentUsername = "";

    public HistoryState(HistoryState copy) {
        tableType = copy.tableType;
        tableTypeError = copy.tableTypeError;
        sortType = copy.sortType;
        numberLanguages = copy.numberLanguages;
        languages = copy.languages;
        currentUsername = copy.currentUsername;
    }

    public HistoryState() {}

    public String getTableType() {
        return tableType;
    }

    public String getSortType() {
        return sortType;
    }

    public String[] getLanguages() {return languages;}

    public String getCurrentUsername() {return currentUsername;}

    public void setHistoryTableType(String tableType) {this.tableType = tableType;}

    public void setHistorySortType(String sortType) {
        this.sortType = sortType;
    }

    public void setHistoryLanguages(String[] languages) {this.languages = languages;}

    public void setCurrentUsername(String currentUsername) {this.currentUsername = currentUsername;}
}