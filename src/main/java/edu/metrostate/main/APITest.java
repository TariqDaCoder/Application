package edu.metrostate.main;

import edu.metrostate.ApplicationModel.FootBallTeam;
import edu.metrostate.jsonPackages.FootBallTeamAPIClient;

public class APITest {
    public static void main(String[] args) {
        try {
            // Fetch football teams from the API
            FootBallTeam[] teams = FootBallTeamAPIClient.fetchTeams();

            // Print the details of each team
            for (FootBallTeam team : teams) {
                System.out.println("Team ID: " + team.getTeamID());
                System.out.println("Team Name: " + team.getTeamName());
                System.out.println("Team Logo: " + team.getTeamLogo());
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}