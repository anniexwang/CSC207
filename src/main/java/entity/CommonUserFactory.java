package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommonUserFactory implements UserFactory {
/**
 * Requires: password is valid.
 *
 * @param name
 * @param password
 * @param translationHistory
 * @param favorites
 * @return
 **/

    @Override
    public User create(String name, String password, ArrayList<String> translationHistory, ArrayList<String> favorites) {
        return new CommonUser( name, password, translationHistory, favorites );
    }
}
