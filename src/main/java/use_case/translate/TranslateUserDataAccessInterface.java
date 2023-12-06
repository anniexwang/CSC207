package use_case.translate;

import entity.User;

public interface TranslateUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
