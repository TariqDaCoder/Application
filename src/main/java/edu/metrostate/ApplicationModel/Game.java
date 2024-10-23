package edu.metrostate.ApplicationModel;

public class Game {
    private String statusName;
    private String name;
    private String shortName;
    private String detail;
    private String shortDetail;
    private String broadcast;
    private String awayTeamName;
    private String homeTeamName;
    private String awayTeamId;
    private String homeTeamId;
    private String awayTeamLogo;
    private String homeTeamLogo;



    // Constructor
    public Game(String statusName, String name, String shortName, String detail, String shortDetail,
                String broadcast, String awayTeamName, String homeTeamName, String awayTeamId,
                String homeTeamId, String awayTeamLogo, String homeTeamLogo) {
        this.statusName = statusName;
        this.name = name;
        this.shortName = shortName;
        this.detail = detail;
        this.shortDetail = shortDetail;
        this.broadcast = broadcast;
        this.awayTeamName = awayTeamName;
        this.homeTeamName = homeTeamName;
        this.awayTeamId = awayTeamId;
        this.homeTeamId = homeTeamId;
        this.awayTeamLogo = awayTeamLogo;
        this.homeTeamLogo = homeTeamLogo;
    }

    public static class LiveGame extends Game {
        private static String awayPoints;
        private static String homePoints;

        // Constructor for LiveGame
        public LiveGame(String statusName, String name, String shortName, String detail, String shortDetail,
                        String broadcast, String awayTeamName, String awayPoints, String homeTeamName, String homePoints, String awayTeamId,
                        String homeTeamId, String awayTeamLogo, String homeTeamLogo) {
            // Call the Game constructor with super
            super(statusName, name, shortName, detail, shortDetail, broadcast, awayTeamName, homeTeamName,
                    awayTeamId, homeTeamId, awayTeamLogo, homeTeamLogo);

            this.homePoints = homePoints;
            this.awayPoints = awayPoints;
        }
        public static String getHomePoints() {
            return homePoints;
        }

        public static String getAwayPoints() {
            return awayPoints;
        }
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
}
