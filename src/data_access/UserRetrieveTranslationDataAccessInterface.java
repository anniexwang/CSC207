package data_access;

import entity.User;

public interface UserRetrieveTranslationDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
