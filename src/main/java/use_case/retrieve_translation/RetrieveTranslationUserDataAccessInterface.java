package use_case.retrieve_translation;

import entity.User;

public interface RetrieveTranslationUserDataAccessInterface
{
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);
}
