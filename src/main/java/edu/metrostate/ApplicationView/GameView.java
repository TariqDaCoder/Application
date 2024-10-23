package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.Game;

import java.util.List;

public class GameView {

    public void displayScheduledGames(List<Game> games) {
        System.out.println("Scheduled Games:");

        for (Game game : games) {
            if ("STATUS_SCHEDULED".equals(game.getStatus())) {
                System.out.println("-----------------------------");
                System.out.println("Game Status: " + game.getStatus());
                System.out.println("Name: " + game.getName());
                System.out.println("Short Name: " + game.getShortName());
                System.out.println("Detail: " + game.getDetail());
                System.out.println("Short Detail: " + game.getShortDetail());
                System.out.println("Broadcast: " + game.getBroadcast());
                System.out.println("Away Team: " + game.getAwayTeamDisplayName());
                System.out.println("Away Team Logo: " + game.getAwayTeamLogo());
                System.out.println("Home Team: " + game.getHomeTeamDisplayName());
                System.out.println("Home Team Logo: " + game.getHomeTeamLogo());
                System.out.println("-----------------------------");
            }
        }
    }

    public void displayLiveGames(List<Game> games) {
        System.out.println("Live Games:");

        for (Game game : games) {
            if ("STATUS_IN_PROGRESS".equals(game.getStatus())) {
                System.out.println("-----------------------------");
                System.out.println("Game Status: " + game.getStatus());
                System.out.println("Name: " + game.getName());
                System.out.println("Short Name: " + game.getShortName());
                System.out.println("Detail: " + game.getDetail());
                System.out.println("Short Detail: " + game.getShortDetail());
                System.out.println("Broadcast: " + game.getBroadcast());
                System.out.println("Away Team: " + game.getAwayTeamDisplayName());
                System.out.println("Away Team Score: " + Game.LiveGame.getAwayPoints());
                System.out.println("Away Team Logo: " + game.getAwayTeamLogo());
                System.out.println("Home Team: " + game.getHomeTeamDisplayName());
                System.out.println("Home Team Score: " + Game.LiveGame.getHomePoints());
                System.out.println("Home Team Logo: " + game.getHomeTeamLogo());
                System.out.println("-----------------------------");
            }
        }
    }

    // Method to display a specific game by its number in the list
    public void displayGameByNumber(List<Game> games, int gameNumber) {
        if (gameNumber > 0 && gameNumber <= games.size()) {
            Game game = games.get(gameNumber - 1);
            System.out.println("-----------------------------");
            System.out.println("Game #" + gameNumber);
            System.out.println("Game Status: " + game.getStatus());
            System.out.println("Name: " + game.getName());
            System.out.println("Short Name: " + game.getShortName());
            System.out.println("Detail: " + game.getDetail());
            System.out.println("Short Detail: " + game.getShortDetail());
            System.out.println("Away Team: " + game.getAwayTeamDisplayName());
            System.out.println("Away Team Logo: " + game.getAwayTeamLogo());
            System.out.println("Home Team: " + game.getHomeTeamDisplayName());
            System.out.println("Home Team Logo: " + game.getHomeTeamLogo());
            System.out.println("Broadcast: " + game.getBroadcast());
            System.out.println("-----------------------------");
        } else {
            System.out.println("Invalid game number.");
        }
    }
}
