package edu.metrostate.PageController;

import edu.metrostate.ApplicationController.DBUtils;

import edu.metrostate.ApplicationController.GameLogger;
import edu.metrostate.ApplicationModel.Game;
import edu.metrostate.ApplicationModel.Sport;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class ScoresBrowse implements Initializable {

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
    private Button button_liveScores;
    @FXML
    private Button button_browseScores;

    @FXML
    private TextField textField_searchByTeam;
    @FXML
    private DatePicker datePicker_searchByDate;
    @FXML
    private ChoiceBox<Sport> choiceBox_searchBySport;
    @FXML
    private Button button_searchGames;


    private String searchByTeam;
    private String searchByDate;
    private String searchBySport;


    @FXML
    public ListView<Game> scoreListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choiceBox_searchBySport.getItems().addAll(Sport.getSportsList());
        choiceBox_searchBySport.setConverter(new StringConverter<>() {
            @Override
            public String toString(Sport sport) {
                return sport != null ? sport.getSportName() : "";
            }

            @Override
            public Sport fromString(String string) {
                return Sport.getSportsList().stream().filter(sport -> sport.getSportName().equals(string)).findFirst().orElse(null);
            }
        });

        button_searchGames.setOnAction(event -> {
             searchByTeam = textField_searchByTeam.getText().trim();
             searchByDate = datePicker_searchByDate.getValue() != null ? datePicker_searchByDate.getValue().toString() : null;
             searchBySport = choiceBox_searchBySport.getValue() != null ? choiceBox_searchBySport.getValue().getSportName() : null;

            try {
                List<Game> filteredGames = GameLogger.fetchGamesFromJson(searchByDate, searchBySport, searchByTeam);

                scoreListView.getItems().clear();
                scoreListView.getItems().addAll(filteredGames);

                if (filteredGames.isEmpty()) {
                    label_noGamesFound.setText("No games match the search criteria.");
                    scoreListView.setVisible(false);
                } else {
                    label_noGamesFound.setText("");
                    scoreListView.setVisible(true);
                }
            } catch (IOException e) {
                System.out.println("Error reading games from file: " + e.getMessage());
            }
        });

        scoreListView.setCellFactory(listView -> new ListCell<Game>() {
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

            @Override
            protected void updateItem(Game game, boolean empty) {
                super.updateItem(game, empty);

                if (empty || game == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    shortNameLabel.setText(game.getShortName());
                    shortDetailLabel.setText(game.getShortDetail());
                    homeTeamName.setText(game.getHomeTeamDisplayName());
                    awayTeamName.setText(game.getAwayTeamDisplayName());

                    String homePointsText = game.getHomePoints() != null ? game.getHomePoints() : "N/A";
                    String awayPointsText = game.getAwayPoints() != null ? game.getAwayPoints() : "N/A";
                    homeTeamPoints.setText(homePointsText);
                    awayTeamPoints.setText(awayPointsText);

                    date.setText(game.getDate() != null ? game.getDate() : "TBD");

                    loadImage(game.getHomeTeamLogo(), homeLogo);
                    loadImage(game.getAwayTeamLogo(), awayLogo);

                    awayLogo.setFitWidth(25);
                    awayLogo.setPreserveRatio(true);
                    homeLogo.setFitWidth(25);
                    homeLogo.setPreserveRatio(true);

                    vbox.getChildren().setAll(date, homeLogo, homeTeamName, homeTeamPoints, awayLogo, awayTeamName, awayTeamPoints, shortNameLabel, shortDetailLabel);
                    setGraphic(vbox);
                }
            }

            private void loadImage(String url, ImageView imageView) {
                if (url != null) {
                    imageView.setImage(new Image(url));
                }
            }
        });


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

        button_liveScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/Scores.fxml", "Live Scores");
            }
        });

        button_browseScores.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/PageView/ScoresBrowse.fxml", "Browse Scores");
            }
        });
    }
}
