package edu.metrostate.ApplicationModel;

public class BasketBallTeam extends SportsTeam {
    private String teamRecord; // team's win-loss record

    public BasketBallTeam(int teamID, String teamName, String teamLogo) {
        super(teamID, teamName, teamLogo); // Call the superclass constructor
    }

    // getter and setter for teamID
    public int getTeamID() {
        return teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public String getTeamRecord() {
        return teamRecord;
    }

    @Override
    public String toString() {
        return "FootBallTeam{" +
                "teamID=" + teamID +
                ", teamName='" + teamName + '\'' +
                ", teamLogo='" + teamLogo + '\'' +
                ", teamRecord='" + teamRecord + '\'' +
                '}';
    }

    public String getName() {
        return teamName;
    }
}
