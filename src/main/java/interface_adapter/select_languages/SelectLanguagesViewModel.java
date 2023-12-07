package interface_adapter.select_languages;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectLanguagesViewModel extends ViewModel {
    public final String TITLE_LABEL = "Select Languages View";
    public final String INSTRUCTION_LABEL1 = "Enter all the languages that you would like in the table.";
    public final String INSTRUCTION_LABEL2 = "Separate each language with a comma, no spaces";
    public final String LANGUAGE_LABEL = "Languages";
    public final String GO_BUTTON_LABEL = "Go";

    private SelectLanguagesState state = new SelectLanguagesState();

    public SelectLanguagesViewModel() {
        super("Select Languages View");
    }

    public void setState(SelectLanguagesState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SelectLanguagesState getState() {
        return state;
    }
}
