package use_case.login;

/**
 * This interface represents the input boundary for the login use case.
 * It provides a method to execute a login request.
 */
public interface LoginInputBoundary {

    /**
     * Executes a login request.
     * It takes a LoginInputData instance containing the username and password,
     * and passes it to the interactor to handle the login request.
     *
     * @param loginInputData The LoginInputData instance containing the username and password.
     */
    void execute(LoginInputData loginInputData);
}