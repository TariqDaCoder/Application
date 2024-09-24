package edu.metrostate.liveGame;

public class LiveGame {
    private String gameTime;
    private String teamA;
    private String teamB;
    private int score;

    // Constructor
    public LiveGame(String gameTime, String teamA, String teamB, int score) {
        this.gameTime = gameTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.score = score;
    }

    // Getters
    public String getGameTime() {
        return gameTime;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public int getScore() {
        return score;
    }


    public String streamGame() {
        return "Streaming game between " + teamA + " and " + teamB;
    }

    public void fetchLiveScore() {

    }
}
