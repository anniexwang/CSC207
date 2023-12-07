package interface_adapter.history;

import data_access.FileTranslationHistoryDataAccessObject;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HistoryViewModel extends ViewModel {
    public final String TITLE_LABEL = "History View";

    private HistoryState state = new HistoryState();

    // data for table based on selected options
    private ArrayList<List<String>> data = new ArrayList<>();

    // data after checking user
    private final ArrayList<List<String>> userData = new ArrayList<>();

    // gets the data from the csv
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

    // gets the data based on the table type selected
    public ArrayList<List<String>> getData() {
        // get the username of the current user
        String currentUsername = this.state.getCurrentUsername();

        // check if each translation history is of the current user
        // if so, add to userData
        for (List<String> i : this.fileData){
            boolean checkEqual = currentUsername.equals(i.get(0));
            if (checkEqual){
                List<String> translationHistory = new ArrayList<>();
                translationHistory.add(i.get(1));
                this.userData.add(translationHistory);
            }
        }

        // get the table type selected
        String tableType = this.state.getTableType();

        // adds all rows to data

        if (tableType.equals("All")) {
            for (List<String> i : this.userData) {
                this.data.add(i);
            }
        }
        // only takes the words in translation history which is the first column in each row
        else if (tableType.equals("Only Words")) {
            for (int i = 0; i < this.userData.size(); i++) {
                List<String> words = new ArrayList<>();
                words.add(this.userData.get(i).get(0));
                this.data.add(words);
            }
        }
        // checks if language in data satisfies the inputted language
        else if (tableType.equals("By Language")) {
            // user inputted languages
            String[] listLanguages = this.state.getLanguages();
            // list of languages converted into lowercase
            String[] lowerListLanguages = new String[listLanguages.length];
            // original data converted to String[][]
            String[][] newData = convertToStringArray(userData);

            // makes all inputted languages into lowercase to compare
            for (int i = 0; i < listLanguages.length; i++) {
                lowerListLanguages[i] = listLanguages[i].toLowerCase();
            }

            // remake the list of translation history based on whether the language is correct
            for (int i = 0; i < this.userData.size(); i++) {
                List<String> row = new ArrayList<>();

                // create a new string, add word, new language and translation pairs, and time created
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

    // break up translation history into columns (word, language, translation, time created)
    public String[] separateToColumns(String[] stringList) {
        int index;
        if (stringList.length > 1){
            index = 1;
        }
        else{
            index = 0;
        }

        // get rid of unnecessary characters and solit into columns
        String toString = stringList[index];
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

    // find the row with the most columns
    public int maxColumnLength(String[][] data){
        // list of row lengths
        List<Integer> allDataLength = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            // add each row length to allDataLength
            allDataLength.add(data[i].length);
        }
        if (allDataLength.isEmpty()) {
            return 0; // return default value
        }
        // use the max function to get the max value
        int numberOfTitles = Collections.max(allDataLength);
        return numberOfTitles;
    }

    // get the headers for the table
    public String[] getTitles(){
        String tableType = this.state.getTableType();
        String[][] fileDataArray = convertToStringArray(this.fileData);

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

    // conversion from ArrayList<List<String>> to String[][] which is needed for the table
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

    // get all the different languages that are in translation history
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

    // sort the data based on the sort type selected
    public String[][] sort(String[][] data) throws ParseException {
        String sortType = this.state.getSortType();

        // order in csv
        if (sortType.equals("None")) {
            return data;
        }

        // sort alphabetically
        else if (sortType.equals("Alphabetical")) {
            String[] templist = new String[data.length];
            HashMap<String, Integer> hashmap = new HashMap<>();

            for (int i = 0; i <= data.length - 1; i++) {
                // convert words to lowercase, add word to list of words
                templist[i] = data[i][0].toLowerCase();
                // keep track of word and its translation history
                hashmap.put(data[i][0].toLowerCase(), i);
            }
            // sort the list of words
            Arrays.sort(templist);

            String[][] finallist = new String[data.length][1];
            for (int i = 0; i <= data.length - 1; i++){
                // get the index of each word in the translation history and add it to the final data
                finallist[i] = data[hashmap.get(templist[i])];
            }
            return finallist;

        }

        // sort by creation time
        else if (sortType.equals("Time Created")) {
            // list of all times
            Date[] templist = new Date[data.length];
            HashMap<String, Integer> hashmap = new HashMap<>();

            // convert string to date
            for (int i = 0; i <= data.length - 1; i++) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dateFormat = formatter.parse(data[i][data[i].length - 1]);
                templist[i] = dateFormat;
                hashmap.put(data[i][data[i].length - 1], i);
            }
            // sort by time
            Arrays.sort(templist);

            // get the index of each time in the translation history, convert it back to a string, add it to the final data
            String[][] finallist = new String[data.length][1];
            for (int i = 0; i <= data.length - 1; i++){
                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String stringFormat = formatter.format(templist[i]);
                finallist[i] = data[hashmap.get(stringFormat)];
            }
            return finallist;

        }

        // sort by word size (number of characters in a word)
        else if (sortType.equals("Word Size")) {

            // list of all word lengths
            Integer[] templist = new Integer[data.length];
            HashMap<Integer, Integer> hashmap = new HashMap<>();

            // find each word length and keep track of it's corresponding translation history in hashmap
            for (int i = 0; i <= data.length - 1; i++) {
                templist[i] = data[i][0].length();
                hashmap.put(data[i][0].length(), i);
            }

            Arrays.sort(templist);

            // get the index of each word in the translation history and add it to the final data
            String[][] finallist = new String[data.length][1];
            for (int i = 0; i <= data.length - 1; i++){
                finallist[i] = data[hashmap.get(templist[i])];
            }
            return finallist;
        }
        return data;
    }
}