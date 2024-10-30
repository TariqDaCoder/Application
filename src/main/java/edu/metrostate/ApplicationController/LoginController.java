package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.User;
import edu.metrostate.ApplicationModel.UserManager;
import edu.metrostate.main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Method to handle login action
    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Email or Password cannot be empty.", Alert.AlertType.ERROR);
            return;
        }

        // Validate credentials
        User user = authenticateUser(email, password);

        if (user != null) {
            showAlert("Success", "Login successful. Welcome, " + user.getFirstName() + "!", Alert.AlertType.INFORMATION);

            // Close the login stage
            stage.close();
//            try {
//                // Load the dashboard
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("edu/metrostate/main/resources/dashboard.fxml"));
//                Parent dashboardRoot = loader.load();
//
//                // Use the same stage for the dashboard
//                stage.getScene().setRoot(dashboardRoot);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        } else {
            showAlert("Error", "Invalid email or password. Please try again.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleSignUp() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/edu/metrostate/fxml/signup.fxml"));
            Parent root = loader.load();

            SignUpController signUpController = loader.getController();
            signUpController.setStage(stage);

            // Assuming you use the same stage for login and signup
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Authenticate user by checking email and password
    private User authenticateUser(String email, String password) {
        for (User user : UserManager.getUserList()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Utility function to show alerts
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}