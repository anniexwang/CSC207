package use_case.clear;

import java.util.ArrayList;

public class ClearInputData{
    private final String username;

    public ClearInputData(String username) {
        this.username = username;
    }

    public String getUser(){ return username;}
}