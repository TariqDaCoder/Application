package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.Sport;
import edu.metrostate.ApplicationModel.SportsTeam;
import java.util.List;

public class SportsTeamView {
    private SportsTeam team;

    public SportsTeamView(SportsTeam team){
        this.team = team;
    }

    public void displayTeamInfo(){
        System.out.println("Team ID: " + team.getTeamID());
        System.out.println("Team Name: " + team.getTeamID());
    }

}



