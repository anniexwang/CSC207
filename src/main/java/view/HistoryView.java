package view;

import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HistoryView extends JPanel {

    public final String viewName = "History";
    private final HistoryViewModel historyViewModel;

    /**
     * The username chosen by the user
     */

    //TODO: add scrollbar
    //TODO: add table

    /**
     * A window with a title and a JButton.
     */
    public HistoryView(HistoryViewModel historyViewModel) {
        this.historyViewModel = historyViewModel;

        JLabel title = new JLabel(historyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        String data[][] = historyViewModel.getData();
        String columnTitles[] = historyViewModel.getTitles();

        JTable history = new JTable(data, columnTitles);
//        history.setBounds(30, 40, 200, 300);
        history.setBounds(3, 4, 2, 3);

        JScrollPane scroll = new JScrollPane(history);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(scroll);

    }
}