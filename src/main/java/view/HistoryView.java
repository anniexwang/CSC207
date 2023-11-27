package view;

import interface_adapter.history.HistoryState;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesState;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HistoryView extends JPanel implements PropertyChangeListener {

    public final String viewName = "History View";
    //    private HistoryState historyState;
    JTable history;

    String[][] data;

    String[] columnTitles;

    private HistoryViewModel historyViewModel;

//    ArrayList<List<String>> data = historyViewModel.getData();


    /**
     * The username chosen by the user
     */

    /**
     * A window with a title and a JButton.
     */
    public HistoryView(HistoryViewModel historyViewModel) {
        this.historyViewModel = historyViewModel;
        this.historyViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(historyViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



//        String data[][] = historyViewModel.getData(); //dummy test 1
//        String columnTitles[] = historyViewModel.getTitles();
//        ArrayList<List<String>> data = historyViewModel.getData(historyState.getTableType());
//        ArrayList<List<String>> data = historyViewModel.getData();

        // dummy test 2
//        historyViewModel.getData();

//        String[][] data = historyViewModel.convertToStringArray();
        //data = historyViewModel.convertToStringArray(historyViewModel.sort(historyViewModel.getData()));
        data = new String[100][100];

        // TODO: problem: history view doesn't update, only takes the empty one from the start

        System.out.println("History View Reached");
//        System.out.println("History View getdata print: " + data);

        columnTitles = historyViewModel.getTitles();

//        String columnTitles[] = historyViewModel.getTitles();
//        Object[][] blankdata = null;
//        Object[][] data = historyViewModel.getData();
//        String[][] data = historyViewModel.getData();

//        String columnTitles[] = historyViewModel.getTitles();
//        for (List<String> i : data) {
//            System.out.println("HistoryView i: " + i);
//        }
        //data[0][0] = "123";
        System.out.println(data[0][0]);
        history = new JTable(data, columnTitles);
//        JTable history = new JTable();
//        for (List<String> i : data) {
//            System.out.println("HistoryView i: " + i);
//
//            history.addColumn((TableColumn) i);
//        }

//        DefaultTableModel model = new DefaultTableModel();
//        JTable history = new JTable(model);
//        history.addRow();

//        history.setBounds(30, 40, 200, 300);
        history.setBounds(3, 4, 2, 3);

        JScrollPane scroll = new JScrollPane(history);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(scroll);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HistoryState state = (HistoryState) evt.getNewValue();
//        if (state.getLanguagesError() != null) {
//            JOptionPane.showMessageDialog(this, state.getLanguagesError())
        System.out.println("History View Update Reached");
        System.out.println("History View update getdata print: " + data);
        String[][] info = historyViewModel.convertToStringArray(historyViewModel.sort(historyViewModel.getData()));
        String[] columnInfo = historyViewModel.getTitles();
        String[] maxRow = new String[1];
        int maxColumnLength = historyViewModel.maxColumnLength();
        for(int i=0; i<info.length; i++) {
            String[] row = new String[maxColumnLength];
            int rowLength = info[i].length;
//            if (rowLength == 1) {
//                data[i] = info[0];
//            }
//            else {


            if (rowLength == maxColumnLength) {
                maxRow = info[i];
            }
            row[0] = info[i][0];

            for (int j = 1; j < maxColumnLength - 1; j += 2) {

//                if (row[2*j+1] != maxRow[2*j+1]){
//                    row[2*(j+1)+1] = row[2*j+1];
//                    row[2*(j+1)+2] = row[2*j+2];
//                    row[2*j+1] = "";
//                    row[2*j+2] = "";
//                }
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
//            row[maxColumnLength - 3] = info[i][rowLength - 3];
//            row[maxColumnLength - 2] = info[i][rowLength - 2];
            row[maxColumnLength - 1] = info[i][rowLength - 1];
            data[i] = row;

//            List<String> row =  historyViewModel.separateToColumns(info[i]);

//            System.out.println("HistoryView row: " + historyViewModel.separateToColumns(info[i]));
//            System.out.println("HistoryView row length: " + row.length);
//            System.out.println("HistoryView row length: " + row.size());


//            for(int j=0; j<info[0].length - 1; j++){
//
//                System.out.println("HistoryView info[j]: " + info[j]);
//                data[i][j]=row[j];
////                data[i][j]=row.get(j);
//                System.out.println("HistoryView row[j]: " + row[j]);
//                System.out.println("HistoryView row[j]: " + row.get(j));

//            }
//            }

            for(int j=0; j<columnInfo.length; j++) {
                columnTitles[j] = columnInfo[j];
            }

            System.out.println("HistoryView propertyChange state: " + data[0][0]);

            //    }
        }
    }
}

//package view;
//
//        import interface_adapter.history.HistoryController;
//        import interface_adapter.history.HistoryState;
//        import interface_adapter.history.HistoryViewModel;
//        import interface_adapter.table_preferences.TableState;
//
//        import javax.swing.*;
//        import javax.swing.table.DefaultTableModel;
//        import javax.swing.table.TableColumn;
//        import java.awt.*;
//        import java.awt.event.ActionEvent;
//        import java.awt.event.ActionListener;
//        import java.awt.event.KeyEvent;
//        import java.awt.event.KeyListener;
//        import java.beans.PropertyChangeEvent;
//        import java.beans.PropertyChangeListener;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class HistoryView extends JPanel {
//
//    public final String viewName = "History View";
//    private final HistoryViewModel historyViewModel;
//    private HistoryState historyState;
//
//    /**
//     * The username chosen by the user
//     */
//
//    /**
//     * A window with a title and a JButton.
//     */
////    public HistoryView(HistoryController historyController, HistoryViewModel historyViewModel) {
//    public HistoryView(HistoryViewModel historyViewModel) {
//        HistoryState currentState = historyViewModel.getState();
//
//        historyController.execute(
//                currentState.getTableType(),
//                currentState.getSortType(), currentState.getNumberLanguages(), currentState.getLanguages());
//        this.historyViewModel = historyViewModel;
//
//        JLabel title = new JLabel(historyViewModel.TITLE_LABEL);
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//
////        String data[][] = historyViewModel.getData();
////        String columnTitles[] = historyViewModel.getTitles();
////        ArrayList<List<String>> data = historyViewModel.getData(historyState.getTableType());
//        ArrayList<List<String>> data = historyViewModel.getData();
//
//        System.out.println("getdata print: " + data);
////        String columnTitles[] = historyViewModel.getTitles();
////        Object[][] blankdata = null;
////        Object[][] data = historyViewModel.getData();
////        String[][] data = historyViewModel.getData();
//
//        String columnTitles[] = historyViewModel.getTitles();
//
////        JTable history = new JTable(data, columnTitles);
//        JTable history = new JTable();
//        for (List<String> i : data) {
//
//            history.addColumn((TableColumn) i);
//        }
//
////        DefaultTableModel model = new DefaultTableModel();
////        JTable history = new JTable(model);
////        history.addRow();
//
////        history.setBounds(30, 40, 200, 300);
//        history.setBounds(3, 4, 2, 3);
//
//        JScrollPane scroll = new JScrollPane(history);
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(title);
//        this.add(scroll);
//
//    }
//}