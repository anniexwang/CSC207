package use_case.signup;

/**
 * This class represents the output data for the signup use case.
 * It holds the username of the user who has signed up and a flag indicating whether the use case failed.
 */
public class SignupOutputData {

    private final String username;
    private boolean useCaseFailed;

    /**
     * Constructor for the SignupOutputData class.
     *
     * @param username The username of the user who has signed up.
     * @param useCaseFailed A flag indicating whether the use case failed.
     */
    public SignupOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Returns the username of the user who has signed up.
     *
     * @return The username of the user who has signed up.
     */
    public String getUsername() {
        return username;
    }

    // You can add a getter for the useCaseFailed field if needed.
}