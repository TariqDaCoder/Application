package edu.metrostate.main;

import edu.metrostate.ApplicationController.DBUtils;
import edu.metrostate.ApplicationController.GameLogger;
import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.jsonPackages.GameAPIClient;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class Scores implements Initializable {

    @FXML
    private Button button_home;
    @FXML
    private Button button_scores;
    @FXML
    private Button button_stream;
    @FXML
    private Button button_tickets;
    @FXML
    private Button button_account;

    @FXML
    private Label label_noGamesFound;


    @FXML
    public ListView<Game> scoreListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {


            GameAPIClient gameClient = new GameAPIClient();
            List<Game> finalFootballGames = gameClient.fetchFootballGamesScores();
            List<Game> finalBasketballGames = gameClient.fetchBasketballGamesScores();

            List<Game> finalGames = new ArrayList<>();
            finalGames.addAll(finalFootballGames);
            finalGames.addAll(finalBasketballGames);

            Game.logAllGamesToJson();
            for (Game game : finalGames) {
                GameLogger.addGameToHistory(game);
            }

            if (finalGames.isEmpty()) {
                label_noGamesFound.setText("No final games");
                scoreListView.setVisible(false);
            } else {
                label_noGamesFound.setText("");
                scoreListView.setVisible(true);

                scoreListView.setCellFactory(listView -> new ListCell<>() {
                    private final VBox vbox = new VBox(10);

                    private final ImageView awayLogo = new ImageView();
                    private final Label awayTeamName = new Label();
                    private final Label awayTeamPoints = new Label();

                    private final ImageView homeLogo = new ImageView();
                    private final Label homeTeamName = new Label();
                    private final Label homeTeamPoints = new Label();


                    private final Label shortNameLabel = new Label();
                    private final Label shortDetailLabel = new Label();

                    private final Label date = new Label();

                    private Map<String, Image> imageCache = new HashMap<>();

                    @Override
                    protected void updateItem(Game game, boolean empty) {
                        super.updateItem(game, empty);

                        if (empty || game == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            shortNameLabel.setText(game.getShortName());
                            shortDetailLabel.setText(game.getShortDetail());

                            awayTeamName.setText(game.getAwayTeamDisplayName());
                            homeTeamName.setText(game.getHomeTeamDisplayName());

                            // Check if game is an instance of GameFinal and cast it
                            if (game instanceof Game.GameFinal) {
                                Game.GameFinal gameFinal = (Game.GameFinal) game;  // Cast game to Gamefinal
                                awayTeamPoints.setText(gameFinal.getAwayPoints());
                                homeTeamPoints.setText(gameFinal.getHomePoints());
                                date.setText(gameFinal.getDate());
                            } else {
                                awayTeamPoints.setText("N/A");
                                homeTeamPoints.setText("N/A");
                            }

                            loadImage(game.getAwayTeamLogo(), awayLogo);
                            loadImage(game.getHomeTeamLogo(), homeLogo);

                            awayLogo.setFitWidth(25);
                            awayLogo.setPreserveRatio(true);
                            homeLogo.setFitWidth(25);
                            homeLogo.setPreserveRatio(true);


                            vbox.getChildren().setAll(date, homeLogo, homeTeamName, homeTeamPoints, awayLogo, awayTeamName, awayTeamPoints, shortNameLabel);
                            setGraphic(vbox);
                        }
                    }


                    private void loadImage(String url, ImageView imageView) {
                        // Check cache first
                        if (imageCache.containsKey(url)) {
                            imageView.setImage(imageCache.get(url));
                        } else {
                            Task<Image> loadTask = new Task<>() {
                                @Override
                                protected Image call() throws Exception {
                                    return new Image(url);
                                }
                            };

                            loadTask.setOnSucceeded(event -> {
                                Image image = loadTask.getValue();
                                imageCache.put(url, image);  // Cache the image
                                imageView.setImage(image);
                            });

                            new Thread(loadTask).start();
                        }
                    }
                });

                scoreListView.getItems().addAll(finalGames);
            }

        } catch (Exception e) {
            System.out.println("Error fetching games: " + e.getMessage());
            e.printStackTrace();
        }

        button_home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/Home.fxml", "Home");
            }
        });


        button_scores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/Scores.fxml", "Scores");
            }
        });

        button_stream.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/StreamLive.fxml", "Stream");
            }
        });

        button_tickets.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/Tickets.fxml", "Stream");
            }
        });

        button_account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!Login.isLoggedIn()) {
                    DBUtils.changeScene(event, "/edu/metrostate/fxml/Login.fxml", "Login");
                } else {
                    DBUtils.changeScene(event, "/edu/metrostate/fxml/AccountInfo.fxml", "Account");
                }
            }
        });
    }
}
