package edu.metrostate.ApplicationController;
import edu.metrostate.ApplicationView.GameView;
import edu.metrostate.ApplicationModel.Game;

//
public class GameController {
    private Game model;
    private GameView view;
    public GameController(Game model, GameView view){
        this.model = model;
        this.view = view;
    }
    //retrieve gameID for use in other methods
    public int getGameID(){
        return model.getGameID();
    }
    //display game statistics
    public void gameStat(int gameID){
        view.displayGameStat(gameID);
    }

    //display game highlight
    public void watchGameHighlight(int gameID){
        view.displayGameHighlight(gameID);
    }
    //stream live game
    public void watchLiveGame(int gameID){
        view.displayLiveGame(gameID);
    }

}
