package use_case.number_languages;

import entity.User;

public interface NumberLanguagesUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
