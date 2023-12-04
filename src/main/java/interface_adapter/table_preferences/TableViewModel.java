package interface_adapter.table_preferences;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TableViewModel extends ViewModel {
    public final String TITLE_LABEL = "Table Preferences View";
    public final String TABLE_TYPE_LABEL = "Type";
    public final String SORT_TYPE_LABEL = "Sort";
    public final String GO_BUTTON_LABEL = "Go";

    private TableState state = new TableState();

    public TableViewModel() {
        super("Table Preferences View");
    }

    public void setState(TableState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TableState getState() {
        return state;
    }
}
