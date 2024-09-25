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
}
