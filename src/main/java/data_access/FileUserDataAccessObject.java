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

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, TranslateUserDataAccessInterface {
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

        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("translation_history", 2);
        headers.put("favorites", 3);

        if (!csvFile.exists() || csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] parts = row.split(",", 3); // Split into 3 parts: username, password, and the rest
                    if (parts.length < 3) {
                        continue; // Invalid row format
                    }

                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String restOfRow = parts[2].trim();

                    // Custom logic to extract translation_history and favorites
                    // Assuming translation_history always starts with [[ and ends with ]]
                    int endIndex = restOfRow.indexOf("]],") + 2;
                    String translationHistoryRaw = restOfRow.substring(0, endIndex);
                    String favoritesRaw = restOfRow.substring(endIndex + 1).trim();

                    ArrayList<String> translationHistory = parseTranslationHistory(translationHistoryRaw);
                    ArrayList<String> favorites = new ArrayList<>();

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
                // Formatting translation history and favorites correctly
                String translationHistoryStr = formatListForCsv(user.getTranslationHistory());
                String favoritesStr = formatListForCsv(user.getFavorites());

                String line = String.format("%s,%s,%s,%s",
                        user.getName(), user.getPassword(), translationHistoryStr, favoritesStr);
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Helper method to format an ArrayList into a CSV-compatible string
    private String formatListForCsv(ArrayList<String> list) {
        if (list.isEmpty()) {
            return "[]"; // Return empty brackets for an empty list
        }
        return "[" + String.join(",", list) + "]";
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
        ArrayList<String> translationHistory = new ArrayList<>();
        if (field == null || field.isEmpty()) {
            return translationHistory;
        }

        // Remove leading and trailing brackets if they exist
        String trimmedField = field.replaceAll("^\\[\\[|\\]\\]$", "");

        // Split the string by '],[' into an array to separate the inner lists
        String[] innerLists = trimmedField.split("\\],\\[");

        for (String innerList : innerLists) {
            // Split the inner list by ', ' into an array to separate the elements
            String[] elements = innerList.split(", ", -1);
            if (elements.length < 3) {
                continue;
            }

            // The first element is the original text
            String originalText = elements[0];

            // The second element is the map of translations
            String translationMap = elements[1];

            // The third element is the timestamp
            String timestamp = elements[2];

            // Create a string representation of the inner list and add it to the translation history
            String translationEntry = "[" + originalText + ", " + translationMap + ", " + timestamp + "]";
            translationHistory.add(translationEntry);
        }

        return translationHistory;
    }
    public void updateAccounts() throws IOException {
        accounts.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String header = reader.readLine();
            String row;
            while ((row = reader.readLine()) != null) {
                String[] parts = row.split(",", 3); // Split into 3 parts: username, password, and the rest
                if (parts.length < 3) {
                    continue; // Invalid row format
                }

                String username = parts[0].trim();
                String password = parts[1].trim();
                String restOfRow = parts[2].trim();

                // Custom logic to extract translation_history and favorites
                // Assuming translation_history always starts with [[ and ends with ]]
                int endIndex = restOfRow.indexOf("]],") + 2;
                String translationHistoryRaw = restOfRow.substring(0, endIndex);
                String favoritesRaw = restOfRow.substring(endIndex + 1).trim();

                ArrayList<String> translationHistory = parseTranslationHistory(translationHistoryRaw);
                ArrayList<String> favorites = new ArrayList<>();

                User user = userFactory.create(username, password, translationHistory, favorites);
                accounts.put(username, user);
            }
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

}




