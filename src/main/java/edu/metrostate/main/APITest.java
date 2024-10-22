package edu.metrostate.main;

import edu.metrostate.ApplicationModel.BasketBallTeam;
import edu.metrostate.ApplicationModel.FootBallTeam;
import edu.metrostate.ApplicationModel.Sport; // Import the Sport class
import edu.metrostate.jsonPackages.TeamAPIClient;

public class APITest {
    public static void main(String[] args) {
        try {
            // Fetch football teams from the API
            FootBallTeam[] footballTeams = TeamAPIClient.fetchFootBallTeams();
            Sport footballSport = new Sport(1, "Football"); // Create a Sport instance for football
            footballSport.addTeams("NFL", footballTeams); // Add teams to the sport

            // Display football teams
            footballSport.showTeams(); // Call the new showTeams method

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Fetch basketball teams from the API
            BasketBallTeam[] basketballTeams = TeamAPIClient.fetchBasketballTeams();
            Sport basketballSport = new Sport(2, "Basketball"); // Create a Sport instance for basketball
            basketballSport.addTeams("NBA", basketballTeams); // Add teams to the sport

            // Display basketball teams
            basketballSport.showTeams(); // Call the new showTeams method

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
