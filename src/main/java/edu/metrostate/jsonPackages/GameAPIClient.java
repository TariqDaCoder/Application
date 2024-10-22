package edu.metrostate.jsonPackages;

import edu.metrostate.ApplicationModel.Game;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GameAPIClient {

    public List<Game> fetchScheduledFootballGames() throws Exception {
        String urlString = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/scoreboard";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        StringBuilder jsonString = new StringBuilder();
        int data = reader.read();
        while (data != -1) {
            jsonString.append((char) data);
            data = reader.read();
        }

        JSONObject jsonResponse = new JSONObject(jsonString.toString());
        JSONArray eventsArray = jsonResponse.getJSONArray("events");

        List<Game> games = new ArrayList<>();

        for (int i = 0; i < eventsArray.length(); i++) {
            JSONObject event = eventsArray.getJSONObject(i);
            JSONArray competitionsArray = event.getJSONArray("competitions");

            if (competitionsArray.length() > 0) {
                JSONObject competition = competitionsArray.getJSONObject(0);
                JSONArray competitorsArray = competition.getJSONArray("competitors");
                JSONObject awayTeam = competitorsArray.getJSONObject(0);
                JSONObject homeTeam = competitorsArray.getJSONObject(1);

                // Get status information
                JSONObject statusObject = event.getJSONObject("status").getJSONObject("type");
                String statusName = statusObject.getString("name");

                // Only include games with status "STATUS_SCHEDULED"
                if (!"STATUS_SCHEDULED".equals(statusName)) {
                    continue; // Skip this iteration if the game is not scheduled
                }

                String name = event.getString("name");

                // Get shortName and details
                String shortName = event.optString("shortName", ""); // Default to empty if not present
                String detail = statusObject.getString("description");
                String shortDetail = statusObject.getString("shortDetail");

                // Get broadcast information
                String broadcast = "N/A";
                JSONArray geoBroadcasts = competition.optJSONArray("geoBroadcasts");
                if (geoBroadcasts != null && geoBroadcasts.length() > 0) {
                    broadcast = geoBroadcasts.getJSONObject(0).optJSONObject("media").optString("shortName", "N/A");
                }

                // Get logos for both teams
                String awayTeamLogo = awayTeam.getJSONObject("team").optString("logo", "");
                String homeTeamLogo = homeTeam.getJSONObject("team").optString("logo", "");

                // Create the Game object
                Game game = new Game(statusName, name, shortName, detail, shortDetail, broadcast,
                        awayTeam.getJSONObject("team").getString("displayName"),
                        homeTeam.getJSONObject("team").getString("displayName"),
                        awayTeam.getJSONObject("team").getString("id"),
                        homeTeam.getJSONObject("team").getString("id"),
                        awayTeamLogo,
                        homeTeamLogo);
                games.add(game);
            }
        }

        return games;
    }

    public List<Game> fetchLiveFootballGames() throws Exception {
        String urlString = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/scoreboard"; // Update to football URL
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        StringBuilder jsonString = new StringBuilder();
        int data = reader.read();
        while (data != -1) {
            jsonString.append((char) data);
            data = reader.read();
        }

        JSONObject jsonResponse = new JSONObject(jsonString.toString());
        JSONArray eventsArray = jsonResponse.getJSONArray("events");

        List<Game> games = new ArrayList<>();

        for (int i = 0; i < eventsArray.length(); i++) {
            JSONObject event = eventsArray.getJSONObject(i);
            JSONArray competitionsArray = event.getJSONArray("competitions");

            if (competitionsArray.length() > 0) {
                JSONObject competition = competitionsArray.getJSONObject(0);
                JSONArray competitorsArray = competition.getJSONArray("competitors");
                JSONObject awayTeam = competitorsArray.getJSONObject(0);
                JSONObject homeTeam = competitorsArray.getJSONObject(1);

                // Get status information
                JSONObject statusObject = event.getJSONObject("status").getJSONObject("type");
                String statusName = statusObject.getString("name");

                // Only include games that are currently in progress
                if (!"STATUS_IN_PROGRESS".equals(statusName)) {
                    continue; // Skip this iteration if the game is not in progress
                }

                String name = event.getString("name");

                // Get shortName and details
                String shortName = event.optString("shortName", ""); // Default to empty if not present
                String detail = statusObject.getString("description");
                String shortDetail = statusObject.getString("shortDetail");

                // Get broadcast information
                String broadcast = "N/A";
                JSONArray geoBroadcasts = competition.optJSONArray("geoBroadcasts");
                if (geoBroadcasts != null && geoBroadcasts.length() > 0) {
                    broadcast = geoBroadcasts.getJSONObject(0).optJSONObject("media").optString("shortName", "N/A");
                }

                // Get logos for both teams
                String awayTeamLogo = awayTeam.getJSONObject("team").optString("logo", "");
                String homeTeamLogo = homeTeam.getJSONObject("team").optString("logo", "");

                // Create the Game object
                Game game = new Game(statusName, name, shortName, detail, shortDetail, broadcast,
                        awayTeam.getJSONObject("team").getString("displayName"),
                        homeTeam.getJSONObject("team").getString("displayName"),
                        awayTeam.getJSONObject("team").getString("id"),
                        homeTeam.getJSONObject("team").getString("id"),
                        awayTeamLogo,
                        homeTeamLogo);
                games.add(game);
            }
        }

        return games;
    }


    public List<Game> fetchScheduledBasketballGames() throws Exception {
        String urlString = "https://site.api.espn.com/apis/site/v2/sports/basketball/nba/scoreboard";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        StringBuilder jsonString = new StringBuilder();
        int data = reader.read();
        while (data != -1) {
            jsonString.append((char) data);
            data = reader.read();
        }

        JSONObject jsonResponse = new JSONObject(jsonString.toString());
        JSONArray eventsArray = jsonResponse.getJSONArray("events");

        List<Game> games = new ArrayList<>();

        for (int i = 0; i < eventsArray.length(); i++) {
            JSONObject event = eventsArray.getJSONObject(i);
            JSONArray competitionsArray = event.getJSONArray("competitions");

            if (competitionsArray.length() > 0) {
                JSONObject competition = competitionsArray.getJSONObject(0);
                JSONArray competitorsArray = competition.getJSONArray("competitors");
                JSONObject awayTeam = competitorsArray.getJSONObject(0);
                JSONObject homeTeam = competitorsArray.getJSONObject(1);

                // Get status information
                JSONObject statusObject = event.getJSONObject("status").getJSONObject("type");
                String statusName = statusObject.getString("name");

                // Only include games with status "STATUS_SCHEDULED"
                if (!"STATUS_SCHEDULED".equals(statusName)) {
                    continue; // Skip this iteration if the game is not scheduled
                }

                String name = event.getString("name");

                // Get shortName and details
                String shortName = event.optString("shortName", ""); // Default to empty if not present
                String detail = statusObject.getString("description");
                String shortDetail = statusObject.getString("shortDetail");

                // Get broadcast information
                String broadcast = "N/A";
                JSONArray geoBroadcasts = competition.optJSONArray("geoBroadcasts");
                if (geoBroadcasts != null && geoBroadcasts.length() > 0) {
                    broadcast = geoBroadcasts.getJSONObject(0).optJSONObject("media").optString("shortName", "N/A");
                }

                // Get logos for both teams
                String awayTeamLogo = awayTeam.getJSONObject("team").optString("logo", "");
                String homeTeamLogo = homeTeam.getJSONObject("team").optString("logo", "");

                // Create the Game object
                Game game = new Game(statusName, name, shortName, detail, shortDetail, broadcast,
                        awayTeam.getJSONObject("team").getString("displayName"),
                        homeTeam.getJSONObject("team").getString("displayName"),
                        awayTeam.getJSONObject("team").getString("id"),
                        homeTeam.getJSONObject("team").getString("id"),
                        awayTeamLogo,
                        homeTeamLogo);
                games.add(game);
            }
        }

        return games;
    }

    public List<Game> fetchLiveBasketballGames() throws Exception {
        String urlString = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/scoreboard"; // Update to football URL
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        StringBuilder jsonString = new StringBuilder();
        int data = reader.read();
        while (data != -1) {
            jsonString.append((char) data);
            data = reader.read();
        }

        JSONObject jsonResponse = new JSONObject(jsonString.toString());
        JSONArray eventsArray = jsonResponse.getJSONArray("events");

        List<Game> games = new ArrayList<>();

        for (int i = 0; i < eventsArray.length(); i++) {
            JSONObject event = eventsArray.getJSONObject(i);
            JSONArray competitionsArray = event.getJSONArray("competitions");

            if (competitionsArray.length() > 0) {
                JSONObject competition = competitionsArray.getJSONObject(0);
                JSONArray competitorsArray = competition.getJSONArray("competitors");
                JSONObject awayTeam = competitorsArray.getJSONObject(0);
                JSONObject homeTeam = competitorsArray.getJSONObject(1);

                // Get status information
                JSONObject statusObject = event.getJSONObject("status").getJSONObject("type");
                String statusName = statusObject.getString("name");

                // Only include games that are currently in progress
                if (!"STATUS_IN_PROGRESS".equals(statusName)) {
                    continue; // Skip this iteration if the game is not in progress
                }

                String name = event.getString("name");

                // Get shortName and details
                String shortName = event.optString("shortName", ""); // Default to empty if not present
                String detail = statusObject.getString("description");
                String shortDetail = statusObject.getString("shortDetail");

                // Get broadcast information
                String broadcast = "N/A";
                JSONArray geoBroadcasts = competition.optJSONArray("geoBroadcasts");
                if (geoBroadcasts != null && geoBroadcasts.length() > 0) {
                    broadcast = geoBroadcasts.getJSONObject(0).optJSONObject("media").optString("shortName", "N/A");
                }

                // Get logos for both teams
                String awayTeamLogo = awayTeam.getJSONObject("team").optString("logo", "");
                String homeTeamLogo = homeTeam.getJSONObject("team").optString("logo", "");

                // Create the Game object
                Game game = new Game(statusName, name, shortName, detail, shortDetail, broadcast,
                        awayTeam.getJSONObject("team").getString("displayName"),
                        homeTeam.getJSONObject("team").getString("displayName"),
                        awayTeam.getJSONObject("team").getString("id"),
                        homeTeam.getJSONObject("team").getString("id"),
                        awayTeamLogo,
                        homeTeamLogo);
                games.add(game);
            }
        }

        return games;
    }


}