package interface_adapter.history;

import data_access.FileTranslationHistoryDataAccessObject;
import interface_adapter.ViewModel;
import use_case.table_preferences.TableOutputBoundary;
import use_case.table_preferences.TableOutputData;

import javax.swing.text.View;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryViewModel extends ViewModel {
    public final String TITLE_LABEL = "History View";

    //    private HistoryState state = new HistoryState();
    private HistoryState state = new HistoryState();

    private TableOutputData tableOutputData;
//    String tableType = this.state.getTableType();

    private ArrayList<List<String>> data = new ArrayList<>();
    private final ArrayList<List<String>> fileData = FileTranslationHistoryDataAccessObject.getData();


    public HistoryViewModel() {
        super("History View");
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

//     dummy test 1

//    public String[][] getData() {
////         test
//        String data[][] = {{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}, {"i", "j"}, {"k", "l"}, {"m", "n"}, {"o", "p"}, {"q", "r"}, {"s", "t"}, {"u", "v"}, {"w", "x"}, {"y", "z"},
//                {"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}, {"i", "j"}, {"k", "l"}, {"m", "n"}, {"o", "p"}, {"q", "r"}, {"s", "t"}, {"u", "v"}, {"w", "x"}, {"y", "z"}};
//        return data;
//    }
//    public ArrayList<List<String>> getData(String tableType) {

    // dummy test 2
//    public ArrayList<List<String>> getData() {
////        this.data = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        list1.add("a");
//        list1.add("b");
//        List<String> list2 = new ArrayList<>();
//        list2.add("c");
//        list2.add("d");
//        this.data.add(list1);
//        this.data.add(list2);
////        setData(data);
//        return data;
//    }
//public ArrayList<List<String>> getData() {
//    return data;
//}


    public ArrayList<List<String>> getData() {
//    public void getData() {


//    public Object[][] getData() {
//    public List<String> getData() {
//    public String[][] getData() {
//
        System.out.println("HistoryViewModel getData() reached");
        String tableType = this.state.getTableType();
        System.out.println("HistoryViewModel tableType: " + tableType);
//        Object[][] data = null;
//        String[][] data = null;
//        ArrayList<List<String>> tempData = null;
//        ArrayList<List<String>> data = new ArrayList<>();
//        List<String> data = null;
//        System.out.println("HistoryViewModel true/false: " + tableType.equals("All"));

        if (tableType.equals("All")) {
//            tempData = FileTranslationHistoryDataAccessObject.getData();
            for (List<String> i : this.fileData) {
//                System.out.println("HistoryViewModel i: " + i);
                this.data.add(i);
            }

//            System.out.println("HistoryViewModel get all data: " + this.data);
//            this.setData(data);
//            return data;
        } else if (tableType.equals("Only Words")) {
//            List<String> words = new ArrayList<>();
            for (int i = 0; i < this.fileData.size(); i++) {
                List<String> words = new ArrayList<>();
//                System.out.println("HistoryViewModel i: " + this.fileData.get(i));
//                System.out.println("HistoryViewModel i.get(0): " + this.fileData.get(i).get(0).substring(0,1));

                words.add(this.fileData.get(i).get(0).substring(0, 1));
//                System.out.println("HistoryViewModel words: " + words);
                this.data.add(words);
            }
//            this.data.add(words);
            System.out.println("HistoryViewModel get only words data: " + this.data);
//        } else if (tableType.equals("By Language")) {
//            String[][] convertedData = convertToStringArray(fileData);
//            for (String[] row : convertedData) {
//                String[] separatedData = separateToColumns(row);
////                System.out.println("HistoryViewModel length: " + separatedData.length);
//                int lengthOfData = separatedData.length;
//                for (int i = 0; i < lengthOfData - 3; i++) {
////                    if (separatedData[2* i + 1].equals(this.){;}
////                    else if (separatedData[2 * i + 2].equals() ) {;}
//                }
//
////                System.out.println("HistoryViewModel separatedData: " + separatedData);
//
//            }

        }
//
//        for (List<String> i: tempData) {
//            data.concat
//
//        }
//        this.setData(data);
        return data;

    } //TODO: based on all output data from preferences and languages read csv and pick out data

    public void setData(ArrayList<List<String>> data) {
        this.data = data;
    }

//    public void setData() {
//        ArrayList<List<String>> data = new ArrayList<>();
//        List<String> list1 = new ArrayList<>();
//        list1.add("a");
//        list1.add("b");
//        List<String> list2 = new ArrayList<>();
//        list2.add("c");
//        list2.add("d");
//        data.add(list1);
//        data.add(list2);
//
//
//        this.data = data;
//    }

//
    // dummy test 1 & 2
//    public String[] getTitles(){
//
//        // test
//        String titles[] = {"1","2"};
//        return titles;
//    }
//
//    public String[] separateToColumns(String[] stringList) {
//        System.out.println("separateToColumns reached");
//        int lengthOfList = stringList.length;
//
//
//        String[] columns = new String[2 * lengthOfList];
//        columns[0] = stringList[0];
//        System.out.println("historyViewModel first element: " + stringList[0]);
//        for (int i = 0; i < lengthOfList - 1; i++) {
//            System.out.println("historyViewModel separateToColumns for loop reached");
//            String hashmaps = stringList[i + 1];
//            System.out.println("historyViewModel substring: " + hashmaps.substring(4, hashmaps.length() - 4));
//            hashmaps = hashmaps.substring(4, hashmaps.length() - 4);
//            String[] splitComma = hashmaps.split(", ");
//            for (int j = 0; j < splitComma.length - 1; j++) {
//                String[] splitToHashmap = splitComma[j].split(":");
//                System.out.println("historyViewModel split: " + hashmaps.split(":").toString());
//                System.out.println("historyViewModel split length: " + splitToHashmap.length);
//
//                columns[2 * i + 1] = splitToHashmap[0];
//                columns[2 * i + 2] = splitToHashmap[1];
//            }
//        }
//        columns[lengthOfList] = stringList[lengthOfList - 1];
//        System.out.println("historyViewModel columns length: " + columns.length);
//        System.out.println("historyViewModel columns index length: " + columns.length);
//        return columns;
//    }

//    public String[] separateToColumns(String stringList) {
//        System.out.println("separateToColumns reached");
//        int lengthOfList = stringList.length();
//        System.out.println("historyViewModel substring: " + stringList.substring(4, lengthOfList - 4));
////        stringList.substring(4, lengthOfList - 4);
//
//        String[] splitComma = stringList.split(", ");
//        String[] columns = new String[2*splitComma.length + 2];
//        columns[0] = splitComma[0];
//        for (int i = 0; i < splitComma.length - 1; i++) {
//            String[] splitToValue = splitComma[1].split(":");
//            for (int j = 0; j < splitToValue.length - 1; j++) {
//                columns[2 * i + 1] = splitToValue[0];
//                columns[2 * i + 2] = splitToValue[1];
//            }
//        }
//        columns[lengthOfList] = splitComma[lengthOfList - 1];
//
//
////        System.out.println("historyViewModel split: " + hashmaps.split(":").toString());
////        System.out.println("historyViewModel split length: " + splitToHashmap.length);
////
////        System.out.println("historyViewModel columns length: " + columns.length);
////        System.out.println("historyViewModel columns index length: " + columns.length);
//        return columns;
//    }

    public String[] separateToColumns(String[] stringList) {
        System.out.println("separateToColumns reached");
//        System.out.println("historyViewModel stringList: " + stringList.length);
        String toString = stringList[0];
        toString = toString.replace("{", "");
        toString = toString.replace("}", "");
        String[] splitComma = toString.split(", ");
        int lengthOfList = splitComma.length;
        if (lengthOfList > 1) {
            String[] columns = new String[2 * lengthOfList - 2];
            columns[0] = splitComma[0];
            System.out.println("historyViewModel splitComma 0: " + splitComma[0]);
            System.out.println("historyViewModel splitComma 1: " + splitComma[1]);

//            for (int i = 0; i < lengthOfList; i++) {
//
//            System.out.println("historyViewModel separateToColumns for loop reached");
//            String hashmaps = stringList[i + 1];
//            System.out.println("historyViewModel substring: " + hashmaps.substring(4, hashmaps.length() - 4));
//            hashmaps = hashmaps.substring(4, hashmaps.length() - 4);
            int i = 0;
            for (int j = 1; j < splitComma.length - 1; j++) {
                String[] splitToHashmap = splitComma[j].split(":");
//                    System.out.println("historyViewModel split: " + splitComma.split(":").toString());
                System.out.println("historyViewModel split length: " + splitToHashmap.length);

                columns[2 * i + 1] = splitToHashmap[0];
                columns[2 * i + 2] = splitToHashmap[1];
                i++;
//                }
            }
            columns[2 * lengthOfList - 3] = splitComma[lengthOfList - 1];
//            System.out.println("historyViewModel columns length: " + columns.length);
//            System.out.println("historyViewModel columns index length: " + columns.length);


            return columns;
        }
        else{
            return stringList;
        }
    }

//    public List<String> separateToColumns(String[] stringList) {
//        int lengthOfList = stringList.length;
//        List<String> columns =  new ArrayList<>();
//        columns.add(stringList[0]);
//        for (int i = 0; i <= lengthOfList - 3; i++) {
//            String hashmaps = stringList[i + 1];
//            hashmaps.substring(1, hashmaps.length() - 1);
//            String[] splitToHashmap = hashmaps.split(": ");
//            columns.add(splitToHashmap[0]);
//            columns.add(splitToHashmap[1]);
//        }
//        columns.add(stringList[lengthOfList - 1]);
//        return columns;
//    }

//    public String[] separateToColumns(String[] stringList) {
//        int lengthOfList = stringList.length;
//        String[] columns =  new String[2*lengthOfList-2];
//        columns[0] = stringList[0];
//        for (int i = 0; i <= lengthOfList - 3; i++) {
//            String hashmaps = stringList[i + 1];
//
//            hashmaps.substring(1, hashmaps.length() - 1);
//            System.out.println(hashmaps);
//            String[] splitToHashmap = hashmaps.split(": ");
//            System.out.println(splitToHashmap);
//            columns[2* i + 1] = splitToHashmap[0];
//            columns[2 * i + 2] = splitToHashmap[1];
//        }
//        columns[lengthOfList] = stringList[lengthOfList - 1];
//        return columns;
//    }

    public int maxColumnLength(){
        List<Integer> allDataLength = new ArrayList<>();
        for (int i = 0; i < convertToStringArray(fileData).length; i++){
            allDataLength.add(convertToStringArray(fileData)[i].length);
        }
        int numberOfTitles = Collections.max(allDataLength);
        return numberOfTitles;
    }
    //    List<Integer> allDataLength = new ArrayList<>();
//        for (int i = 0; i < data.length; i++){
//        allDataLength.add(data[i].length);
//    }
//    int numberOfTitles = Collections.max(allDataLength);
//        return numberOfTitles;
    public String[] getTitles(){
//        return separateToColumns(FileTranslationHistoryDataAccessObject.getHeader());
        String tableType = this.state.getTableType();
        String sortType = this.state.getSortType();
        String[] fileHeaders = FileTranslationHistoryDataAccessObject.getHeader();
        int numberOfTitles = maxColumnLength();
//
//        if (tableType.equals("Only Words")) {
//            String[] titles = new String[1];
//            titles[0] = fileHeaders[0];
//            return titles;
//        }
//        else {
        int lengthOfHeaders = fileHeaders.length;
        String[] titles = new String[numberOfTitles];
        titles[0] = fileHeaders[0];
        for (int i = 0; i <= (numberOfTitles - 2)/2 - 1; i++) {
            titles[2 * i + 1] = "language";
            titles[2 * i + 2] = "translation";
        }
        titles[numberOfTitles - 1] = fileHeaders[lengthOfHeaders - 1];
        return titles;
//        }
    } //TODO: get just the titles (first row) of csv

//    public String[][] convertToStringArray(){
//
//        if (getData().isEmpty()) {
//            String[][] toStringArray = new String[0][0];
////            System.out.println("HistoryViewModel toStringArray: " + toStringArray);
//            return toStringArray;
//        }
//        else{
//            String[][] toStringArray = new String[getData().size()][getData().get(0).size()];
//
//            for (int i = 0; i < getData().size() - 1; i++) {
//                String[] tempStringArray = new String[getData().get(0).size()];
//
//                for (int j = 0; j < getData().get(i).size() - 1; j++) {
//                    tempStringArray[j] = getData().get(i).get(j);
//                }
//                toStringArray[i] = tempStringArray;
//            }
////            System.out.println("HistoryViewModel toStringArray: " + toStringArray);
//            return toStringArray;
//
////            JTable history = new JTable(toStringArray, columnTitles);
//        }
//
//
//    }

    //dummy test 2
//public String[][] convertToStringArray(){
//
//    if (this.data.isEmpty()) {
//        System.out.println("HistoryViewModel isEmpty: " + this.data.isEmpty());
//        String[][] toStringArray = new String[0][0];
////            System.out.println("HistoryViewModel toStringArray: " + toStringArray);
//        return toStringArray;
//    }
//    else{
//        String[][] toStringArray = new String[this.data.size()][this.data.get(0).size()];
//
//        for (int i = 0; i < this.data.size(); i++) {
//            String[] tempStringArray = new String[this.data.get(0).size()];
//            System.out.println("HistoryViewModel test row convert " + this.data.get(i));
//
//            for (int j = 0; j < this.data.get(0).size(); j++) {
//                tempStringArray[j] = this.data.get(i).get(j);
//                System.out.println("HistoryViewModel test individual convert " + this.data.get(i).get(j));
//            }
//
//            toStringArray[i] = separateToColumns(tempStringArray);
//        }
////            System.out.println("HistoryViewModel toStringArray: " + toStringArray);
//        return toStringArray;
//
////            JTable history = new JTable(toStringArray, columnTitles);
//    }

    public String[][] convertToStringArray(ArrayList<List<String>> data){

        if (data.isEmpty()) {
//            System.out.println("HistoryViewModel isEmpty: " + data.isEmpty());
            String[][] toStringArray = new String[0][0];
//            System.out.println("HistoryViewModel toStringArray: " + toStringArray);
            return toStringArray;
        }
        else{
            String[][] toStringArray = new String[data.size()][data.get(0).size()];

            for (int i = 0; i < data.size(); i++) {
                String[] tempStringArray = new String[data.get(0).size()];
//                System.out.println("HistoryViewModel test row convert " + data.get(i));

                for (int j = 0; j < data.get(0).size(); j++) {
                    tempStringArray[j] = data.get(i).get(j);
//                    System.out.println("HistoryViewModel test individual convert " + data.get(i).get(j));
                }

                System.out.println("historyViewModel temp string array length: " + tempStringArray.length);
//                if (tempStringArray.length == 1){
//                    toStringArray[i] = tempStringArray;
//                }
//                else{
                toStringArray[i] = separateToColumns(tempStringArray);
//                }
            }
//            System.out.println("HistoryViewModel toStringArray: " + toStringArray);
            return toStringArray;

//            JTable history = new JTable(toStringArray, columnTitles);
        }



    }

//    public void sort(){
//
//    } //TODO: using sortType, sort data

    public ArrayList<List<String>> sort(ArrayList<List<String>> data) {

        System.out.println("HistoryViewModel sort() reached");
        String sortType = this.state.getSortType();
        System.out.println("HistoryViewModel sortType: " + sortType);

        if (sortType.equals("Alphabetical")) {

        } else if (sortType.equals("Language")) {
//
        } else if (sortType.equals("Time Created")) {

        }
        else if (sortType.equals("Word Size")) {

        }
        return data;
    }
}

//    public ArrayList<List<String>> sort(ArrayList<List<String>> data) {
//
//        System.out.println("HistoryViewModel sort() reached");
//        String sortType = this.state.getSortType();
//        System.out.println("HistoryViewModel sortType: " + sortType);
//        ArrayList<List<String>> sortedData = new ArrayList<>();
//        List<String> words = new ArrayList<>();
//
//        for (int i = 0; i < data.size() - 1; i++){
//            words.add(data.get(0).get(i));
//        }

//        if (sortType.equals("Alphabetical")) {
//            Collections.sort(words);
//            for (int i = 0; i < words.size() - 1; i++) {
//                sortedData.add(data.get(data.indexOf(words)));
//            }
//            return sortedData;
//        }

//        } else if (sortType.equals("Language")) {
////
//        } else if (sortType.equals("Time Created")) {
//
//        }
//        else if (sortType.equals("Word Size")) {
//
////        }
//        return data;
//    }
//
//}

//package interface_adapter.history;
//
//// TODO Complete me
//
//        import java.util.ArrayList;
//        import java.util.Collections;
//        import java.util.List;
//
//public class HistoryViewModel {
//    //    private List<String> deletedUsers;
//    private String tableType;
//    private ArrayList<List<String>> outputData;
//
//    //    public List<String> getDeletedUsers() {
////        if (deletedUsers == null) {
////            return Collections.emptyList();
////        }
////        return deletedUsers;
////    }
//    public void getOutputData(ArrayList<List<String>> outputData) {return outputData;}
//    }
//
//    public void setTableType(String tableType) {
//        this.tableType = tableType;
//    }
//
//    public void setOutputData(ArrayList<List<String>> outputData) {
//        this.outputData = outputData;
//    }
//}