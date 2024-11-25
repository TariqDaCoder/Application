package edu.metrostate.PageController;

import edu.metrostate.ApplicationController.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountInfo implements Initializable {

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
    private Button button_logout;


    @FXML
    private Label label_email;
    @FXML
    private Label label_password;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





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
                if (!Login.isLoggedIn() ) {
                    // User is not logged in, redirect to the login page
                    DBUtils.changeScene(event, "/edu/metrostate/PageView/Login.fxml", "Login");
                } else {
                    // User is logged in, redirect to the account page
                    DBUtils.changeScene(event, "/edu/metrostate/PageView/AccountInfo.fxml", "Account");
                    ;
                }
            }
        });

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login.setLoggedIn(false);
                DBUtils.changeScene(event, "/edu/metrostate/PageView/Login.fxml", "Login");
            }
        });

    }
    public void setAccountInfo(String email, String password){
        label_email.setText("Email " + email);
        label_password.setText("Password: " + password);
    }


}
