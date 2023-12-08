package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class represents the ViewModel for the Signup view.
 * It extends the ViewModel class and provides properties and methods specific to the Signup view.
 * It holds the state of the Signup view and provides methods to add property change listeners and fire property change events.
 */
public class SignupViewModel extends ViewModel {

    // Labels for the Signup view
    public static final String CLEAR_BUTTON_LABEL = "Clear";
    public static final String TITLE_LABEL = "Sign Up";
    public static final String USERNAME_LABEL = "Choose username";
    public static final String PASSWORD_LABEL = "Choose password";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";
    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public static final String SKIP_BUTTON_LABEL = "Skip To Login";

    // The state of the Signup view
    private SignupState state = new SignupState();

    /**
     * Constructor for the SignupViewModel class.
     * It initializes the view name to "sign up".
     */
    public SignupViewModel() {
        super("sign up");
    }

    /**
     * Sets the state of the Signup view.
     *
     * @param state The new state of the Signup view.
     */
    public void setState(SignupState state) {
        this.state = state;
    }

    // PropertyChangeSupport object to manage property change listeners
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event.
     * This method is called to let the ViewModel know to alert the View of a change in state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener.
     *
     * @param listener The property change listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Returns the state of the Signup view.
     *
     * @return The state of the Signup view.
     */
    public SignupState getState() {
        return state;
    }
}