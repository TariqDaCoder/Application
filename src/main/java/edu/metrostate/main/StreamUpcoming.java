package edu.metrostate.main;

import edu.metrostate.ApplicationController.DBUtils;
import edu.metrostate.ApplicationController.GameController;
import edu.metrostate.ApplicationModel.FootBallTeam;
import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.ApplicationModel.Sport;
import edu.metrostate.ApplicationView.GameView;
import edu.metrostate.jsonPackages.ScheduledGameAPIClient;
import edu.metrostate.jsonPackages.TeamAPIClient;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import edu.metrostate.ApplicationModel.FootBallTeam;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class StreamUpcoming implements Initializable {

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
    public ListView<Game> scheduledGameListView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            GameController gameController = new GameController();
            List<Game> footballGames = gameController.getFootballGames();

            scheduledGameListView.setCellFactory(listView -> new ListCell<>() {
                private final VBox vbox = new VBox(10);
                private final ImageView awayLogo = new ImageView();
                private final ImageView homeLogo = new ImageView();
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
                        broadcastLabel.setText("Broadcast: " + game.getBroadcast());


                        loadImageAsync(game.getAwayTeamLogo(), awayLogo);
                        loadImageAsync(game.getHomeTeamLogo(), homeLogo);

                        awayLogo.setFitWidth(25);
                        awayLogo.setPreserveRatio(true);
                        homeLogo.setFitWidth(25);
                        homeLogo.setPreserveRatio(true);

                        vbox.getChildren().setAll(homeLogo, awayLogo, shortNameLabel, shortDetailLabel, broadcastLabel);
                        setGraphic(vbox);
                    }
                }

                private void loadImageAsync(String url, ImageView imageView) {
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

            scheduledGameListView.getItems().addAll(footballGames);

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

        button_live.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/StreamLive.fxml", "Stream");
            }
        });


        button_upcoming.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/StreamUpcoming.fxml", "Stream");
            }
        });

        button_browse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/StreamBrowse.fxml", "Stream");
            }
        });

    }
}
