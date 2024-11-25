package edu.metrostate.ApplicationController;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.metrostate.ApplicationModel.BasketBallTeam;
import edu.metrostate.ApplicationModel.FootBallTeam;
import org.json.JSONArray;
import org.json.JSONObject;

public class TeamAPIClient {
    public static FootBallTeam[] fetchFootBallTeams() throws Exception {
        String urlString = "https://site.api.espn.com/apis/site/v2/sports/football/nfl/teams";
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
        JSONArray leaguesArray = jsonResponse.getJSONArray("sports").getJSONObject(0).getJSONArray("leagues");
        JSONArray teamsArray = leaguesArray.getJSONObject(0).getJSONArray("teams");

        FootBallTeam[] teams = new FootBallTeam[teamsArray.length()];

        for (int i = 0; i < teamsArray.length(); i++) {
            JSONObject teamObject = teamsArray.getJSONObject(i).getJSONObject("team");
            String teamName = teamObject.getString("displayName");
            int teamID = teamObject.getInt("id");

            JSONArray logosArray = teamObject.getJSONArray("logos");
            String teamLogo = logosArray.getJSONObject(0).getString("href");

            teams[i] = new FootBallTeam(teamID, teamName, teamLogo);

            System.out.println("Team ID: " + teamID);
            System.out.println("Team Name: " + teamName);
            System.out.println("Team Logo: " + teamLogo);
            System.out.println("-----------------------------");
        }


        return teams;
    }

    public static BasketBallTeam[] fetchBasketballTeams() throws Exception {
        String urlString = "https://site.api.espn.com/apis/site/v2/sports/basketball/nba/teams"; // Adjust URL for basketball teams
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
        JSONArray leaguesArray = jsonResponse.getJSONArray("sports").getJSONObject(0).getJSONArray("leagues");
        JSONArray teamsArray = leaguesArray.getJSONObject(0).getJSONArray("teams");

        BasketBallTeam[] teams = new BasketBallTeam[teamsArray.length()];

        for (int i = 0; i < teamsArray.length(); i++) {
            JSONObject teamObject = teamsArray.getJSONObject(i).getJSONObject("team");
            String teamName = teamObject.getString("displayName");
            int teamID = teamObject.getInt("id");

            JSONArray logosArray = teamObject.getJSONArray("logos");
            String teamLogo = logosArray.getJSONObject(0).getString("href");

            teams[i] = new BasketBallTeam(teamID, teamName, teamLogo);

            System.out.println("Team ID: " + teamID);
            System.out.println("Team Name: " + teamName);
            System.out.println("Team Logo: " + teamLogo);
            System.out.println("-----------------------------");
        }

        return teams;
    }
}

