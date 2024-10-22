package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.jsonPackages.ScheduledGameAPIClient;

import java.util.List;

public class GameController {
    private ScheduledGameAPIClient apiClient;

    public GameController() {
        this.apiClient = new ScheduledGameAPIClient();
    }

    public List<Game> getFootballGames() throws Exception {
        return apiClient.fetchFootballGames();
    }

    public List<Game> getBasketballGames() throws Exception {
        return apiClient.fetchBasketballGames();
    }
}
