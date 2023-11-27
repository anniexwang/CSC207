package interface_adapter.select_languages;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SelectLanguagesViewModel extends ViewModel {
    public final String TITLE_LABEL = "Select Languages View";
    public final String LANGUAGE_LABEL = "Language"; //TODO: concatenate with i ( Language 1, Language 2, etc.)
    public final String GO_BUTTON_LABEL = "Go";

    private SelectLanguagesState state = new SelectLanguagesState();

    public SelectLanguagesViewModel() {
        super("Select Languages View");
    }

    public void setState(SelectLanguagesState state) {
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

    public SelectLanguagesState getState() {
        return state;
    }

    public void getLanguages(){}; //TODO: get languages from csv file for drop down menu in View
}
