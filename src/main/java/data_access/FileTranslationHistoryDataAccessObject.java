package data_access;

//import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.number_languages.NumberLanguagesUserDataAccessInterface;
import use_case.select_languages.SelectLanguagesUserDataAccessInterface;
import use_case.table_preferences.TableUserDataAccessInterface;
//import use_case.table_preferences.TableUserDataAccessInterface;

import java.io.*;
import java.util.*;

//public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, ClearUserDataAccessInterface{

public class FileTranslationHistoryDataAccessObject implements TableUserDataAccessInterface, NumberLanguagesUserDataAccessInterface, SelectLanguagesUserDataAccessInterface {
    private final File csvFile;

    private static String[] headers = null;
//    private String header;


    private static final ArrayList<List<String>> data = new ArrayList<>();

//    private static final List<String> header;

    public FileTranslationHistoryDataAccessObject(String csvPath) throws IOException {

        csvFile = new File(csvPath);

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String header = reader.readLine();
            headers = header.split(",");
            System.out.println("header: " + header);
//                System.out.println("headers: " + headers.toString());

            String row;
            while ((row = reader.readLine()) != null) {
                System.out.println(row);
//                    String[] col = row.split(",");
//                    System.out.println(col);

                List<String> cols = new ArrayList<>();
                cols.add(row);
//                    for (String i: col){
//                        cols.add(i);
//                    }
                data.add(cols);
//                    data.add(col[0]);

            }
        }
    }



    //    @Override
    public static String[] getHeader() {
        return headers;
    }

    //    @Override
    public static ArrayList<List<String>> getData() {
        System.out.println("DAO data print: " + data);

        return data;
    }
}




