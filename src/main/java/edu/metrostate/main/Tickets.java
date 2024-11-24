package edu.metrostate.main;

import edu.metrostate.ApplicationController.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Tickets implements Initializable {

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
    private Hyperlink hyperlink;

    public void openBasketballTicketMaster(ActionEvent event)throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.ticketmaster.com/discover/sports?classificationId=KnvZfZ7vAde"));
    }

    public void openFootballTicketMaster(ActionEvent event)throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.ticketmaster.com/discover/sports?classificationId=KnvZfZ7vAdE"));
    }

    public void openSoccerTicketMaster(ActionEvent event)throws URISyntaxException, IOException{
        Desktop.getDesktop().browse(new URI("https://www.ticketmaster.com/discover/sports?classificationId=KnvZfZ7vA7E"));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
                DBUtils.changeScene(event, "/edu/metrostate/fxml/Tickets.fxml", "Ticket");
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
