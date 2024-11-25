package edu.metrostate.PageController;

import edu.metrostate.ApplicationController.DBUtils;
import edu.metrostate.ApplicationController.GameAPIClient;
import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.ApplicationModel.Sport;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.*;

public class StreamBrowse implements Initializable {

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
    private TextField textField_searchByTeam;
    @FXML
    private ChoiceBox<Sport> choiceBox_searchBySport;
    @FXML
    private Button button_searchGames;


    private String searchByTeam;
    private Sport searchBySport;



    @FXML
    public ListView<Game> scoreListView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            List<Game> Games = getGames();

            if (Games.isEmpty()) {
                label_noGamesFound.setText("No Scheduled games");
                scoreListView.setVisible(false);
            } else {
                label_noGamesFound.setText("");
                scoreListView.setVisible(true);

                choiceBox_searchBySport.getItems().addAll(Sport.getSportsList());
                choiceBox_searchBySport.setConverter(new StringConverter<Sport>() {
                    @Override
                    public String toString(Sport sport) {
                        return sport != null ? sport.getSportName() : "";
                    }

                    @Override
                    public Sport fromString(String string) {
                        return Sport.getSportsList().stream()
                                .filter(sport -> sport.getSportName().equals(string))
                                .findFirst()
                                .orElse(null);
                    }
                });

                // Add action for the search button
                button_searchGames.setOnAction(event -> {
                    try {
                        Sport selectedSport = choiceBox_searchBySport.getValue();
                        String searchByTeam = textField_searchByTeam.getText().trim().toLowerCase();

                        List<Game> filteredGames = Games.stream().filter(game -> {
                                    boolean sportMatches = (selectedSport == null || selectedSport.getSportName().equalsIgnoreCase(game.getSport().getSportName()));
                                    boolean teamMatches = (searchByTeam.isEmpty() || game.getHomeTeamDisplayName().toLowerCase().contains(searchByTeam) || game.getAwayTeamDisplayName().toLowerCase().contains(searchByTeam));
                                    return sportMatches && teamMatches;}).toList();

                        scoreListView.getItems().clear();
                        scoreListView.getItems().addAll(filteredGames);

                        if (filteredGames.isEmpty()) {
                            label_noGamesFound.setText("No games match the search criteria.");
                            scoreListView.setVisible(false);
                        } else {
                            label_noGamesFound.setText("");
                            scoreListView.setVisible(true);
                        }
                    } catch (Exception e) {
                        System.out.println("Error while filtering games: " + e.getMessage());
                        label_noGamesFound.setText("An error occurred during search.");
                    }
                });

                scoreListView.setCellFactory(listView -> new ListCell<>() {
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

                scoreListView.getItems().addAll(Games);
            }

        } catch (Exception e) {
            System.out.println("Error fetching games: " + e.getMessage());
            e.printStackTrace();
            label_noGamesFound.setText("An error occurred while fetching games.");
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

    private static List<Game> getGames() throws Exception {
        GameAPIClient gameClient = new GameAPIClient();

        List<Game> scheduledFootballGames = gameClient.fetchScheduledFootballGames();
        List<Game> scheduledBasketballGames = gameClient.fetchScheduledBasketballGames();
        List<Game> liveBasketballGames = gameClient.fetchLiveBasketballGames();
        List<Game> liveFootballGamesGames = gameClient.fetchLiveFootballGames();


        List<Game> Games = new ArrayList<>();
        Games.addAll(scheduledFootballGames);
        Games.addAll(scheduledBasketballGames);
        Games.addAll(liveBasketballGames);
        Games.addAll(liveFootballGamesGames);
        return Games;
    }
}
