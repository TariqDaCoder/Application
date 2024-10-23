package edu.metrostate.ApplicationController;

import edu.metrostate.main.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class DBUtils {

    public static void changeScene(ActionEvent event, String fxmlFile, String title){
        Parent root = null;

        try {
            root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 430, 932));
        stage.show();
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mariadb://kxdomain.com:3306/sportsApplicationDataBase", "user_name", "user_password");
            preparedStatement = connection.prepareStatement("SELECT password, email, profilePicture FROM userAccount WHERE userName = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found ");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username or Password are Incorrect");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedEmail = resultSet.getString("email");
                    String retrievedProfilePicture = resultSet.getString("profilePicture");

                    if (retrievedPassword.equals(password)) {
                        Login.setLoggedIn(true);
                        changeScene(event, "/edu/metrostate/fxml/AccountInfo.fxml", "AccountInfoLoggedIn");
                    } else {
                        System.out.println("Password Invalid");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The password entered doesn't match");
                        alert.show();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void signUpUser(ActionEvent event, String email, String username, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mariadb://kxdomain.com:3306/sportsApplicationDataBase", "user_name", "user_password");
            psCheckUserExist = connection.prepareStatement("SELECT * FROM userAccount WHERE userName = ?");
            psCheckUserExist.setString(1, username);
            resultSet = psCheckUserExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO userAccount (email, username, password) VALUES (?, ?, ?)");
                psInsert.setString(1, email);
                psInsert.setString(2, username);
                psInsert.setString(3, password);
                psInsert.executeUpdate();

                // Show success alert
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Your account has been created successfully!");
                successAlert.showAndWait();

                changeScene(event, "/edu/metrostate/fxml/Login.fxml", "Login");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExist != null) {
                try {
                    psCheckUserExist.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}


