package interface_adapter.clear;
import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClearViewModel extends ViewModel {
    // defining labels
    public final String TITLE_LABEL = "Clear View";
    public static final String CLEAR_BUTTON_LABEL = "Clear your account";

    // initialize state
    private ClearState state = new ClearState();
    public ClearViewModel() {
        super("clear");
    }
    public void setState(ClearState state) {
        this.state = state;
    }

    // fireProperty
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ClearState getState() {
        return state;
    }
}


