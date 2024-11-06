package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.jsonPackages.GameAPIClient;

import java.util.List;

public class GameController {
    private GameAPIClient apiClient;

    public GameController() {
        this.apiClient = new GameAPIClient();
    }

    public List<Game> getFootballGames() throws Exception {
        return apiClient.fetchScheduledFootballGames();
    }

    public List<Game> getBasketballGames() throws Exception {
        return apiClient.fetchScheduledBasketballGames();
    }

    public static String getGameType(Game game) {
        String broadcastLink;
        if ("Basketball".equals(game.getSport().getSportName())) {
            broadcastLink = "https://www.nba.com";
        } else if ("Football".equals(game.getSport().getSportName())) {
            broadcastLink = "https://www.nfl.com";
        } else {
            broadcastLink = "https://www.espn.com/watch/"; // Default link
        }
        return broadcastLink;
    }
}
