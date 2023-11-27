package entity;

import java.util.ArrayList;

class CommonUser implements User {

    private final String name;
    private final String password;
    private final ArrayList<String> translationHistory;
    private final ArrayList<String> favorites;

    /**
     * Requires: password is valid.
     *
     * @param name
     * @param password
     * @param translationHistory
     * @param favorites
     */
    CommonUser(String name, String password, ArrayList<String> translationHistory, ArrayList<String> favorites) {
        this.name = name;
        this.password = password;
        this.translationHistory = translationHistory;
        this.favorites = favorites;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public ArrayList<String> getTranslationHistory() {return translationHistory;}

    @Override
    public ArrayList<String> getFavorites() {return favorites;}
}
