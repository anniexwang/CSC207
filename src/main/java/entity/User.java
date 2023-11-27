package entity;


import java.util.ArrayList;

public interface User {

    String getName();

    String getPassword();

    // Assuming that translation_history and favorites are stored as semicolon-separated strings in the CSV file
    ArrayList<String> getTranslationHistory();

    ArrayList<String> getFavorites();
}
