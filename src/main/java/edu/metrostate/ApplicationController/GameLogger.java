package edu.metrostate.ApplicationController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.metrostate.ApplicationModel.Game;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
        // Read existing games from the JSON file (if it exists)
        List<Game> gameHistory = readGameHistory();

        // Check if the game already exists in the history
        if (!gameExists(game, gameHistory)) {
            gameHistory.add(game);  // If not, add the new game
        }

        // Write the updated game list back to the JSON file
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

    private static boolean gameExists(Game newGame, List<Game> gameHistory) {
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
}
