package edu.metrostate.ApplicationView;
import edu.metrostate.ApplicationModel.Game;

public class GameView {
    private Game game;

    public GameView(Game game){
        this.game = game;
    }
    public void displayGameInfo(){
        System.out.printf("%s vs %s \n",game.getTeamA(), game.getTeamB());
        System.out.println("Game Schedule: " + game.getGameSchedule());
        System.out.println("Score: " + game.getGameScore());
        System.out.printf("League: %s   Home Team: %s  \n",game.getLeague(),game.getHomeTeam());
        System.out.println("Game Status: " + game.getGameStatus());
    }
    //display game stat to the user
    public void displayGameStat(int gameID){
        game.getGameStat(gameID);
    }

    //display game highlight to the user
    public void displayGameHighlight(int gameID){
        game.watchHighlight(gameID);
    }
    //display livestream
    public void displayLiveGame(int gameID){
        game.liveStream(gameID);
    }
}
