package data_access;

import entity.User;

public interface UserTableDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
