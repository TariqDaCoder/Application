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
            feedbackLabel.setText("Login successful!");
        } else {
            feedbackLabel.setText("Invalid credentials.");
        }
    }

    // Method to validate credentials
    public boolean isValidCredentials(String username, String password) {
        for (User user : User.getUserList()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
