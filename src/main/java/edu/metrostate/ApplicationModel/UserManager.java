package edu.metrostate.ApplicationModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class UserManager {
    private static final String FILE_PATH = "users.json";
    private static List<User> userList = new ArrayList<>();
    private static int nextUserID = 1;

    // Load users from the JSON file
    public static void loadUsers() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
            userList = new Gson().fromJson(reader, userListType);
            if (userList == null) userList = new ArrayList<>();  // Initialize if file is empty
            userList.forEach(user -> nextUserID = Math.max(nextUserID, user.getUserId() + 1));
        } catch (IOException e) {
            System.out.println("No existing users found. Starting fresh.");
        }
    }

    // Save users to the JSON file
    public static void saveUsers() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            // Create a Gson instance with pretty printing enabled
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(userList, writer);
            System.out.println("User data saved to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a user if they don't already exist
    public static boolean addUser(User user) {
        if (!isEmailRegistered(user.getEmail())) {
            user.setUserId(nextUserID++);
            userList.add(user);
            saveUsers();
            return true;
        }
        return false;  // User already exists
    }

    // Check if an email is already registered
    public static boolean isEmailRegistered(String email) {
        return userList.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    // Get all users (for authentication or other purposes)
    public static List<User> getUserList() {
        return userList;
    }
}
