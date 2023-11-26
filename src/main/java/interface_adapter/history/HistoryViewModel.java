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

    public String[][] getData(){
        // test
        String data[][] = {{"a","b"},{"c","d"},{"e","f"},{"g","h"},{"i","j"},{"k","l"},{"m","n"},{"o","p"},{"q","r"},{"s","t"},{"u","v"},{"w","x"},{"y","z"},
                {"a","b"},{"c","d"},{"e","f"},{"g","h"},{"i","j"},{"k","l"},{"m","n"},{"o","p"},{"q","r"},{"s","t"},{"u","v"},{"w","x"},{"y","z"}};
        return data;
    } //TODO: based on all output data from preferences and languages read csv and pick out data

    public String[] getTitles(){
        // test
        String titles[] = {"1","2"};
        return titles;
    } //TODO: get just the titles (first row) of csv

    public void sort(){} //TODO: using sortType, sort data
}