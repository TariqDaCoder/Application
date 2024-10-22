package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.SportsTeam;
import java.util.List;

public class SportsTeamView {


    public SportsTeamView(){

    }

    // Method to display teams
    public void displayTeams(String sportName, List<SportsTeam> teams) {
        System.out.println("Teams in " + sportName + ":");

        // Print team details
        for (SportsTeam team : teams) {
            System.out.println("Team ID: " + team.getTeamID());
            System.out.println("Team Name: " + team.getTeamName());
            System.out.println("Team Logo: " + team.getTeamLogo());
            System.out.println("-----------------------------");
        }
    }

}



