package entity;

import java.util.ArrayList;

/**
 * This class is a factory for creating instances of the CommonUser class.
 * It implements the UserFactory interface.
 */
public class CommonUserFactory implements UserFactory {

    /**
     * Creates a new instance of the CommonUser class.
     *
     * @param name The name of the user.
     * @param password The password of the user.
     * @param translationHistory The translation history of the user.
     * @param favorites The favorites of the user.
     * @return A new instance of the CommonUser class.
     */
    @Override
    public User create(String name, String password, ArrayList<String> translationHistory, ArrayList<String> favorites) {
        return new CommonUser(name, password, translationHistory, favorites);
    }
}