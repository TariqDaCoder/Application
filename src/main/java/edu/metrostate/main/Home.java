package edu.metrostate.main;

import edu.metrostate.ApplicationController.DBUtils;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Home extends Application implements Initializable {

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/edu/metrostate/fxml/Home.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Home Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    } catch (Exception e){
        e.printStackTrace();
    }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

    public static void main(String[] args) {
        launch(args);
    }


}
