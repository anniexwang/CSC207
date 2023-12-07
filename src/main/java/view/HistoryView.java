package view;

import interface_adapter.history.HistoryViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Objects;

public class HistoryView extends JPanel implements PropertyChangeListener {

    public final String viewName = "History View";

    JTable history;

    String[][] data;

    String[] columnTitles;

    private HistoryViewModel historyViewModel;

    public HistoryView(HistoryViewModel historyViewModel) {
        this.historyViewModel = historyViewModel;
        this.historyViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(historyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        data = new String[100][100];
        columnTitles = historyViewModel.getTitles();
        history = new JTable(data, columnTitles);
        history.setBounds(3, 4, 2, 3);

        JScrollPane scroll = new JScrollPane(history);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(scroll);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String[][] info;
        try {
            info = historyViewModel.sort(historyViewModel.convertToStringArray(historyViewModel.getData()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String[] columnInfo = historyViewModel.getTitles();
        int maxColumnLength = historyViewModel.maxColumnLength(info);

        for (int i=0; i<info.length; i++) {
            int columnLength = columnInfo.length;
            if (columnLength == 1) {
                String[] row = new String[maxColumnLength];
                row[0] = info[i][0];
                data[i] = row;
            }
            else {
                data[i] = info[i];
            }
        }
    }
}
