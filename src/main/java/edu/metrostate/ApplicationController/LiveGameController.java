package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.LiveGame;
import edu.metrostate.ApplicationView.LiveGameView;

public class LiveGameController {
    private LiveGame model;
    private LiveGameView view;


    public LiveGameController(LiveGame model, LiveGameView view) {
        this.model = model;
        this.view = view;
    }


    public String streamGame() {
        return model.streamGame();
    }


    public void updateLiveScore() {
        model.fetchLiveScore();
        // After updating the model, update the view with the latest info
        view.displayGameInfo(model.getGameTime(), model.getTeamA(), model.getTeamB(), model.getScore());
    }
}
