package edu.metrostate.liveGame;

public class LiveGameView {
    public void displayGameInfo(String gameTime, String teamA, String teamB, int score) {
        System.out.println("Game Time: " + gameTime);
        System.out.println("Team A: " + teamA + " vs Team B: " + teamB);
        System.out.println("Current Score: " + score);
    }


    public void onStreamButtonClick(LiveGameController controller) {
        System.out.println(controller.streamGame());
    }
}
