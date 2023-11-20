package use_case.signup;

import entity.User;
import entity.UserFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory userFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccessInterface,
                            SignupOutputBoundary signupOutputBoundary,
                            UserFactory userFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        // Check if any field is empty
        if (signupInputData.getUsername().isEmpty()) {
            userPresenter.prepareFailView("Username cannot be empty.");
            return;
        }

        if (signupInputData.getPassword().isEmpty()) {
            userPresenter.prepareFailView("Password cannot be empty.");
            return;
        }

        if (signupInputData.getRepeatPassword().isEmpty()) {
            userPresenter.prepareFailView("Repeat password cannot be empty.");
            return;
        }

        // Existing checks for user existence and password match
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {
            // Rest of the signup logic
            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), new ArrayList<>(), new ArrayList<>());
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }

}