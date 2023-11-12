package interface_adapter.number_languages;

public class NumberLanguageState {
    private String tableType = "";
//    private String usernameError = null;
    private String language = "";
//    private String passwordError = null;
    private String sortType = "";
//    private String repeatPasswordError = null;

    public NumberLanguageState(NumberLanguageState copy) {
        tableType = copy.tableType;
//        usernameError = copy.usernameError;
        language = copy.language;
//        passwordError = copy.passwordError;
        sortType = copy.sortType;
//        repeatPasswordError = copy.repeatPasswordError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public NumberLanguageState() {}

    public String getTableType() {
        return tableType;
    }

//    public String getUsernameError() {
//        return usernameError;
//    }

    public String getLanguage() {
        return language;
    }

//    public String getPasswordError() {
//        return passwordError;
//    }

    public String getSortType() {
        return sortType;
    }

//    public String getRepeatPasswordError() {
//        return repeatPasswordError;
//    }

    public void setTableType(String username) {
        this.tableType = tableType;
    }

//    public void setUsernameError(String usernameError) {
//        this.usernameError = usernameError;
//    }

    public void setLanguage(String password) {
        this.language = language;
    }

//    public void setPasswordError(String passwordError) {
//        this.passwordError = passwordError;
//    }

    public void setSortType(String repeatPassword) {
        this.sortType = sortType;
    }

//    public void setRepeatPasswordError(String repeatPasswordError) {
//        this.repeatPasswordError = repeatPasswordError;
//    }
}

