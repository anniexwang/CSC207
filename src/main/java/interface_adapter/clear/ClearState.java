package interface_adapter.clear;

import interface_adapter.login.LoginState;

import java.util.ArrayList;

public class ClearState {
    private String clear = "";
    private String clearError = "";


    public ClearState() {}
    public String getClear() {
        return clear;
    }
    private String user;
    public String getUsers(){
        return user;
    }
    public String getClearError() {
        return clearError;
    }
    public void setDeletedUser(String user){this.user = user;}
    public void setClear(String clear) {
        this.clear = clear;
    }
    public void setClearError(String password) {
        this.clearError = clearError;
    }
    }

