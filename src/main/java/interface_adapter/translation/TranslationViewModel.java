package interface_adapter.translation;
import interface_adapter.ViewModel;
import interface_adapter.signup.SignupState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TranslationViewModel extends ViewModel{

    public static final String TRANSLATE_BUTTON_LABEL= "Translate";
    public static final String TRANSLATE_OUTPUT = "";
    public static final String BACK_TO_SIGNUP = "Back to Signup";
    public static final String GET_HISTORY = "Get Translation History";

    private TranslationState state = new TranslationState();
    public void setState(TranslationState state) {
        this.state = state;
    }

    public TranslationViewModel() {super("translate");}

    // extend ViewModel (rewrite fireProperty changes)
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TranslationState getState() {
        return state;
    }
}