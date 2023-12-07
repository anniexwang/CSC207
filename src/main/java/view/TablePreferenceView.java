package view;

import interface_adapter.history.HistoryViewModel;
import interface_adapter.history.HistoryState;
import interface_adapter.table_preferences.TableController;
import interface_adapter.table_preferences.TableState;
import interface_adapter.table_preferences.TableViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TablePreferenceView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Table Preferences View";
    private final TableViewModel tableViewModel;

    private final HistoryViewModel historyViewModel;

    private String[] tableTypes = {"Select", "Only Words", "All", "By Language"};
    private String[] sortTypes = {"Select", "None", "Alphabetical", "Time Created", "Word Size"};
    final JComboBox tableDropDown = new JComboBox();

    private final JLabel tableErrorField = new JLabel();
    final JComboBox sortDropDown = new JComboBox();

    private final JLabel sortErrorField = new JLabel();
    final JButton go;

    public TablePreferenceView(TableController tableController, TableViewModel tableViewModel, HistoryViewModel historyViewModel) {
        this.tableViewModel = tableViewModel;
        this.tableViewModel.addPropertyChangeListener(this);
        this.historyViewModel = historyViewModel;

        JLabel title = new JLabel(tableViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add dropdown options for table type
        for (int i = 0; i < tableTypes.length; i++) {
            tableDropDown.addItem(tableTypes[i]);
        }

        // add dropdown options for sort type
        for (int i = 0; i < sortTypes.length; i++) {
            sortDropDown.addItem(sortTypes[i]);
        }

        LabelTextPanel typeInfo = new LabelTextPanel(
                new JLabel(tableViewModel.TABLE_TYPE_LABEL), tableDropDown);
        LabelTextPanel sortInfo = new LabelTextPanel(
                new JLabel(tableViewModel.SORT_TYPE_LABEL), sortDropDown);

        JPanel buttons = new JPanel();
        go = new JButton(tableViewModel.GO_BUTTON_LABEL);
        buttons.add(go);

        tableDropDown.addActionListener(this);
        sortDropDown.addActionListener(this);

        // transfer selected dropdown to controller in the form of a String when go button is pressed

        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(go)) {
                    tableController.execute((String) tableDropDown.getSelectedItem(), (String) sortDropDown.getSelectedItem());
                }
            }
        });

        // set table type when dropdown option is pressed
        tableDropDown.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                TableState currentState = tableViewModel.getState();
                currentState.setTableType((String) tableDropDown.getSelectedItem());
                tableViewModel.setState(currentState);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // set sort type when dropdown option is pressed
        sortDropDown.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                TableState currentState = tableViewModel.getState();
                currentState.setSortType((String) sortDropDown.getSelectedItem());
                tableViewModel.setState(currentState);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(typeInfo);
        this.add(tableErrorField);
        this.add(sortInfo);
        this.add(sortErrorField);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());
        // set table type when table type dropdown is pressed
        if (evt.getSource().equals(tableDropDown)) {
            HistoryState historyState = historyViewModel.getState();
            historyState.setHistoryTableType((String) tableDropDown.getSelectedItem());
        }
        //set sort type when sort type dropdown is pressed
        if (evt.getSource().equals(sortDropDown)) {
            HistoryState historyState = historyViewModel.getState();
            historyState.setHistorySortType((String) sortDropDown.getSelectedItem());
        }
        // make changes in historyViewModel whenever 'go' is pressed
        if (evt.getSource().equals(go)) {
            historyViewModel.firePropertyChanged();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TableState state = (TableState) evt.getNewValue();
        if (state.getTableTypeError() != null) {
            JOptionPane.showMessageDialog(this, state.getTableTypeError());
        }
    }
}
