package interface_adapter.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SignupStateDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SignupState#SignupState()}
     *   <li>{@link SignupState#setPassword(String)}
     *   <li>{@link SignupState#setPasswordError(String)}
     *   <li>{@link SignupState#setRepeatPassword(String)}
     *   <li>{@link SignupState#setRepeatPasswordError(String)}
     *   <li>{@link SignupState#setUsername(String)}
     *   <li>{@link SignupState#setUsernameError(String)}
     *   <li>{@link SignupState#getPassword()}
     *   <li>{@link SignupState#getPasswordError()}
     *   <li>{@link SignupState#getRepeatPassword()}
     *   <li>{@link SignupState#getRepeatPasswordError()}
     *   <li>{@link SignupState#getUsername()}
     *   <li>{@link SignupState#getUsernameError()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SignupState actualSignupState = new SignupState();
        actualSignupState.setPassword("iloveyou");
        actualSignupState.setPasswordError("An error occurred");
        actualSignupState.setRepeatPassword("iloveyou");
        actualSignupState.setRepeatPasswordError("An error occurred");
        actualSignupState.setUsername("janedoe");
        actualSignupState.setUsernameError("janedoe");
        String actualPassword = actualSignupState.getPassword();
        String actualPasswordError = actualSignupState.getPasswordError();
        String actualRepeatPassword = actualSignupState.getRepeatPassword();
        String actualRepeatPasswordError = actualSignupState.getRepeatPasswordError();
        String actualUsername = actualSignupState.getUsername();
        assertEquals("An error occurred", actualPasswordError);
        assertEquals("An error occurred", actualRepeatPasswordError);
        assertEquals("iloveyou", actualPassword);
        assertEquals("iloveyou", actualRepeatPassword);
        assertEquals("janedoe", actualUsername);
        assertEquals("janedoe", actualSignupState.getUsernameError());
    }

    /**
     * Method under test: {@link SignupState#SignupState(SignupState)}
     */
    @Test
    void testConstructor2() {
        SignupState actualSignupState = new SignupState(new SignupState());
        assertEquals("", actualSignupState.getPassword());
        assertEquals("", actualSignupState.getRepeatPassword());
        assertEquals("", actualSignupState.getUsername());
        assertNull(actualSignupState.getPasswordError());
        assertNull(actualSignupState.getRepeatPasswordError());
        assertNull(actualSignupState.getUsernameError());
    }


    /**
     * Method under test: {@link SignupState#clearState()}
     */
    @Test
    void testClearState() {
        SignupState signupState = new SignupState();
        signupState.clearState();
        assertEquals("", signupState.getPassword());
        assertEquals("", signupState.getRepeatPassword());
        assertEquals("", signupState.getUsername());
        assertNull(signupState.getPasswordError());
        assertNull(signupState.getRepeatPasswordError());
        assertNull(signupState.getUsernameError());
    }
}
