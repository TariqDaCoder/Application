package edu.metrostate.PageController;

import edu.metrostate.ApplicationController.DBUtils;
import edu.metrostate.ApplicationController.GameController;
import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.ApplicationController.GameAPIClient;
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

import java.net.URI;
import java.net.URL;
import java.util.*;
import java.awt.Desktop;


public class StreamLive implements Initializable {

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
    private Button button_live;
    @FXML
    private Button button_upcoming;
    @FXML
    private Button button_browse;

    @FXML
    private Label label_noGamesFound;


    @FXML
    public ListView<Game> liveGameListView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            GameAPIClient gameClient = new GameAPIClient();
            List<Game> liveFootballGames = gameClient.fetchLiveFootballGames();
            List<Game> liveBasketballGames = gameClient.fetchLiveBasketballGames();

            List<Game> liveGames = new ArrayList<>();
            liveGames.addAll(liveFootballGames);
            liveGames.addAll(liveBasketballGames);


            if (liveGames.isEmpty()) {
                label_noGamesFound.setText("No live games");
                liveGameListView.setVisible(false);
            } else {
                label_noGamesFound.setText("");
                liveGameListView.setVisible(true);

                liveGameListView.setCellFactory(listView -> new ListCell<>() {
                    private final VBox vbox = new VBox(10);

                    private final ImageView awayLogo = new ImageView();
                    private final Label awayTeamName = new Label();
                    private final Label awayTeamPoints = new Label();

                    private final ImageView homeLogo = new ImageView();
                    private final Label homeTeamName = new Label();
                    private final Label homeTeamPoints = new Label();


                    private final Label shortNameLabel = new Label();
                    private final Label shortDetailLabel = new Label();
                    private final Label broadcastLabel = new Label();

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

                            String broadcastLink = GameController.getGameType(game);

                            broadcastLabel.setText("Broadcast: " + game.getBroadcast());

                            broadcastLabel.setOnMouseClicked(event -> openLink(broadcastLink));
                            broadcastLabel.setStyle("-fx-text-fill: blue; -fx-underline: true;");


                            awayTeamName.setText(game.getAwayTeamDisplayName());
                            homeTeamName.setText(game.getHomeTeamDisplayName());

                            // Check if game is an instance of LiveGame and cast it
                            if (game instanceof Game.LiveGame) {
                                Game.LiveGame liveGame = (Game.LiveGame) game;  // Cast game to LiveGame
                                awayTeamPoints.setText(liveGame.getAwayPoints());
                                homeTeamPoints.setText(liveGame.getHomePoints());
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

                            vbox.getChildren().setAll(homeLogo, homeTeamName, homeTeamPoints, awayLogo, awayTeamName, awayTeamPoints, shortNameLabel, shortDetailLabel, broadcastLabel);
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

                liveGameListView.getItems().addAll(liveGames);
            }

        } catch (Exception e) {
            System.out.println("Error fetching games: " + e.getMessage());
            e.printStackTrace();
        }






        button_home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/Home.fxml", "Home");
            }
        });


        button_scores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/Scores.fxml", "Scores");
            }
        });

        button_stream.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/StreamLive.fxml", "Stream");
            }
        });

        button_tickets.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/Tickets.fxml", "Stream");
            }
        });

        button_account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!Login.isLoggedIn()) {
                    DBUtils.changeScene(event, "/edu/metrostate/PageView/Login.fxml", "Login");
                } else {
                    DBUtils.changeScene(event, "/edu/metrostate/PageView/AccountInfo.fxml", "Account");
                }
            }
        });

        button_live.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/StreamLive.fxml", "Stream");
            }
        });

        button_upcoming.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/StreamUpcoming.fxml", "Stream");
            }
        });

        button_browse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/StreamBrowse.fxml", "Stream");
            }
        });
    }


    private static void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
