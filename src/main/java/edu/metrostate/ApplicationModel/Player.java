package edu.metrostate.ApplicationModel;

import java.util.Map;
import java.io.File;

public class Player {
    private int playerID;
    private String firstName;
    private String lastName;
    private Map<File, Object> profilePicture;  // Profile picture stored in a map
    private int playerNum;
    private String position;
    private int height;
    private int weight;
    private int age;
    private int yearsActive;
    private Map<String, Object> stats;


    public Player(int playerID, String firstName, String lastName, int playerNum, String position,
                  int height, int weight, int age, int yearsActive,
                  Map<String, Object> stats, Map<File, Object> profilePicture) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerNum = playerNum;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.yearsActive = yearsActive;
        this.stats = stats;
        this.profilePicture = profilePicture;
    }

    public Map<File, Object> getProfilePicture() {
        return profilePicture;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public String getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int getYearsActive() {
        return yearsActive;
    }

    public Map<String, Object> getStats() {
        return stats;
    }
}
