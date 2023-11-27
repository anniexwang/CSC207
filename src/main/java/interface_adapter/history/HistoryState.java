package interface_adapter.history;

import interface_adapter.number_languages.NumberLanguagesState;
import interface_adapter.select_languages.SelectLanguagesState;
import interface_adapter.table_preferences.TableState;
import interface_adapter.table_preferences.TableViewModel;
import use_case.table_preferences.TableOutputData;

public class HistoryState {
    //    private String word = "";
//    private TableViewModel tableViewModel;
//    private TableState tableState = tableViewModel.getState();
    private TableState tableState;
    private TableOutputData tableOutputData;

    private NumberLanguagesState numberLanguagesState;
    private SelectLanguagesState selectLanguagesState;
//    private String tableType = tableState.getTableType();
//    private String sortType = tableState.getSortType();
//    private String numberLanguages = numberLanguagesState.getNumberLanguages();
//    private String[] languages = selectLanguagesState.getLanguages();

//    private String tableType = tableOutputData.getTableType();
//    private String sortType = tableState.getSortType();
//    private String numberLanguages = numberLanguagesState.getNumberLanguages();
//    private String[] languages = selectLanguagesState.getLanguages();

    private String tableType = "";
    private String tableTypeError = null;
    private String sortType = "";
    private String numberLanguages = "";
    private String[] languages;



    public HistoryState(HistoryState copy) {
//        word = copy.word;
        tableType = copy.tableType;
        tableTypeError = copy.tableTypeError;
        sortType = copy.sortType;
        numberLanguages = copy.numberLanguages;
        languages = copy.languages;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public HistoryState() {}

//    public String getWord() {
//        return word;
//    }

    //    public void setWord(String word) {
//        this.word = word;
//    }
    public String getTableType() {
        return tableType;
    }

//    public String getTableType() {
//        return tableState.getTableType();
//    }

    public String getTableTypeError() {
        return tableTypeError;
    }

    public String getSortType() {
        return sortType;
    }

    //    public String getRepeatPasswordError() {
//        return repeatPasswordError;
//    }
    public String getNumberLanguages() {
        return numberLanguages;
    }
    public String[] getLanguages() {
        return languages;
    }
    public void setHistoryTableType(String tableType) {
        System.out.println("HistoryState: setTableType successful");
        this.tableType = tableType;
        System.out.println("HistoryState: setTableType value: " + this.tableType);
    }

    //    public void setTableTypeError(String tableTypeError) {
//        this.tableTypeError = tableTypeError;
//    }
    public void setHistorySortType(String sortType) {
        this.sortType = sortType;
    }

    public void setNumberLanguages(String numberLanguages) {
        this.numberLanguages = numberLanguages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }
}

//package interface_adapter.history;
//
//
//public class HistoryState {
//    // Any state related properties, methods go here.
//    // This might be redundant for this simple use case.
//}