package use_case.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SignupInputDataDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SignupInputData#SignupInputData(String, String, String)}
     *   <li>{@link SignupInputData#getPassword()}
     *   <li>{@link SignupInputData#getRepeatPassword()}
     *   <li>{@link SignupInputData#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SignupInputData actualSignupInputData = new SignupInputData("janedoe", "iloveyou", "iloveyou");
        String actualPassword = actualSignupInputData.getPassword();
        String actualRepeatPassword = actualSignupInputData.getRepeatPassword();
        assertEquals("iloveyou", actualPassword);
        assertEquals("iloveyou", actualRepeatPassword);
        assertEquals("janedoe", actualSignupInputData.getUsername());
    }
}
