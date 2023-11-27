package view;

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

    public final String viewName = "Table Preferences";
    private final TableViewModel tableViewModel;

    private final TableController tableController;

    private String[] tableTypes = {"Select", "Only Words", "All", "By Language"};
    private String[] sortTypes = {"Select", "Alphabetical", "Language", "Time Created", "Word Size"};
    final JComboBox typeDropDown = new JComboBox();
    final JComboBox sortDropDown = new JComboBox();
    //TODO: add error field
    final JButton go;

    /**
     * A window with a title and a JButton.
     */
    public TablePreferenceView(TableController tableController, TableViewModel tableViewModel) {
//    public TablePreferenceView(TableViewModel tableViewModel) {
        this.tableViewModel = tableViewModel;
        this.tableViewModel.addPropertyChangeListener(this);
        this.tableController = tableController;

        JLabel title = new JLabel(tableViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (int i = 0; i < tableTypes.length; i++) {
            typeDropDown.addItem(tableTypes[i]);
        }

        for (int i = 0; i < sortTypes.length; i++) {
            sortDropDown.addItem(sortTypes[i]);
        }

        LabelTextPanel typeInfo = new LabelTextPanel(
                new JLabel(tableViewModel.TABLE_TYPE_LABEL), typeDropDown);
        LabelTextPanel sortInfo = new LabelTextPanel(
                new JLabel(tableViewModel.SORT_TYPE_LABEL), sortDropDown);

        JPanel buttons = new JPanel();
        go = new JButton(tableViewModel.GO_BUTTON_LABEL);
        buttons.add(go);

        typeDropDown.addActionListener(this);
        sortDropDown.addActionListener(this);
        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(go)) {
                    TableState currentState = tableViewModel.getState();

                    tableController.execute(
                            currentState.getTableType(),
                            currentState.getSortType()
                    );
                }
            }
        });

        typeDropDown.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                TableState currentState = tableViewModel.getState();
                currentState.setTableType(typeDropDown.getName());
                tableViewModel.setState(currentState);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        sortDropDown.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                TableState currentState = tableViewModel.getState();
                currentState.setSortType(sortDropDown.getName());
                tableViewModel.setState(currentState);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
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
        this.add(sortInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        System.out.println("Click " + evt.getActionCommand());
        if (evt.getSource().equals(go)) {
            tableController.execute(typeDropDown.getName(), sortDropDown.getName());
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TableState state = (TableState) evt.getNewValue();
        if (state.getTableTypeError() != null) {
            JOptionPane.showMessageDialog(this, state.getTableTypeError()); //TODO: edit each error
        }
    }
}
