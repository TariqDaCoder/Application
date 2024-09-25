package edu.metrostate.ApplicationModel;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<User> userList = new ArrayList<>(); //user list to store all users

    //attributes
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<User> friendList; //
    private String profilePicture;

    //constructor
    public User(int userID, String firstName, String lastName, String email, String password, String profilePicture){
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        userList.add(this);
    }

    //getters
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
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getUserId() == userID) {
                return user;
            }
        }
        return null;
    }

    //setters
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
        this.password = password; // Ensure to hash this before storing
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    //method to add a friend
    public void addFriend(User friend) {
        if (friend != null && friend.getUserId() != this.userID) {
            if (friendList.stream().noneMatch(f -> f.getUserId() == friend.getUserId())) {
                friendList.add(friend);
            }
        }
    }

    //method to remove a friend
    public void removeFriend(int friendUserId) {
        friendList.removeIf(friend -> friend.getUserId() == friendUserId);
    }

}
