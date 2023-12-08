package use_case.login;

import entity.User;

/**
 * This class handles the login logic of the application.
 * It communicates with the LoginUserDataAccessInterface to fetch user data and validate login credentials.
 * It also communicates with the LoginOutputBoundary to prepare the view based on the login result.
 */
public class LoginInteractor implements LoginInputBoundary {
    // Data access object for user data, typically interfacing with a database.
    final LoginUserDataAccessInterface userDataAccessObject;

    // Presenter for handling the output of the login process.
    final LoginOutputBoundary loginPresenter;

    /**
     * Constructor for the LoginInteractor class.
     * It initializes the interactor with a data access object and a presenter.
     *
     * @param userDataAccessInterface The data access object for user data.
     * @param loginOutputBoundary The presenter for handling the output of the login process.
     */
    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    /**
     * Processes the login request.
     * It validates the username and password provided in the LoginInputData.
     * If the login is successful, it prepares the success view.
     * If the login fails, it prepares the failure view with an appropriate error message.
     *
     * @param loginInputData The LoginInputData instance containing the username and password.
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        // Extracting username and password from the input data.
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();

        // Check if the username field is empty.
        if (username == null || username.isEmpty()) {
            // Inform the presenter that login failed due to empty username.
            loginPresenter.prepareFailView("Username cannot be empty.");
            return; // Early return to stop further processing.
        }

        // Check if the password field is empty.
        if (password == null || password.isEmpty()) {
            // Inform the presenter that login failed due to empty password.
            loginPresenter.prepareFailView("Password cannot be empty.");
            return; // Early return to stop further processing.
        }

        // Check if a user with the given username exists.
        if (!userDataAccessObject.existsByName(username)) {
            // User does not exist, report failure via the presenter.
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            // Fetch the stored password for the user.
            String storedPassword = userDataAccessObject.get(username).getPassword();

            // Check if the provided password matches the stored password.
            if (!password.equals(storedPassword)) {
                // Passwords do not match, report failure via the presenter.
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {
                // Login successful, create output data.
                User user = userDataAccessObject.get(username);
                LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);

                // Inform the presenter to prepare the success view.
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}