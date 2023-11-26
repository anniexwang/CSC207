package use_case.table_preferences;

import entity.User;

public interface TableUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
