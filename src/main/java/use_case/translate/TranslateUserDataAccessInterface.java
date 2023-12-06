package use_case.translate;

import java.util.List;

public interface TranslateUserDataAccessInterface {
    void addTranslation(String username, List<Object> translation);
}