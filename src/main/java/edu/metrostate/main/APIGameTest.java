package edu.metrostate.main;

import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.ApplicationView.GameView;
import edu.metrostate.jsonPackages.GameAPIClient;

import java.util.List;

public class APIGameTest {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        List<Game> upcomingBasketBallgames = null;
        List<Game> liveFootballgames = null;

        try {
            // Create an instance of GameAPIClient to fetch games
            GameAPIClient client = new GameAPIClient();

            // Fetch basketball games
            upcomingBasketBallgames = client.fetchScheduledBasketballGames();

            // Display all scheduled basketball games
            gameView.displayScheduledGames(upcomingBasketBallgames);

            // Display the details of game number 2 (change the number as needed)
            gameView.displayGameByNumber(upcomingBasketBallgames, 2);

            // Fetch and display live football games
            liveFootballgames = client.fetchLiveFootballGames();
            gameView.displayLiveGames(liveFootballgames);

        } catch (Exception e) {
            System.out.println("An error occurred while fetching the games: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

