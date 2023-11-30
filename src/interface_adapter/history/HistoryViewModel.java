package interface_adapter.history;

import interface_adapter.ViewModel;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HistoryViewModel extends ViewModel {
    public final String TITLE_LABEL = "Sign Up View";

    private HistoryState state = new HistoryState();

    public HistoryViewModel() {
        super("sign up");
    }

    public void setState(HistoryState state) {
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

    public HistoryState getState() {
        return state;
    }

    public String[][] getData() {
        HistoryViewReader historyViewReader = new HistoryViewReader();
        String filePAth = getfilePath(); // TODO implement a method for this
        return HistoryViewReader.readData(this, filePath);
    }

    public String[] getTitles() {
        HistoryViewReader historyViewReader = new HistoryViewReader();
        String filePAth = getfilePath(); // TODO implement a method for this
        return HistoryViewReader.readTitles(this, filePath);
    }

    public void sort() {} //TODO: using sortType, sort data
}