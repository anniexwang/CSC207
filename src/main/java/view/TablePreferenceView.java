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
import java.util.ArrayList;
import java.util.List;

public class TablePreferenceView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Table Preferences View";
    private final TableViewModel tableViewModel;

    private final TableController tableController;

    private final HistoryViewModel historyViewModel;

    private String[] tableTypes = {"Select", "Only Words", "All", "By Language"};
    private String[] sortTypes = {"Select", "Alphabetical", "Language", "Time Created", "Word Size"};
    final JComboBox tableDropDown = new JComboBox();

    private final JLabel tableErrorField = new JLabel();
    final JComboBox sortDropDown = new JComboBox();

    private final JLabel sortErrorField = new JLabel();
    // TODO: get error labels to work
    final JButton go;

    /**
     * A window with a title and a JButton.
     */
//    public TablePreferenceView(TableController tableController, TableViewModel tableViewModel) {
    public TablePreferenceView(TableController tableController, TableViewModel tableViewModel, HistoryViewModel historyViewModel) {
//    public TablePreferenceView(TableViewModel tableViewModel) {
        this.tableController = tableController;
        this.tableViewModel = tableViewModel;
        this.tableViewModel.addPropertyChangeListener(this);
        this.historyViewModel = historyViewModel;
//        this.historyViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(tableViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0; i < tableTypes.length; i++) {
            tableDropDown.addItem(tableTypes[i]);
        }

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
//        go.addActionListener(this);
        //TODO: delete after, used to test when buttons are clicked

        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(go)) {
//                    TableState currentState = tableViewModel.getState();
                    tableController.execute((String) tableDropDown.getSelectedItem(), (String) sortDropDown.getSelectedItem());
//                    historyViewModel.firePropertyChanged();
//                    tableController.execute(
//                            currentState.getTableType(),
//                            currentState.getSortType()

                }
            }
        });

        tableDropDown.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                TableState currentState = tableViewModel.getState();
                currentState.setTableType((String) tableDropDown.getSelectedItem());
//                HistoryState historyState = historyViewModel.getState();
//                historyState.setHistoryTableType((String) tableDropDown.getSelectedItem());
//                historyViewModel.setTableType((String) tableDropDown.getSelectedItem());
//                System.out.println((String) tableDropDown.getSelectedItem());
                tableViewModel.setState(currentState);
//                historyViewModel.getData();
//                historyViewModel.firePropertyChanged();
//                historyViewModel.getData((String) tableDropDown.getSelectedItem());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
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
//        go.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {}
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                TableState currentState = tableViewModel.getState();
//                currentState.setUsername(usernameInputField.getText());
//                tableViewModel.setState(currentState);
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {}
//        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(typeInfo);
        this.add(tableErrorField);
        this.add(sortInfo);
        this.add(sortErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource().equals(tableDropDown)) {
            System.out.println((String) tableDropDown.getSelectedItem());
//            System.out.println("TablePreferenceView: historyViewModel.getData(): " + historyViewModel.getData());
            HistoryState historyState = historyViewModel.getState();
            historyState.setHistoryTableType((String) tableDropDown.getSelectedItem());
//            historyViewModel.getData();
//            ArrayList<List<String>> data = historyViewModel.getData();
//            historyViewModel.setData();
//            System.out.println("TablePreferenceView: historyViewModel.getData(): " + historyViewModel.getData());
//            System.out.println("TablePreferenceView: historyViewModel.getData(): " + historyViewModel.convertToStringArray(historyViewModel.getData()));
//            historyViewModel.firePropertyChanged();

//            historyViewModel.setState(historyState);
        }

//        historyViewModel.getData();
        if (evt.getSource().equals(sortDropDown)) {
            System.out.println((String) sortDropDown.getSelectedItem());
//            System.out.println("TablePreferenceView: historyViewModel.getData(): " + historyViewModel.getData());
            HistoryState historyState = historyViewModel.getState();
            historyState.setHistorySortType((String) sortDropDown.getSelectedItem());
//            historyViewModel.getData();
//            ArrayList<List<String>> data = historyViewModel.getData();
//            historyViewModel.setData();
//            System.out.println("TablePreferenceView: historyViewModel.sort(historyViewModel.getData()): " + historyViewModel.sort(historyViewModel.getData()));
//            historyViewModel.firePropertyChanged();

//            System.out.println("TablePreferenceView: historyViewModel.getData(): " + historyViewModel.convertToStringArray(historyViewModel.getData()));
        }

        if (evt.getSource().equals(go)) {
//            tableController.execute((String) tableDropDown.getSelectedItem(), (String) sortDropDown.getSelectedItem());
//            System.out.println("TablePreferenceView: historyViewModel.getData(): " + historyViewModel.getData());
//            HistoryState historyState = historyViewModel.getState();
//            historyState.setHistoryTableType((String) sortDropDown.getSelectedItem());
//            historyViewModel.getData();
            historyViewModel.firePropertyChanged();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TableState state = (TableState) evt.getNewValue();
        System.out.println("TablePreferenceView propertyChange state: " + state);
//        HistoryState historyState = (HistoryState) evt.getNewValue();
//        HistoryState historyState = historyViewModel.getState();
//        historyState.setTableType((String) tableDropDown.getSelectedItem());
        if (state.getTableTypeError() != null) {
            JOptionPane.showMessageDialog(this, state.getTableTypeError());

        }
//        if (historyState.getTableTypeError() != null) {
//            JOptionPane.showMessageDialog(this, historyState.getTableTypeError());
//        }
    }
}
