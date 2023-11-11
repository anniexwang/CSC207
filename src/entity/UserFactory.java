package entity;
import java.util.ArrayList;

public interface UserFactory {
    /** Requires: password is valid. */
//
//    TODO Change ArrayList<String> to made up classes
    User create(String name, String password, ArrayList<String> translationHistory, ArrayList<String> favorites);
}
