package interface_adapter.number_languages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NumberLanguageViewModel {
    public final String TITLE_LABEL = "Table Preferences View";
    public final String TABLE_TYPE_LABEL = "Type";
    public final String LANGUAGE_LABEL = "Language";
    public final String SORT_TYPE_LABEL = "Sort";

    public final String ADD_LANGUAGE_BUTTON_LABEL = "+ Add Language";
    public final String GO_BUTTON_LABEL = "Go";

    private NumberLanguageState state = new NumberLanguageState();

    public NumberLanguageViewModel() {
        super();
    }

    public void setState(NumberLanguageState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public NumberLanguageState getState() {
        return state;
    }
}
