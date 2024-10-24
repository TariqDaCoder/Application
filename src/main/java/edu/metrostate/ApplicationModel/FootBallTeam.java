package edu.metrostate.ApplicationModel;

public class FootBallTeam extends SportsTeam {
    private String teamRecord; // team's win-loss record

    public FootBallTeam(int teamID, String teamName, String teamLogo) {
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
        return "BasketBallTeam{" +
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
