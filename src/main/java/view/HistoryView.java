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
        String[] maxRow = new String[1];
        int maxColumnLength = historyViewModel.maxColumnLength(info);
        for (int i=0; i<info.length; i++){
            int rowLength = info[i].length;
            if (rowLength == maxColumnLength) {
                maxRow = info[i];
            }
        }

        for(int i=0; i<info.length; i++) {
            int rowLength = info[i].length;
            int columnLength = columnInfo.length;
            if (columnLength == 1) {
                String[] row = new String[maxColumnLength];
                row[0] = info[i][0];
                data[i] = row;
            }
            else {
                String[] row = new String[columnLength];
                row[0] = info[i][0];
                for (int j = 1; j < columnLength - 1; j += 2) {
                    if (j < rowLength - 1) {
                        if (!info[i][j].toString().equals(maxRow[j].toString())) {
                            row[j + 2] = info[i][j];
                            row[j + 3] = info[i][j + 1];
                            row[j] = "";
                            row[j + 1] = "";
                        } else {
                            row[j] = info[i][j];
                            row[j + 1] = info[i][j + 1];
                        }
                    } else {
                        if (Objects.equals(row[j], null)) {
                            row[j] = "";
                            row[j + 1] = "";
                        }
                    }
                }
                row[columnLength - 1] = info[i][rowLength - 1];
                data[i] = row;
            }
        }
    }
}