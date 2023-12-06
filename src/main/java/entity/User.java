package entity;


import java.util.ArrayList;
import java.util.List;

public interface User {

    String getName();

    String getPassword();

    // Assuming that translation_history and favorites are stored as semicolon-separated strings in the CSV file
    ArrayList<String> getTranslationHistory();
    void setTranslationHistory(ArrayList<String> translationHistory);


    ArrayList<String> getFavorites();
}
