package use_case.login;

/**
 * This class represents the input data for the login use case.
 * It holds the username and password provided by the user for the login operation.
 */
public class LoginInputData {

    final private String username;
    final private String password;

    /**
     * Constructor for the LoginInputData class.
     *
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     */
    public LoginInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the username provided by the user.
     *
     * @return The username provided by the user.
     */
    String getUsername() {
        return username;
    }

    /**
     * Returns the password provided by the user.
     *
     * @return The password provided by the user.
     */
    String getPassword() {
        return password;
    }

}