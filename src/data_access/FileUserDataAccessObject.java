package data_access;

import entity.User;
import entity.UserFactory;
//import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.select_languages.SelectLanguagesUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
//import use_case.table_preferences.TableUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

//public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, ClearUserDataAccessInterface{
public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, UserTableDataAccessInterface, UserNumberLanguagesDataAccessInterface, UserSelectLanguagesDataAccessInterface {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("translation_history", 2);
        headers.put("favorites",3);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,translation_history,favorites");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    // Assuming that translation_history and favorites are stored as semicolon-separated strings in the CSV file
                    ArrayList<String> translation_history = new ArrayList<>(Arrays.asList(col[headers.get("translation_history")].split(";")));
                    ArrayList<String> favorites = new ArrayList<>(Arrays.asList(col[headers.get("favorites")].split(";")));
                    User user = userFactory.create(username, password, translation_history, favorites);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }



    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s",
                        user.getName(), user.getPassword(), user.getTranslationHistory(), user.getFavorites());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }
//    @Override
//    public List<String> deleteAllUsers() {
//        List<String> deletedUsers = new ArrayList<>(accounts.keySet());
//        accounts.clear();
//        save();
//        return deletedUsers;
//    }
}




