package interface_adapter.history;

import data_access.FileTranslationHistoryDataAccessObject;
import data_access.FileUserDataAccessObject;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HistoryViewModel extends ViewModel {
    public final String TITLE_LABEL = "History View";

    private HistoryState state = new HistoryState();
    private ArrayList<List<String>> data = new ArrayList<>();
    private final ArrayList<List<String>> fileData = FileTranslationHistoryDataAccessObject.getData();


    public HistoryViewModel() {
        super("History View");
    }

    public void setState(HistoryState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HistoryState getState() {
        return state;
    }

    public ArrayList<List<String>> getData() {
        String tableType = this.state.getTableType();

        if (tableType.equals("All")) {
            for (List<String> i : this.fileData) {
                this.data.add(i);
            }
        } else if (tableType.equals("Only Words")) {
            for (int i = 0; i < this.fileData.size(); i++) {
                List<String> words = new ArrayList<>();
                words.add(this.fileData.get(i).get(0));
                this.data.add(words);
            }
        }else if (tableType.equals("By Language")) {
            String[] listLanguages = this.state.getLanguages();
            String[] lowerListLanguages = new String[listLanguages.length];
            String[][] newData = convertToStringArray(fileData);

            for (int i = 0; i < listLanguages.length; i++) {
                lowerListLanguages[i] = listLanguages[i].toLowerCase();
            }

            for (int i = 0; i < this.fileData.size(); i++) {
                List<String> row = new ArrayList<>();
                String stringDict = "";
                stringDict = stringDict.concat(newData[i][0]);
                stringDict = stringDict.concat(", ");

                stringDict = stringDict.concat("{");
                for (int j = 1; j < newData[i].length; j+=2){

                    if (Arrays.asList(lowerListLanguages).contains(newData[i][j])){
                        stringDict = stringDict.concat(newData[i][j]);
                        stringDict = stringDict.concat("=");
                        stringDict = stringDict.concat(newData[i][j+1]);
                        stringDict = stringDict.concat(", ");
                    }
                }
                stringDict = stringDict.substring(0, stringDict.length() - 2);
                stringDict = stringDict.concat("}, ");
                stringDict = stringDict.concat(newData[i][newData[i].length - 1]);
                if (stringDict.split(", ").length > 2) {
                    row.add(stringDict);
                    this.data.add(row);
                }
            }
        }
        return data;
    }

    public void setData(ArrayList<List<String>> data) {
        this.data = data;
    }

    public String[] separateToColumns(String[] stringList) {
        String toString = stringList[0];
        toString = toString.replace("{", "");
        toString = toString.replace("}", "");
        String[] splitComma = toString.split(", ");
        int lengthOfList = splitComma.length;
        if (lengthOfList > 1) {
            String[] columns = new String[2 * lengthOfList - 2];
            columns[0] = splitComma[0].replace("[", "");
            int i = 0;
            for (int j = 1; j < splitComma.length - 1; j++) {
                String[] splitToHashmap = splitComma[j].split("=");
                columns[2 * i + 1] = splitToHashmap[0];
                columns[2 * i + 2] = splitToHashmap[1];
                i++;
            }
            columns[2 * lengthOfList - 3] = splitComma[lengthOfList - 1].replace("]", "");
            return columns;
        } else {
            return stringList;
        }
    }

    public int maxColumnLength(String[][] data){
        List<Integer> allDataLength = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            allDataLength.add(data[i].length);
        }
        if (allDataLength.isEmpty()) {
            return 0; // return default value
        }
        int numberOfTitles = Collections.max(allDataLength);
        return numberOfTitles;
    }

    public String[] getTitles(){
        String tableType = this.state.getTableType();
        String[][] fileDataArray = convertToStringArray(fileData);
        if (fileDataArray.length == 0) {
            return new String[0]; // return an empty array
        }
        int numberOfTitles = maxColumnLength(fileDataArray);
        if (tableType.equals("Only Words")) {
            String[] fileHeaders = FileTranslationHistoryDataAccessObject.getHeader();
            String[] titles = new String[1];
            titles[0] = fileHeaders[0];
            return titles;
        }
        else {
            String[] fileHeaders = FileTranslationHistoryDataAccessObject.getHeader();
            int lengthOfHeaders = fileHeaders.length;
            String[] titles = new String[numberOfTitles];
            titles[0] = fileHeaders[0];
            for (int i = 0; i <= (numberOfTitles - 2)/2 - 1; i++) {
                titles[2 * i + 1] = "language";
                titles[2 * i + 2] = "translation";
            }
            titles[numberOfTitles - 1] = fileHeaders[lengthOfHeaders - 1];
            return titles;
        }
    }

    public String[][] convertToStringArray(ArrayList<List<String>> data){

        if (data.isEmpty()) {
            String[][] toStringArray = new String[0][0];
            return toStringArray;
        }
        else{
            String[][] toStringArray = new String[data.size()][data.get(0).size()];
            for (int i = 0; i < data.size(); i++) {
                String[] tempStringArray = new String[data.get(0).size()];
                for (int j = 0; j < data.get(0).size(); j++) {
                    tempStringArray[j] = data.get(i).get(j);
                }
                toStringArray[i] = separateToColumns(tempStringArray);
            }
            return toStringArray;
        }
    }
    public String[] languageHistory(String[][] data) {
        String[] languages = new String[100];
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length - 1; j+=2){
                if (!Arrays.asList(languages).contains(data[i][j])){
                    languages[index] = data[i][j];
                    index++;
                }
            }
        }
        return languages;
    }

    public String[][] sort(String[][] data) throws ParseException {
        String sortType = this.state.getSortType();
        if (sortType.equals("None")) {
            return data;
        }

        else if (sortType.equals("Alphabetical")) {
            String[] templist = new String[data.length];
            HashMap<String, Integer> hashmap = new HashMap<>();

            for (int i = 0; i <= data.length - 1; i++) {
                templist[i] = data[i][0].toLowerCase();
                hashmap.put(data[i][0].toLowerCase(), i);
            }
            Arrays.sort(templist);

            String[][] finallist = new String[data.length][1];
            for (int i = 0; i <= data.length - 1; i++){
                finallist[i] = data[hashmap.get(templist[i])];
            }
            return finallist;

        } else if (sortType.equals("Time Created")) {
            Date[] templist = new Date[data.length];
            HashMap<String, Integer> hashmap = new HashMap<>();

            for (int i = 0; i <= data.length - 1; i++) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dateFormat = formatter.parse(data[i][data[i].length - 1]);
                templist[i] = dateFormat;
                hashmap.put(data[i][data[i].length - 1], i);
            }

            Arrays.sort(templist);
            String[][] finallist = new String[data.length][1];
            for (int i = 0; i <= data.length - 1; i++){
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String stringFormat = formatter.format(templist[i]);
                finallist[i] = data[hashmap.get(stringFormat)];
            }
            return finallist;

        }
        else if (sortType.equals("Word Size")) {
            Integer[] templist = new Integer[data.length];
            HashMap<Integer, Integer> hashmap = new HashMap<>();

            for (int i = 0; i <= data.length - 1; i++) {
                templist[i] = data[i][0].length();
                hashmap.put(data[i][0].length(), i);
            }
            Arrays.sort(templist);

            String[][] finallist = new String[data.length][1];
            for (int i = 0; i <= data.length - 1; i++){
                finallist[i] = data[hashmap.get(templist[i])];
            }
            return finallist;
        }
        return data;
    }
}