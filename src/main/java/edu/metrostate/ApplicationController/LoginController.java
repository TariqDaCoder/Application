package edu.metrostate.ApplicationController;

import edu.metrostate.ApplicationModel.User; // Ensure to import the User class
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField usernameField; // Injected from FXML
    @FXML
    private PasswordField passwordField; // Injected from FXML
    @FXML
    private Label feedbackLabel; // Injected from FXML

    // Method to handle login button action
    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("Entered Username: " + username);
        System.out.println("Entered Password: " + password);

        if (isValidCredentials(username, password)) {
            feedbackLabel.setText("Login successful!"); // Show success message
            // Navigate to the account page (implement it)
            // primaryStage.setScene(new Account().createScene(primaryStage));
        } else {
            feedbackLabel.setText("Invalid credentials."); // Show error message
        }
    }

    // Method to validate credentials
    public boolean isValidCredentials(String username, String password) {
        for (User user : User.getUserList()) { // Iterate through the user list
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true; // Valid credentials found
            }
        }
        return false; // No valid credentials found
    }
}
