package interface_adapter.clear;

import interface_adapter.login.LoginState;

public class ClearState {
    private String clear = "";
    private String clearError = "";


    public ClearState() {}
    public String getClear() {
        return clear;
    }
    public String getClearError() {
        return clearError;
    }
    public void setClear(String clear) {
        this.clear = clear;
    }
    public void setClearError(String password) {
        this.clearError = clearError;
    }
    }

