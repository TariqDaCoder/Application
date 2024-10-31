package edu.metrostate.main;

import edu.metrostate.ApplicationController.DBUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccount  implements Initializable {

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
    private Button button_createAccount;

    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;


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
                DBUtils.changeScene(event, "/edu/metrostate/fxml/Tickets.fxml", "Tickets");
            }
        });

        button_account.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "/edu/metrostate/fxml/AccountInfo.fxml", "Account");
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

        button_createAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!tf_email.getText().trim().isEmpty()  && !tf_password.getText().trim().isEmpty()){
                    DBUtils.signUpUser(event, tf_email.getText(), tf_password.getText());
                }else{
                    System.out.println("Entry fields are empty");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please enter all fields");
                    alert.show();
                }
            }
        });


    }
}
