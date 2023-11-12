package use_case.select_languages;

import entity.User;

public interface SelectLanguagesUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
