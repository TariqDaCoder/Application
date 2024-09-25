package edu.metrostate.ApplicationModel;

public class Game {
    private int gameID;
    private String league;
    private SportsTeam teamA;
    private SportsTeam teamB;
    private String gameResult;
    private String gameStatus;
    private SportsTeam homeTeam;

    public Game(int gameID, String league, SportsTeam teamA, SportsTeam teamB, SportsTeam homeTeam, String gameStatus,String gameResult){
        this.gameID = gameID;
        this.league = league;
        this.teamA = teamA;
        this.teamB = teamB;
        this.homeTeam = homeTeam;
        this.gameStatus = gameStatus;
        this.gameResult = gameResult;
    }
    public int getGameID(){
        return gameID;
    }
    public String getLeague(){
        return league;
    }
    public SportsTeam teamA(){
        return teamA;
    }
    public SportsTeam teamB(){
        return teamB;
    }
    public SportsTeam getHomeTeam(){
        return homeTeam;
    }
    public String getGameStatus(){
        return gameStatus;
    }
    public String getGameResult(){
        return gameResult;
    }
    public void setGameID(int gameID){
        this.gameID = gameID;
    }
    public void setLeague(String league){
        this.league = league;
    }
    public void setTeamA(SportsTeam teamA){
        this.teamA = teamA;
    }
    public void setTeamB(SportsTeam teamB){
        this.teamB = teamB;
    }
    public void setGameResult(String gameResult){
        this.gameResult = gameResult;
    }
    public void setGameStatus(String gameStatus){
        this.gameStatus = gameStatus;
    }
    public void setHomeTeam(SportsTeam homeTeam){
        this.homeTeam = homeTeam;
    }

    public String getGameStat(int gameID){
        // use API to fetch game statistics
        return null; //to be implemented
    }

    public void watchHighlight(int gameID){
        // use APIs to play the game highlight
        //to be implemented
    }

}

