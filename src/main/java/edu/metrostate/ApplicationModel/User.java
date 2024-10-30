package edu.metrostate.ApplicationModel;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<User> userList = new ArrayList<>(); // User list to store all users
    private static int userIdCounter = 1;

    // Attributes
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<User> friendList;
    private String profilePicture;

    // Constructor
    public User(int userID, String firstName, String lastName, String email, String password, String profilePicture){
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.friendList = new ArrayList<>(); // Initialize friend list
        userList.add(this); // Add to user list
    }

    // Prepopulate the user list with sample users
    static {
        userList.add(new User(1, "Alice", "Smith", "alice@example.com", "password123", "profilePic1.jpg"));
        userList.add(new User(2, "Bob", "Brown", "simeon", "1234", "profilePic2.jpg"));
        // Add more sample users as needed
    }

    public static boolean isEmailRegistered(String email) {
        return userList.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    // Add user to the list
    public static void addUser(User user) {
        userList.add(user);
    }

    // Generate unique user ID
    public static int generateUserId() {
        return userIdCounter++;
    }


    // Getters
    public int getUserId() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public static User getUserById(int userID){
        for (User user : userList) {
            if (user.getUserId() == userID) {
                return user;
            }
        }
        return null;
    }

    // Setters
    public void setUserId(int userId) {
        this.userID = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password; // Ensure to hash this before storing in production
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    // Method to add a friend
    public void addFriend(User friend) {
        if (friend != null && friend.getUserId() != this.userID) {
            if (friendList.stream().noneMatch(f -> f.getUserId() == friend.getUserId())) {
                friendList.add(friend);
            }
        }
    }

    public static List<User> getUserList() {
        return userList;
    }

    // Method to remove a friend
    public void removeFriend(int friendUserId) {
        friendList.removeIf(friend -> friend.getUserId() == friendUserId);
    }
}