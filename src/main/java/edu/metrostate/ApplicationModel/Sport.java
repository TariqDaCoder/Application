package edu.metrostate.ApplicationModel;

import edu.metrostate.ApplicationView.SportsTeamView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sport {

    private static final List<Sport> sportsList;  // Static list to hold sport instances

    private final HashMap<String, List<SportsTeam>> teamsByCategory; // HashMap to hold teams by category
    private int sportID;
    private String sportName;

    // Static block to initialize the sportsList with Football and Basketball
    static {
        sportsList = new ArrayList<>();
        sportsList.add(new Sport(1, "Football"));
        sportsList.add(new Sport(2, "Basketball"));
    }

    // Constructor
    public Sport(int sportID, String sportName) {
        this.sportID = sportID;
        this.sportName = sportName;
        this.teamsByCategory = new HashMap<>(); // Initialize the map
    }

    // Getters and setters for ID
    public int getSportID() {
        return this.sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    // Getters and setters for sportName
    public String getSportName() {
        return this.sportName;
    }

    // Static method to retrieve the list of sports
    public static List<Sport> getSportsList() {
        return sportsList;
    }

    // Method to add teams to a specific category
    public void addTeams(String category, SportsTeam[] teams) {
        List<SportsTeam> teamList = teamsByCategory.computeIfAbsent(category, k -> new ArrayList<>());
        for (SportsTeam team : teams) {
            teamList.add(team);
        }
    }

    // Method to retrieve teams by category
    public List<SportsTeam> getTeamsByCategory(String category) {
        return teamsByCategory.getOrDefault(category, new ArrayList<>()); // Return an empty list if category doesn't exist
    }

    // Method to get all teams
    public List<SportsTeam> getTeams() {
        List<SportsTeam> allTeams = new ArrayList<>();
        for (List<SportsTeam> teamList : teamsByCategory.values()) {
            allTeams.addAll(teamList);
        }
        return allTeams;
    }

    // Method to display teams using SportsTeamView
    public void showTeams() {
        SportsTeamView view = new SportsTeamView();
        view.displayTeams(sportName, getTeams()); // Pass the sport name and the list of all teams
    }
}
