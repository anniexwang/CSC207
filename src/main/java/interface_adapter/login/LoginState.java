package interface_adapter.login;

/**
 * This class represents the state of the login form.
 * It holds the current values of the username and password fields, as well as any error messages associated with them.
 */
public class LoginState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;

    /**
     * Copy constructor for the LoginState class.
     * It creates a new LoginState with the same values as the provided LoginState.
     *
     * @param copy The LoginState to copy.
     */
    public LoginState(LoginState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    /**
     * Default constructor for the LoginState class.
     * It initializes the username and password to empty strings, and the error messages to null.
     */
    public LoginState() {}

    /**
     * Returns the current username.
     *
     * @return The current username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the current username error message.
     *
     * @return The current username error message.
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Returns the current password.
     *
     * @return The current password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the current password error message.
     *
     * @return The current password error message.
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Sets the current username.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the current username error message.
     *
     * @param usernameError The new username error message.
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the current password.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the current password error message.
     *
     * @param passwordError The new password error message.
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}