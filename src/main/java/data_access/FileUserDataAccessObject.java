package data_access;

import entity.User;
import entity.UserFactory;
//import use_case.clear_users.ClearUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;
//import use_case.table_preferences.TableUserDataAccessInterface;
import use_case.translate.TranslateUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, TranslateUserDataAccessInterface{
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    //private helper to get rid of the brackets when reading the csv file
    private ArrayList<String> parseCsvField(String field) {
        if (field == null || field.isEmpty()) {
            return new ArrayList<>();
        }

        // Remove leading and trailing brackets if they exist
        String trimmedField = field.replaceAll("^\\[|\\]$", "");

        // Split the string by semicolons into an array and create a list
        return new ArrayList<>(Arrays.asList(trimmedField.split(";")));
    }

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

                    // Parse translation_history and favorites by splitting the string and removing brackets if present
                    ArrayList<String> translationHistory = parseCsvField(col[headers.get("translation_history")]);
                    ArrayList<String> favorites = parseCsvField(col[headers.get("favorites")]);

                    User user = userFactory.create(username, password, translationHistory, favorites);
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
    @Override
    public void addTranslation(String username, List<Object> translation) {
        User user = get(username);
        if (user != null) {
            // Retrieve the user's current translation history
            ArrayList<String> translationHistory = user.getTranslationHistory();

            // Append the new translation to the list
            translationHistory.add(translation.toString());

            // Update the user's translation history
            user.setTranslationHistory(translationHistory);

            // Save the user
            save(user);
        }
    }
    private ArrayList<String> parseTranslationHistory(String field) {
        if (field == null || field.isEmpty()) {
            return new ArrayList<>();
        }

        // Remove leading and trailing brackets if they exist
        String trimmedField = field.replaceAll("^\\[|\\]$", "");

        // Split the string by '], [' into an array to separate the inner lists
        String[] innerLists = trimmedField.split("\\], \\[");

        ArrayList<String> translationHistory = new ArrayList<>();

        for (String innerList : innerLists) {
            // Remove leading and trailing brackets if they exist
            String trimmedInnerList = innerList.replaceAll("^\\[|\\]$", "");

            // Split the string by ', ' into an array to separate the elements of the inner list
            String[] elements = trimmedInnerList.split(", ");

            // The first element is the original text
            String originalText = elements[0];

            // The second element is the map of translations
            // Remove leading and trailing braces if they exist
            String trimmedMap = elements[1].replaceAll("^\\{|\\}$", "");

            // Split the string by '=' into an array to separate the key and value of the map
            String[] mapElements = trimmedMap.split("=");

            // If the mapElements array has less than 2 elements, skip the current iteration of the loop
            if (mapElements.length < 2) {
                continue;
            }

            // The first element is the language code
            String languageCode = mapElements[0];

            // The second element is the translated text
            String translatedText = mapElements[1];

            // The third element is the timestamp
            LocalDateTime timestamp = LocalDateTime.parse(elements[2]);

            // Create a map for the translation
            Map<String, String> translation = new HashMap<>();
            translation.put(languageCode, translatedText);

            // Create a list for the inner list
            List<Object> innerListElements = new ArrayList<>();
            innerListElements.add(originalText);
            innerListElements.add(translation);
            innerListElements.add(timestamp);

            // Convert the inner list to a string and add it to the translation history
            translationHistory.add(innerListElements.toString());
        }

        return translationHistory;
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

}




