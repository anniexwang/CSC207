package data_access;

import entity.User;

public interface UserNumberLanguagesDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
