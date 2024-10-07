package edu.metrostate.ApplicationModel;

public class FootBallTeam implements SportsTeam{

    //attributes
    private int teamID;
    private String teamName;
    private String teamLogo;
    private String teamRecord; //teams win loss record

    //constructor
    public FootBallTeam(int teamID, String teamName, String teamLogo){
        this.teamID = teamID;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
    }

    // getter and setter for teamID
    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
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

    public void setTeamRecord(String teamRecord) {
        this.teamRecord = teamRecord;
    }

    // Override toString method
    @Override
    public String toString() {
        return "FootBallTeam{" +
                "teamID=" + teamID +
                ", teamName='" + teamName + '\'' +
                ", teamLogo='" + teamLogo + '\'' +
                ", teamRecord='" + teamRecord + '\'' +
                '}';
    }
}
