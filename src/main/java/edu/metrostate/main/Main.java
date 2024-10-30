package edu.metrostate.main;
import edu.metrostate.ApplicationController.LoginController;
import edu.metrostate.ApplicationModel.UserManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class Main extends Application {


    public void start(Stage primaryStage) {
        UserManager.loadUsers();
        try {
            // Load login.fxml and set it as the initial scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/edu/metrostate/fxml/Login.fxml"));
            Parent root = loader.load();

            // Get the controller instance for LoginController and set the primary stage
            LoginController loginController = loader.getController();
            loginController.setStage(primaryStage); // Pass the primary stage

            // Set up the scene and show the stage
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Login"); // Set the window title if desired
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}