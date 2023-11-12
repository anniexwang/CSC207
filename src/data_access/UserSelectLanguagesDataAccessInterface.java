package data_access;

import entity.User;

public interface UserSelectLanguagesDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
