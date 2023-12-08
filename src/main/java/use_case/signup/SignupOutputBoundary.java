package use_case.signup;

/**
 * This interface represents the output boundary for the signup use case.
 * It provides methods to prepare the view based on the signup result.
 */
public interface SignupOutputBoundary {

    /**
     * Prepares the success view after a successful signup.
     * It takes a SignupOutputData instance containing the response data,
     * and passes it to the presenter to handle the success view preparation.
     *
     * @param user The SignupOutputData instance containing the response data.
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * Prepares the failure view after a failed signup.
     * It takes an error message, and passes it to the presenter to handle the failure view preparation.
     *
     * @param error The error message.
     */
    void prepareFailView(String error);
}