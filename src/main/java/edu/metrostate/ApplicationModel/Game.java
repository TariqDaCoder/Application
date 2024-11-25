package edu.metrostate.ApplicationModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.metrostate.ApplicationController.GameLogger;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Sport sport;
    private String statusName;
    private String name;
    private String shortName;
    private String detail;
    private String shortDetail;
    private String broadcast;
    private String broadcastLink;
    private String awayTeamName;
    private String homeTeamName;
    private String awayTeamId;
    private String homeTeamId;
    private String awayTeamLogo;
    private String homeTeamLogo;
    private String date;
    private String awayPoints;
    private String homePoints;



    private static final List<Game> gamesList = new ArrayList<>();

    private static final List<String> broadcastLinkList = List.of(
            "https://www.espn.com/",
            "https://www.nba.com/"
    );

    // Constructor
    public Game(Sport sport, String statusName, String name, String shortName, String detail, String shortDetail,
                String broadcast, String awayTeamName, String awayPoints, String homeTeamName, String homePoints, String awayTeamId,
                String homeTeamId, String awayTeamLogo, String homeTeamLogo, String date) {
        this.sport = sport;
        this.statusName = statusName;
        this.name = name;
        this.shortName = shortName;
        this.detail = detail;
        this.shortDetail = shortDetail;
        this.broadcast = broadcast;
        this.broadcastLink = "https://www.espn.com/";
        this.awayTeamName = awayTeamName;
        this.homeTeamName = homeTeamName;
        this.awayTeamId = awayTeamId;
        this.homeTeamId = homeTeamId;
        this.awayTeamLogo = awayTeamLogo;
        this.homeTeamLogo = homeTeamLogo;
        this.date = date;
        this.awayPoints = awayPoints;
        this.homePoints = homePoints;
    }

    public static class LiveGame extends Game {


        public LiveGame(Sport sport, String statusName, String name, String shortName, String detail, String shortDetail,
                        String broadcast, String awayTeamName, String awayPoints, String homeTeamName, String homePoints, String awayTeamId,
                        String homeTeamId, String awayTeamLogo, String homeTeamLogo, String date) {
            super( sport,  statusName,  name,  shortName,  detail,  shortDetail,
                    broadcast,  awayTeamName,  awayPoints,  homeTeamName,  homePoints,  awayTeamId,
                    homeTeamId,  awayTeamLogo,  homeTeamLogo,  date);}

    }

    public static class GameFinal extends Game {

        public GameFinal(Sport sport, String statusName, String name, String shortName, String detail, String shortDetail,
                         String broadcast, String awayTeamName, String awayPoints, String homeTeamName, String homePoints, String awayTeamId,
                         String homeTeamId, String awayTeamLogo, String homeTeamLogo, String date) {
            super(sport,  statusName,  name,  shortName,  detail,  shortDetail,
                    broadcast,  awayTeamName,  awayPoints,  homeTeamName,  homePoints,  awayTeamId,
                    homeTeamId,  awayTeamLogo,  homeTeamLogo,  date); gamesList.add(this);}}

    public String getHomePoints() {
        return homePoints;
    }

    public String getAwayPoints() {
        return awayPoints;
    }

    public static List<Game> getAllGames() {
        return gamesList;
    }

    public static void logAllGamesToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File file = new File("games.json");
        List<Game> existingGames = new ArrayList<>();
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Type gameListType = new TypeToken<List<Game>>() {}.getType();
                existingGames = gson.fromJson(reader, gameListType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Game game : gamesList) {
            if (!GameLogger.gameExists(game, existingGames)) {
                existingGames.add(game);
            }
        }
        String json = gson.toJson(existingGames);

        try (Writer writer = new FileWriter(file)) {
            gson.toJson(existingGames, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String getDate(){
        return date;
    }

    public Sport getSport(){
        return sport;
    }

    public String getStatus() {
        return statusName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDetail() {
        return detail;
    }

    public String getShortDetail() {
        return shortDetail;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public String getAwayTeamDisplayName() {
        return awayTeamName;
    }

    public String getHomeTeamDisplayName() {
        return homeTeamName;
    }

    public String getAwayTeamLogo() {
        return awayTeamLogo;
    }

    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }

    public void setSport(){};

    public void setBroadcastLink(){
        // Implement code for setting broadcast link
    };



}