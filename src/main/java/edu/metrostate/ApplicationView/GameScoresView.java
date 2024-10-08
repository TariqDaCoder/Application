package edu.metrostate.ApplicationView;

public class GameScoresView {
    public void displayGameScores(int game_id, int team1_id, int team2_id, int team1Score, int team2Score) {
        System.out.println("Game ID: " + game_id);
        System.out.println("Team 1 (ID: " + team1_id + ") Score: " + team1Score);
        System.out.println("Team 2 (ID: " + team2_id + ") Score: " + team2Score);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
