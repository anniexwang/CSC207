package interface_adapter.number_languages;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NumberLanguagesViewModel extends ViewModel {
    public final String TITLE_LABEL = "Number of Languages View";
    public final String LANGUAGE_LABEL = "Number of Languages";
    public final String GO_BUTTON_LABEL = "Go";

    private NumberLanguagesState state = new NumberLanguagesState();

    public NumberLanguagesViewModel() {
        super("Number of Languages View");
    }

    public void setState(NumberLanguagesState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public NumberLanguagesState getState() {
        return state;
    }
}
