package edu.metrostate.ApplicationController;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.ApplicationModel.Sport;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameLogger {

    private static final String JSON_FILE_PATH = "games.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();



    public static void logToFile(String json) {
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH, true)) {
            writer.write(json);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addGameToHistory(Game game) {
        List<Game> gameHistory = readGameHistory();

        if (!gameExists(game, gameHistory)) {
            gameHistory.add(game);
        }

        writeGameHistory(gameHistory);
    }

    private static List<Game> readGameHistory() {
        try {
            FileReader reader = new FileReader(JSON_FILE_PATH);
            Gson gson = new Gson();
            Type gameListType = new TypeToken<List<Game>>(){}.getType();
            List<Game> gameHistory = gson.fromJson(reader, gameListType);
            reader.close();

            return (gameHistory != null) ? gameHistory : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static boolean gameExists(Game newGame, List<Game> gameHistory) {
        for (Game game : gameHistory) {
            if (game.getName().equals(newGame.getName()) && game.getSport().getSportName().equals(newGame.getSport().getSportName())) {
                return true;
            }
        }
        return false;
    }

    private static void writeGameHistory(List<Game> gameHistory) {
        try {
            FileWriter writer = new FileWriter(JSON_FILE_PATH);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(gameHistory, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Game> readGames() {
        File file = new File(JSON_FILE_PATH);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<Game>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Game> fetchGamesFromJson(String searchByDate, String searchBySport, String searchByTeam) throws IOException {
        FileReader reader = new FileReader(JSON_FILE_PATH);
        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
        reader.close();

        if (jsonElement.isJsonArray()) {
            JsonArray gamesArray = jsonElement.getAsJsonArray();

            List<Game> filteredGames = new ArrayList<>();

            List<Sport> sportsList = Sport.getSportsList();

            for (int i = 0; i < gamesArray.size(); i++) {
                JsonObject gameObj = gamesArray.get(i).getAsJsonObject();
                JsonObject sportObj = gameObj.getAsJsonObject("sport");
                String sportName = sportObj != null && sportObj.has("sportName") ? sportObj.get("sportName").getAsString() : "Unknown";
                String statusName = gameObj.has("statusName") ? gameObj.get("statusName").getAsString() : "Unknown";
                String name = gameObj.has("name") ? gameObj.get("name").getAsString() : "Unknown";
                String shortName = gameObj.has("shortName") ? gameObj.get("shortName").getAsString() : "Unknown";
                String detail = gameObj.has("detail") ? gameObj.get("detail").getAsString() : "Unknown";
                String shortDetail = gameObj.has("shortDetail") ? gameObj.get("shortDetail").getAsString() : "Unknown";
                String broadcast = gameObj.has("broadcast") ? gameObj.get("broadcast").getAsString() : "N/A";
                String awayTeamName = gameObj.has("awayTeamName") ? gameObj.get("awayTeamName").getAsString() : "Unknown";
                String homeTeamName = gameObj.has("homeTeamName") ? gameObj.get("homeTeamName").getAsString() : "Unknown";
                String awayTeamId = gameObj.has("awayTeamId") ? gameObj.get("awayTeamId").getAsString() : "Unknown";
                String homeTeamId = gameObj.has("homeTeamId") ? gameObj.get("homeTeamId").getAsString() : "Unknown";
                String awayTeamLogo = gameObj.has("awayTeamLogo") ? gameObj.get("awayTeamLogo").getAsString() : "N/A";
                String homeTeamLogo = gameObj.has("homeTeamLogo") ? gameObj.get("homeTeamLogo").getAsString() : "N/A";
                String date = gameObj.has("date") ? gameObj.get("date").getAsString() : "N/A";
                String homePoints = gameObj.has("homePoints") ? gameObj.get("homePoints").getAsString().replace(" PTS", "") : "0";
                String awayPoints = gameObj.has("awayPoints") ? gameObj.get("awayPoints").getAsString().replace(" PTS", "") : "0";

                Sport sport = null;
                for (Sport s : sportsList) {
                    if (s.getSportName().equalsIgnoreCase(sportName)) {
                        sport = s;
                        break;
                    }
                }

                if (sport == null) {
                    continue;
                }

                if (matchesFilters(searchBySport, sportName, searchByTeam, homeTeamName, awayTeamName, searchByDate, date)) {
                    Game game = new Game(sport, statusName, name, shortName, detail, shortDetail, broadcast,
                            awayTeamName, awayPoints, homeTeamName, homePoints, awayTeamId, homeTeamId, awayTeamLogo, homeTeamLogo, date);

                    filteredGames.add(game);
                }
            }

            return filteredGames;
        } else {
            throw new JsonSyntaxException("Expected a JsonArray but found: " + jsonElement.getClass());
        }
    }

    private static boolean matchesFilters(String searchBySport, String sportName, String searchByTeam, String homeTeamName, String awayTeamName, String searchByDate, String jsonDate) {
        if (searchBySport != null && !sportName.equalsIgnoreCase(searchBySport)) {
            return false;
        }

        if (searchByTeam != null && !(homeTeamName.toLowerCase().contains(searchByTeam.toLowerCase()) || awayTeamName.toLowerCase().contains(searchByTeam.toLowerCase()))) {
            return false;
        }

        if (searchByDate != null) {
            try {
                LocalDate searchDate = LocalDate.parse(searchByDate);
                LocalDate jsonParsedDate = LocalDate.parse(jsonDate.substring(0, 10));

                if (!searchDate.equals(jsonParsedDate)) {
                    return false;
                }
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format: " + e.getMessage());
                return false;
            }
        }
        return true;
    }


}
