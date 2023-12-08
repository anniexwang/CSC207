package use_case.signup;

import entity.User;

/**
 * This interface represents the data access operations for the signup use case.
 * It provides methods to check if a user exists by their username and to save a user.
 */
public interface SignupUserDataAccessInterface {

    /**
     * Checks if a user exists by their username.
     *
     * @param identifier The username of the user.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByName(String identifier);

    /**
     * Saves a user.
     *
     * @param user The user to save.
     */
    void save(User user);
}