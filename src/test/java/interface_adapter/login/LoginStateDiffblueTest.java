package interface_adapter.login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LoginStateDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link LoginState#LoginState()}
     *   <li>{@link LoginState#setPassword(String)}
     *   <li>{@link LoginState#setPasswordError(String)}
     *   <li>{@link LoginState#setUsername(String)}
     *   <li>{@link LoginState#setUsernameError(String)}
     *   <li>{@link LoginState#getPassword()}
     *   <li>{@link LoginState#getPasswordError()}
     *   <li>{@link LoginState#getUsername()}
     *   <li>{@link LoginState#getUsernameError()}
     * </ul>
     */
    @Test
    void testConstructor() {
        LoginState actualLoginState = new LoginState();
        actualLoginState.setPassword("iloveyou");
        actualLoginState.setPasswordError("An error occurred");
        actualLoginState.setUsername("janedoe");
        actualLoginState.setUsernameError("janedoe");
        String actualPassword = actualLoginState.getPassword();
        String actualPasswordError = actualLoginState.getPasswordError();
        String actualUsername = actualLoginState.getUsername();
        assertEquals("An error occurred", actualPasswordError);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualUsername);
        assertEquals("janedoe", actualLoginState.getUsernameError());
    }

    /**
     * Method under test: {@link LoginState#LoginState(LoginState)}
     */
    @Test
    void testConstructor2() {
        LoginState actualLoginState = new LoginState(new LoginState());
        assertEquals("", actualLoginState.getPassword());
        assertEquals("", actualLoginState.getUsername());
        assertNull(actualLoginState.getPasswordError());
        assertNull(actualLoginState.getUsernameError());
    }

    /**
     * Method under test: {@link LoginState#LoginState(LoginState)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot read field "username" because "copy" is null
        //       at interface_adapter.login.LoginState.<init>(LoginState.java:10)
        //   See https://diff.blue/R013 to resolve this issue.

        new LoginState(null);
    }
}
