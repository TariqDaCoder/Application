package edu.metrostate.ApplicationModel;

import java.util.Date;

public class Game {
    private int gameID;
    private Date gameSchedule;
    private String league;
    private SportsTeam teamA;
    private SportsTeam teamB;
    private String gameScore;
    private String gameStatus;
    private SportsTeam homeTeam;

    public Game(int gameID, String league, SportsTeam teamA, SportsTeam teamB, SportsTeam homeTeam, String gameStatus, String gameScore){
        this.gameID = gameID;
        this.league = league;
        this.teamA = teamA;
        this.teamB = teamB;
        this.homeTeam = homeTeam;
        this.gameStatus = gameStatus;
        this.gameScore = gameScore;
    }
    public int getGameID(){
        return gameID;
    }
    public Date getGameSchedule(){return gameSchedule;}
    public String getLeague(){
        return league;
    }
    public SportsTeam getTeamA(){
        return teamA;
    }
    public SportsTeam getTeamB(){
        return teamB;
    }
    public SportsTeam getHomeTeam(){
        return homeTeam;
    }
    public String getGameStatus(){
        return gameStatus;
    }
    public String getGameScore(){
        return gameScore;
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

    //a method to fetch game stat from ESPN using API
    public String getGameStat(int gameID){
        // use API to fetch game statistics, to be implemented
        return " ";
    }
    // a method to fetch game highlights from YouTube & ESPN
    public void watchHighlight(int gameID){
        // use APIs to play the game highlight
        //to be implemented
    }
    //a method to stream live games from YouTube and ESPN
    public void liveStream(int gameID){
        //use APIs to fetch live games
    }

}

