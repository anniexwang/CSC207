package use_case.translate;

import java.io.IOException;
import java.util.List;

public interface TranslateUserDataAccessInterface {
    void addTranslation(String username, List<Object> translation);

    void updateAccounts() throws IOException;
}