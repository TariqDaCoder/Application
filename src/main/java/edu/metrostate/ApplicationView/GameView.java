package edu.metrostate.ApplicationView;

import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.main.Scores;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameView {

    public void displayScheduledGames(List<Game> games) {
        System.out.println("Scheduled Games:");

        for (Game game : games) {
            if ("STATUS_SCHEDULED".equals(game.getStatus())) {
                System.out.println("-----------------------------");
                System.out.println("Sport: " + game.getSport().getSportName());
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
                System.out.println("Sport: " + game.getSport().getSportName());
                System.out.println("Game Status: " + game.getStatus());
                System.out.println("Name: " + game.getName());
                System.out.println("Short Name: " + game.getShortName());
                System.out.println("Detail: " + game.getDetail());
                System.out.println("Short Detail: " + game.getShortDetail());
                System.out.println("Broadcast: " + game.getBroadcast());
                System.out.println("Away Team: " + game.getAwayTeamDisplayName());

                if (game instanceof Game.LiveGame) {
                    Game.LiveGame liveGame = (Game.LiveGame) game;
                    System.out.println("Away Team Score: " + liveGame.getAwayPoints());
                    System.out.println("Home Team Score: " + liveGame.getHomePoints());
                } else {
                    System.out.println("Scores not available for this game.");
                }

                System.out.println("Away Team Logo: " + game.getAwayTeamLogo());
                System.out.println("Home Team: " + game.getHomeTeamDisplayName());
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
            System.out.println("Sport: " + game.getSport().getSportName());
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

