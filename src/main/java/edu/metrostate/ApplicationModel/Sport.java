package edu.metrostate.ApplicationModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sport {

    private static final List<Sport> sportsList;

    private final HashMap<String, List<SportsTeam>> teamsByCategory;
    private final List<Game> games;
    private int sportID;
    private String sportName;


    static {
        sportsList = new ArrayList<>();
        sportsList.add(new Sport(1, "Football"));
        sportsList.add(new Sport(2, "Basketball"));
    }

    public Sport(int sportID, String sportName) {
        this.sportID = sportID;
        this.sportName = sportName;
        this.teamsByCategory = new HashMap<>();
        this.games = new ArrayList<>();
    }

    public int getSportID() {
        return this.sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getSportName() {
        return this.sportName;
    }
    public static List<Sport> getSportsList() {
        return sportsList;
    }

    public void addTeams(String category, SportsTeam[] teams) {
        List<SportsTeam> teamList = teamsByCategory.computeIfAbsent(category, k -> new ArrayList<>());
        for (SportsTeam team : teams) {
            teamList.add(team);
        }
    }

    public List<SportsTeam> getTeamsByCategory(String category) {
        return teamsByCategory.getOrDefault(category, new ArrayList<>());
    }

    public List<SportsTeam> getTeams() {
        List<SportsTeam> allTeams = new ArrayList<>();
        for (List<SportsTeam> teamList : teamsByCategory.values()) {
            allTeams.addAll(teamList);
        }
        return allTeams;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    public static Sport findByName(String name) {
        return sportsList.stream()
                .filter(sport -> sport.sportName.equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportID=" + sportID +
                ", sportName='" + sportName + '\'' +
                ", games=" + games +
                '}';
    }
}