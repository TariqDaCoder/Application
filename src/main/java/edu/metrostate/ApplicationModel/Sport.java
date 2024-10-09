package edu.metrostate.ApplicationModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sport {

    // Attributes
    private int sportID;
    private String sportName;
    private String season;
    private String originCountry;
    private Map<String, List<SportsTeam>> teamsByCategory; // A map to store teams by category

    // Constructor
    public Sport(int sportID, String sportName, String season, String originCountry) {
        this.sportID = sportID;
        this.sportName = sportName;
        this.season = season;
        this.originCountry = originCountry;
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

    // Getters and setters for season
    public String getSeason() {
        return this.season;
    }

    // Getters and setters for originCountry
    public String getOriginCountry() {
        return this.originCountry;
    }

    // Method to get all teams
    public List<SportsTeam> getTeams() {
        List<SportsTeam> allTeams = new ArrayList<>();
        for (List<SportsTeam> teams : teamsByCategory.values()) {
            allTeams.addAll(teams);
        }
        return allTeams;
    }

    // Method to get teams by category
    public List<SportsTeam> getTeams(String category) {
        return teamsByCategory.getOrDefault(category, new ArrayList<>());
    }

    // Method to add a team to a category
    public void addTeam(String category, SportsTeam team) {
        teamsByCategory.putIfAbsent(category, new ArrayList<>());
        teamsByCategory.get(category).add(team);
    }
}
