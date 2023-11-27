package use_case.login;

import entity.User;

// LoginInteractor class handles the login logic.
public class LoginInteractor implements LoginInputBoundary {
    // Data access object for user data, typically interfacing with a database.
    final LoginUserDataAccessInterface userDataAccessObject;

    // Presenter for handling the output of the login process.
    final LoginOutputBoundary loginPresenter;

    // Constructor initializes the interactor with a data access object and a presenter.
    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    // execute method processes the login request.
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