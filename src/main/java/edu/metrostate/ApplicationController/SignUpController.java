package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.User;
import edu.metrostate.ApplicationModel.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;

public class SignUpController {

    @FXML
    private TextField firstNameField, lastNameField, emailField;
    @FXML
    private PasswordField passwordField, confirmPasswordField;
    private Stage stage;

    // Setter method for stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Method to handle registration action
    @FXML
    private void handleRegister() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Input validation
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert("Error", "Please fill out all fields.", Alert.AlertType.ERROR);
            return;
        }
        if (!password.equals(confirmPassword)) {
            showAlert("Error", "Passwords do not match.", Alert.AlertType.ERROR);
            return;
        }
        if (UserManager.isEmailRegistered(email)) {
            showAlert("Error", "Email is already registered.", Alert.AlertType.ERROR);
            return;
        }

        // Register the user
        User newUser = new User(User.generateUserId(), firstName, lastName, email, password, "defaultProfilePic.jpg");
        if (UserManager.addUser(newUser)) {
            showAlert("Success", "Registration successful! Please log in.", Alert.AlertType.INFORMATION);
            redirectToLogin();
        } else {
            showAlert("Error", "User registration failed.", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void redirectToLogin() {
        // Code to switch back to login screen goes here
        // Assuming you use the same stage for both login and signup
        if (stage == null) {
            System.out.println("Stage is not set! Cannot redirect to login.");
            return; // Exit the method if stage is not set
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/edu/metrostate/fxml/Login.fxml"));
            Parent root = loader.load();

            // Assuming you have access to the primary stage
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}