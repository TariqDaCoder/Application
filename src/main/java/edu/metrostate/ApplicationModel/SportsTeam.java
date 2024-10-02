package edu.metrostate.ApplicationModel;
import java.util.ArrayList;
import java.util.List;

public class SportsTeam {
    private static List<SportsTeam> teamList = new ArrayList<>();

    //attributes
    private int teamID;
    private String teamName;
    private String teamLogo;
    private String teamRecord; //teams win loss record
    private List<SportsTeam> teamRoster;

    //constructor
    public SportsTeam(int teamID, String teamName, String teamLogo){
        this.teamID = teamID;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
    }
    // getter and setter for teamID
    public int getTeamID() {
        return teamID;
    }

    // getter and setter for teamLogo
    public String getTeamLogo() {
        return teamLogo;
    }

    // getter and setter for teamRecord
    public String getTeamRecord() {
        return teamRecord;
    }

    // getter and setter for teamRoster
    public List<SportsTeam> getTeamRoster() {
        return teamRoster;
    }

    public void setTeamRoster(List<SportsTeam> teamRoster) {
        this.teamRoster = teamRoster;
    }

    // method to add a team to the roster
    public void addToRoster(SportsTeam team) {
        if (!teamRoster.contains(team)) {
            teamRoster.add(team);
        }
    }

    // method to remove a team from the roster
    public void removeFromRoster(SportsTeam team) {
        teamRoster.remove(team);
    }

    // static method to retrieve a team by ID from the team list
    public static SportsTeam getTeamByID(int teamID) {
        for (int i = 0; i < teamList.size(); i++) {
            SportsTeam team = teamList.get(i);
            if (team.getTeamID() == teamID) {
                return team;
            }
        }
        return null; // return null if no matching team is found
    }

    // static method to get all teams
    public static List<SportsTeam> getAllTeams() {
        return teamList;
    }

}
