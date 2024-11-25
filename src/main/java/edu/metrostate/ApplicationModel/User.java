package edu.metrostate.ApplicationModel;



import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<User> userList = new ArrayList<>(); // User list to store all users

    // Attributes
    private int userID;
    private String email;
    private String userName;
    private String password;
    private List<User> friendList;
    private String profilePicture;

    // Constructor
    public User(int userID,String email, String userName, String password, String profilePicture) {
        this.userID = userID;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.profilePicture = profilePicture;
        this.friendList = new ArrayList<>(); // Initialize the friend list
        userList.add(this); // Add this user to the list
    }

    // Method to retrieve the user list
    public static List<User> getUserList() {

        return userList; // Return the list of users
    }

    // Mock user creation method
    public static void createMockUsers() {
        System.out.println("Creating mock users...");
        new User(1, "john@example.com", "john", "123", null);
        new User(2,  "jane@example.com", "jane", "456", null);
        for (User user : userList) {
            System.out.println("Created User: " + user.getUserName() + ", Password: " + user.getPassword());
        }
    }

    // Getters
    public int getUserId() {
        return userID;
    }


    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName; // Added getter for userName
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

    public static User getUserById(int userID) {
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


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password; // Ensure to hash this before storing
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

    // Method to remove a friend
    public void removeFriend(int friendUserId) {
        friendList.removeIf(friend -> friend.getUserId() == friendUserId);
    }
}