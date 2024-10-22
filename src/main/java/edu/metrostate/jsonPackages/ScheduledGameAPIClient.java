package edu.metrostate.jsonPackages;

import edu.metrostate.ApplicationModel.Game;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScheduledGameAPIClient {

    public List<Game> fetchFootballGames() throws Exception {
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
                JSONObject awayTeam = competitorsArray.getJSONObject(0); // Away team
                JSONObject homeTeam = competitorsArray.getJSONObject(1); // Home team

                // Get status information
                JSONObject statusObject = event.getJSONObject("status").getJSONObject("type");
                String statusName = statusObject.getString("name");
                String name = event.getString("name");

                // Get shortName and details
                String shortName = event.optString("shortName", ""); // Default to empty if not present
                String detail = statusObject.getString("description");
                String shortDetail = statusObject.getString("shortDetail");

                // Get broadcast information
                String broadcast = "N/A";
                JSONArray geoBroadcasts = competition.optJSONArray("geoBroadcasts"); // Get geoBroadcasts from the competition
                if (geoBroadcasts != null && geoBroadcasts.length() > 0) {
                    broadcast = geoBroadcasts.getJSONObject(0).optJSONObject("media").optString("shortName", "N/A");
                }

                // Get logos for both teams
                String awayTeamLogo = awayTeam.getJSONObject("team").optString("logo", ""); // Away team logo URL
                String homeTeamLogo = homeTeam.getJSONObject("team").optString("logo", ""); // Home team logo URL

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



    public List<Game> fetchBasketballGames() throws Exception {
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
                JSONObject awayTeam = competitorsArray.getJSONObject(0); // Away team
                JSONObject homeTeam = competitorsArray.getJSONObject(1); // Home team

                // Get status information
                JSONObject statusObject = event.getJSONObject("status").getJSONObject("type");
                String statusName = statusObject.getString("name");
                String name = event.getString("name");

                // Get shortName and details
                String shortName = event.optString("shortName", ""); // Default to empty if not present
                String detail = statusObject.getString("description");
                String shortDetail = statusObject.getString("shortDetail");

                // Get broadcast information
                String broadcast = "N/A";
                JSONArray geoBroadcasts = competition.optJSONArray("geoBroadcasts"); // Get geoBroadcasts from the competition
                if (geoBroadcasts != null && geoBroadcasts.length() > 0) {
                    broadcast = geoBroadcasts.getJSONObject(0).optJSONObject("media").optString("shortName", "N/A");
                }

                // Get logos for both teams
                String awayTeamLogo = awayTeam.getJSONObject("team").optString("logo", ""); // Away team logo URL
                String homeTeamLogo = homeTeam.getJSONObject("team").optString("logo", ""); // Home team logo URL

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

        return games; // Return the list of scheduled games
    }


}
