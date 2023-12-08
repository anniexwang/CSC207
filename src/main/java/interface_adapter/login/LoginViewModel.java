package interface_adapter.login;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class represents the ViewModel for the Login view.
 * It extends the ViewModel class and provides properties and methods specific to the Login view.
 * It holds the state of the Login view and provides methods to add property change listeners and fire property change events.
 */
public class LoginViewModel extends ViewModel {

    // Labels for the Login view
    public final String TITLE_LABEL = "Log In View";
    public final String USERNAME_LABEL = "Enter username";
    public final String PASSWORD_LABEL = "Enter password";
    public static final String LOGIN_BUTTON_LABEL = "Log in";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    // The state of the Login view
    private LoginState state = new LoginState();

    /**
     * Constructor for the LoginViewModel class.
     * It initializes the view name to "log in".
     */
    public LoginViewModel() {
        super("log in");
    }

    /**
     * Sets the state of the Login view.
     *
     * @param state The new state of the Login view.
     */
    public void setState(LoginState state) {
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
     * Returns the state of the Login view.
     *
     * @return The state of the Login view.
     */
    public LoginState getState() {
        return state;
    }
}