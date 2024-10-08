package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.GameScoresModel;
import edu.metrostate.ApplicationView.GameScoresView;

public class GameScoresController {
    private final GameScoresModel model;
    private final GameScoresView view;

    public GameScoresController(GameScoresModel model, GameScoresView view) {
        this.model = model;
        this.view = view;
    }

    public void setGameID(int id) {
        model.setGame_ID(id);
    }

    public void setTeam1ID(int id) {
        model.setTeam1_ID(id);
    }

    public void setTeam2ID(int id) {
        model.setTeam2_ID(id);
    }

    public void setTeam1Score(int score) {
        model.setTeam1Score(score);
    }

    public void setTeam2Score(int score) {
        model.setTeam2Score(score);
    }

    public void updateView() {
        view.displayGameScores(
                model.getGame_ID(),
                model.getTeam1_ID(),
                model.getTeam2_ID(),
                model.getTeam1Score(),
                model.getTeam2Score()
        );
    }

    public void updateScores(int team1Score, int team2Score) {
        model.setTeam1Score(team1Score);
        model.setTeam2Score(team2Score);
        view.displayMessage("Scores updated successfully.");
        updateView();
    }
}
