package edu.metrostate.ApplicationModel;

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


    private static final List<String> broadcastLinkList = List.of(
        "https://www.espn.com/",
        "https://www.nba.com/"
    );

    private static final List<String> sportList = List.of("football", "basketball");



    // Constructor
    public Game(Sport sport, String statusName, String name, String shortName, String detail, String shortDetail,
                String broadcast, String awayTeamName, String homeTeamName, String awayTeamId,
                String homeTeamId, String awayTeamLogo, String homeTeamLogo) {
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
    }

    public static class LiveGame extends Game {
        private String awayPoints;
        private String homePoints;

        // Constructor for LiveGame
        public LiveGame(Sport sport, String statusName, String name, String shortName, String detail, String shortDetail,
                        String broadcast, String awayTeamName, String awayPoints, String homeTeamName, String homePoints, String awayTeamId,
                        String homeTeamId, String awayTeamLogo, String homeTeamLogo) {
            // Call the Game constructor with super
            super(sport, statusName, name, shortName, detail, shortDetail, broadcast, awayTeamName, homeTeamName,
                    awayTeamId, homeTeamId, awayTeamLogo, homeTeamLogo);

            this.homePoints = homePoints;
            this.awayPoints = awayPoints;
        }
        public String getHomePoints() {
            return homePoints;
        }

        public String getAwayPoints() {
            return awayPoints;
        }
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
