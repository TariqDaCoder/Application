package edu.metrostate.main;

import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.ApplicationView.GameView;
import edu.metrostate.jsonPackages.ScheduledGameAPIClient;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        List<Game> games = null;

        try {
            // Create an instance of TeamAPIClient to fetch games
            ScheduledGameAPIClient client = new ScheduledGameAPIClient();

            // Fetch either basketball or football games
            games = client.fetchBasketballGames();  // Or client.fetchFootballGames() for football

            // Display all scheduled games
            gameView.displayScheduledGames(games);

            // Example: Display the details of game number 2 (change the number as needed)
            gameView.displayGameByNumber(games, 2);

        } catch (Exception e) {
            System.out.println("An error occurred while fetching the games: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
