package entity;

import java.util.ArrayList;

/**
 * This class represents a common user in the system.
 * It implements the User interface.
 */
class CommonUser implements User {

    private final String name;
    private final String password;
    private ArrayList<String> translationHistory;
    private final ArrayList<String> favorites;

    /**
     * Constructor for the CommonUser class.
     *
     * @param name The name of the user.
     * @param password The password of the user.
     * @param translationHistory The translation history of the user.
     * @param favorites The favorites of the user.
     */
    CommonUser(String name, String password, ArrayList<String> translationHistory, ArrayList<String> favorites) {
        this.name = name;
        this.password = password;
        this.translationHistory = translationHistory;
        this.favorites = favorites;
    }

    /**
     * Returns the name of the user.
     *
     * @return The name of the user.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the password of the user.
     *
     * @return The password of the user.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the translation history of the user.
     * If the translation history is empty, it returns a new ArrayList.
     *
     * @return The translation history of the user.
     */
    @Override
    public ArrayList<String> getTranslationHistory() {
        if (this.translationHistory.isEmpty()) {
            return new ArrayList<>();
        } else {
            return this.translationHistory;
        }
    }

    /**
     * Sets the translation history of the user.
     *
     * @param translationHistory The new translation history of the user.
     */
    @Override
    public void setTranslationHistory(ArrayList<String> translationHistory) {
        this.translationHistory = translationHistory;
    }

    /**
     * Returns the favorites of the user.
     *
     * @return The favorites of the user.
     */
    @Override
    public ArrayList<String> getFavorites() {
        return favorites;
    }
}